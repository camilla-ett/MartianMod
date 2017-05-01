
# プロキシ - proxy

Minecraft には、サーバーとクライアントの概念がある。例えばクライアント側では、クリーパーの爆発音を実際に鳴らす必要があるが、サーバー側は、クリーパーの爆発音が鳴るという事をクライアントに知らせる必要がある。

このように、クライアントとサーバーでの処理の違いを吸収してくれるのがプロキシである。
（と、理解しているのだけれど、違っていたらご指摘 or 修正PRください

## Proxy の作成

Server / Client 共通のプロキシを作成する。大体いかのようなコードになる

```CommonProxy.java

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {

    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}
```

このCommonProxy を親クラスに持つServerProxyとClientProxy　クラスをそれぞれ作成する。

```ServerProxy.java
import net.minecraftforge.fml.common.event.*;

public class ServerProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
}
```

ちなみに、ソースコード上で、右クリック -> Source -> Override/Implements Methods で一発でオーバーライドメソッドを追記することができる。便利。使っていこう。

## Modfile でプロキシの指定をする。

```Modfile.java
	@SidedProxy(clientSide = "mm.proxy.ClientProxy", serverSide = "mm.proxy.ServerProxy", modId = MODID)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit (FMLPreInitializationEvent event){
		// called before minecraft initialization
		proxy.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		// some example code
		proxy.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		// called after initialization
		proxy.postInit(event);
	}

```

こんな具合に書くことで、起動時にサーバーか、クライアントかを区別しプロキシの初期化コードが走る。

