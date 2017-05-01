
# Worldtype

World Type の追加をやっていく。

WorldType はデフォルトで、DEFAULT, SUPERFLAT,LARGE_BIOMES, AMPLIFIED, CUSTOMIZED の5種類が存在する。これに、第六、第七のworld type を追加する。


## WorldType クラスの作成

以下のように、既存クラスをオーバーライドして、WorldType クラスを作成する。

```WorldTypeMartianMars.java
package mm.world;

import net.minecraft.world.WorldType;

public class WorldTypeMartianMars extends WorldType {

	public WorldTypeMartianMars() {
		super("martian_mars");
	}

}

```

続いて、CommonProxy.java のinit メソッドで、新たに作ったWorldTypeを登録する。

```CommonProxy.java
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		martianMars = new WorldTypeMartianMars();
	}

```

これで、ワールドの新規作成時に、追加したワールドタイプが選択出来るようになるが、まだLANGファイルを作成していないので、きっと「generator.martian_mars」と表示されているだろう。なので、``src/main/resouces/assets/modid/en_US.lang`` に必要な項目を書いていく

```en_US.lang
generator.martian_mars=Martian Mars
```


## 参考にしたリンク

 - [Skylandのgithub](https://github.com/kegare/Skyland)