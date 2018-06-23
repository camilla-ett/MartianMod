
# Registries

https://mcforge.readthedocs.io/en/latest/concepts/registries/ の 日本語訳に過ぎませんので、正しい情報がほしい方は原文を読むこと。


## 概要
Registration は mod のオブジェクト（アイテムやブロックやモブなど）をゲームに登録するプロセスです。
Registering は重要で、これをしないとゲームはこれらのオブジェクトを検知出来ず、大量の予測できないエラーやクラッシュを発生させます。

# Registring Things
推奨された登録方法は、 RegistryEvent を経由することです。これらのイベントは、初期化前の処理が終わった直後に発火され、``RegistryEvent.NewRegistry`` の中で、registries が作られるべきです。

# Registry を作成する

Class
ResourceLocation


There’s a global registry where all the other registries are stored. By taking a Class that a registry is supposed to store or its ResourceLocation name, one can retrieve a registry from this registry. For example, one can use GameRegistry.findRegistry(Block.class) to get the registry for blocks. Any mod can create their own registries, and any mod can register things to registries from any other mod. Registries are created by using RegistryBuilder inside a RegistryEvent.NewRegistry event handler. This class takes certain parameters for the registry it will generate, such as the name, the Class of it’s values, and various callbacks for when the registry is changed. Upon calling RegistryBuilder::create, the registry is built, registered to the metaregistry, and returned to the caller.
In order for a class to have a registry, it needs to implement IForgeRegistryEntry. This interface defines getRegistryName(ResourceLocation), setRegistryName(ResourceLocation), and getRegistryType(). getRegistryType is the base Class of the registry the object is to be registered to. It is recommended to extend the default IForgeRegistryEntry.Impl class instead of implementing IForgeRegistryEntry directly. This class also provides two convenience implementations of setRegistryName: one where the parameter is a single string, and one where there are two string parameters. The overload that takes a single string checks whether the input contains a : (i.e. it checks whether the passed in stringified ResourceLocation has a domain), and if it doesn’t, it uses the current modid as the resource domain. The two argument overload simply constructs the registry name using the modID as the domain and name as the path.
