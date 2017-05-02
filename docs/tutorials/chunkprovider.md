
# ChunkProvider

[WorldType](./worldtype.md) の続き

独自のワールドを生成するための肝となる部分。チャンク生成時に読み込まれるクラス。

## 有名所のソースを参考にしよう！（爆

 - [Skyland](https://github.com/kegare/Skyland/blob/master/skyland/world/ChunkProviderSkyland.java)
 - [Quark](https://github.com/Vazkii/Quark/blob/master/src/main/java/vazkii/quark/world/world/WorldTypeRealistic.java)
  - [RTG](https://github.com/Team-RTG/Realistic-Terrain-Generation/tree/1.11.2-dev/src/main/java/rtg/world/gen)

 Quark はデフォルトのChunkProvider を流用しているため特筆点無し。最も注目すべきはRTGで、Biome単位でかなり大幅な改変をしているため、コードは膨大。


## ChunkProvider を作成

※ 正直私もよくわかってないので、大いに間違っている可能性アリ。
※ 加筆修正求む

以下のようにChunkProvider を作成する。Implements してるのGeneratorなのにProviderなの？？という疑問は私も持っているが、今はコレで。

```
package mm.world;

import java.util.List;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkGenerator;

public class MartinMarsChunkProvider implements IChunkGenerator {
	
	private final World world;
	
	public MartinMarsChunkProvider(World world){
		this.world = world;
	}

	@Override
	public Chunk provideChunk(final int cx, final int cz) {
		final Chunk chunk = new Chunk(world, new ChunkPrimer(), cx, cz);
		return chunk;
	}

	@Override
	public void populate(int x, int z) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean generateStructures(Chunk chunkIn, int x, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlockPos getStrongholdGen(World worldIn, String structureName, BlockPos position, boolean p_180513_4_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void recreateStructures(Chunk chunkIn, int x, int z) {
		// TODO Auto-generated method stub

	}

}
```

## WorldType にChunkProvider を指定しよう

作成したChunkProvider を、以下のような書き方でWorldType に追加する。

```
	@Override
	public IChunkGenerator getChunkGenerator(World world, String option)
	{
		return new MartinMarsChunkProvider(world);
	}

```

これで、何も生成されないvoid のWorldが生成される。重要なのは、provideChunk メソッド内の、ChunkPrimary が、具体的にどのブロックを置くのか決定していくらしい。

## 具体的にどのブロックを配置するか決定していく。

大体以下の手順で生成していく。

1. 大まかなブロックを配置していく
  - [RTGのここ](https://github.com/Team-RTG/Realistic-Terrain-Generation/blob/1.11.2-dev/src/main/java/rtg/world/gen/ChunkProviderRTG.java#L416)あたりが参考になるだろうか。石、水、空気を配置する。
  - 特にRTGが１番顕著だけど、バイオームに合わせてノイズを調整している。

2. すでに設置してある石を、バイオームに合わせて置換していく。（砂漠なら砂、平原なら草ブロックなど）

3. 岩盤を設置する。

4. 構造物を生成する。
 - 洞窟やダンジョン、村など。遠くにこだわりがなければデフォルトの生成をさせればいい。

