

# 開発環境の準備

ここでは、Eclipse の使用を前提にしています。
Intelli J やVim / Emacs など、他のエディタ/IDEを使いたい人はぐぐるか、ここに追記していただけると助かります。

## Eclipse をインストールしよう

 - 割愛

## forge のソースコードを落とそう
 1. http://files.minecraftforge.net/ に行きます。
 2. 必要なMinecraft Forge のバージョンの Mdk と書いてある物をダウンロードし、解凍します。
 3. 以下のファイルを自分のプロジェクトフォルダにコピペします。
   - gradle
   - .gitignore
   - build.gradle
   - gradle.properties
   - gradlew
   - gradlew.bat
 4. コマンドプロンプト（あるいはPowershell あるいはターミナル）を開き、自分のプロジェクトフォルダに移動します。
 5. ``.\gradlew.bat setupDevWorkspace setupDecompWorkspace`` でforge のセットアップをします。
 6. ``.\gradlew.bat`` eclipse で、Eclipse のプロジェクトファイルを生成します。
 7. Eclipse を開き、作成した``.project``ファイルをインポートします。

 
## 参考にしたリンクなど
 - http://qiita.com/reginn666/items/d26717cf06ca17eb072c

