package mm.io;

import java.io.*;
import java.awt.image.*;

import javax.imageio.ImageIO;

import mm.MartianMod;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class MarsTopologyLoader{
	
	private final static String toporogyFileName = "marsbump.jpg";
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
	
	private static double[] MinecraftWorldToLatLng(int x, int z)
	{
		double d = Math.sqrt(x*x + z*z);
		double t = Math.atan2(z, x);
		double R = 1250;
		double lat = t / (2 * Math.PI) * Math.sin(d/(R*Math.PI)) * 90;
		double lng = d / (2 * Math.PI * R) * 360.0;
		double ret[] = {lat, lng};
		return ret;
	}
	
	private static double[] LatLngToEuclid(double lat, double lng)
	{
		double u = instance.imgWidth * Math.cos(lat * 2 * Math.PI / 360.0) * lng / 360.0 + instance.imgWidth/2;
		double v = instance.imgHeight * lat / 180.0 + instance.imgHeight / 2;
		
		double ret[] = {u, v};
		return ret;
	}
	
	private static int getAltitude(int u, int v)
	{
		int pos = (v * instance.pixelLength * instance.imgWidth) + (u * instance.pixelLength);
		int gray = instance.topologyPixels[pos] & 0xFF;
		return gray;
	}

	static int counter = 0;
	
	public static int getElevation(int x, int z) {
		counter++;
		double tmp[] = MinecraftWorldToLatLng(x, z);
		if(counter % 256 == 0) System.out.printf("(%d, %d) -> (%f, %f)\n", x, z, tmp[0], tmp[1]);
		tmp = LatLngToEuclid(tmp[0], tmp[1]);
		return getAltitude((int)tmp[0], (int)tmp[1]);
	}
	
	public static MarsTopologyLoader getInstance()
	{
		return instance;
	}
}
