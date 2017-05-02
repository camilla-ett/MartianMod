package mm.io;

import java.io.*;
import java.awt.image.*;

import javax.imageio.ImageIO;

import mm.MartianMod;
import mm.UtilMM;
import mm.ConfigMM;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class MarsTopologyLoader{
	
	private final static String toporogyFileName = "mars_mola_bumpmap_8192x4096.jpg";
	private static MarsTopologyLoader instance = new MarsTopologyLoader();
	public int imgWidth;
	public int imgHeight;
	public byte[] topologyPixels;
	public int pixelLength;
	
	private MarsTopologyLoader()
	{
		try {
			InputStream in = Minecraft.getMinecraft().getResourceManager().getResource(getResourceLocation(toporogyFileName)).getInputStream();
			BufferedImage imgReader = ImageIO.read(in);
			imgWidth = imgReader.getWidth();
			imgHeight = imgReader.getHeight();
			topologyPixels = ((DataBufferByte) imgReader.getRaster().getDataBuffer()).getData();
			pixelLength = 1;
			if (imgReader.getAlphaRaster() != null) {
				pixelLength = 4;
			}
			System.out.println("width:"+imgWidth+" height:"+imgHeight+" pixel is "+pixelLength);
			System.out.println(topologyPixels.length);
			
		} catch (IOException e) {
			// want crash
			System.out.println("Failed to Load Mars Topology");
		}
	}
	
	private static ResourceLocation getResourceLocation(String fileName)
	{
		return new ResourceLocation(MartianMod.MODID+":"+fileName);
	}
	
	private static int getAltitude(int u, int v)
	{
		int pos = (v * instance.pixelLength * instance.imgWidth) + (u * instance.pixelLength);
		int gray = instance.topologyPixels[pos] & 0xFF;
		return gray;
	}

	public static int getElevation(final int x, final int z) {
		final int scale = ConfigMM.MartianMarsScale;
		
		int lx = x / scale;
		int lz = Math.abs(z)/scale;
		if (lx < 0) {
			int i = (lx / instance.imgWidth);
			lx = lx + (i+1) * instance.imgWidth;
		}
		if ((lz / instance.imgHeight) % 2 == 0 ) {
			lz = instance.imgHeight - 1 - lz;
		}
	
		if(scale == 1) {
			return getAltitude(lx, lz);
		} else {
			UtilMM.Pos2D pos[] = {
				new UtilMM.Pos2D(lx, lz),
				new UtilMM.Pos2D(lx+1 == instance.imgWidth ? lx : lx + 1, lz),
				new UtilMM.Pos2D(lx, lz+1 == instance.imgHeight ? lz : lz + 1),
				new UtilMM.Pos2D(lx+1 == instance.imgWidth ? lx : lx + 1, lz+1 == instance.imgHeight ? lz : lz + 1)
			};
			int altitudes[] = {
				getAltitude(pos[0].x, pos[0].z),
				getAltitude(pos[1].x, pos[1].z),
				getAltitude(pos[2].x, pos[2].z),
				getAltitude(pos[3].x, pos[3].z)
			};
			double centeralts[] = {
				(double)(altitudes[1] - altitudes[0]) / (double) (scale) * (double) (x >= 0 ? x % scale : x % scale + scale - 1) + (double) altitudes[0],
				(double)(altitudes[3] - altitudes[2]) / (double) (scale) * (double) (x >= 0 ? x % scale : x % scale + scale - 1) + (double) altitudes[2]
			};
			
			return (int)((centeralts[0] - centeralts[1]) / (double) (scale) * (double) (Math.abs(z) % scale) + centeralts[1]);
		}
	}
	
	public static MarsTopologyLoader getInstance()
	{
		return instance;
	}
}
