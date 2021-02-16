# 使用 BuildTools 构建一个 Spigot
[Spigot Wiki上关于BuildTools的具体介绍](https://www.spigotmc.org/wiki/buildtools/) 会英文的直接看  

## 构建之前
我们需要准备构建环境。  
 - 构建需要准备好**JDK 8**，若您用的是第一篇开服教程提供的Java则不需要担心。
 - 安装 Git，并勾选在右键菜单中打开Git Bash的功能。
 - 保证你有通畅的网络环境，最好是能连上谷歌那种。
 - [下载BuildTools](https://hub.spigotmc.org/jenkins/job/BuildTools/lastSuccessfulBuild/artifact/target/BuildTools.jar)

[点击此处下载Git for Windows](https://github.com/git-for-windows/git/releases/latest)

## 开始构建
在你的桌面上建一个文件夹，管他叫`build`，然后把`BuildTools.jar`丢进去  
打开 `Git Bash`。若没有勾选上述选项可以在Windows搜索框中搜索 Git Bash 并打开，打开后使用:  
`cd /c/Users/你的用户名，要是不知道写Administrator/Desktop/build`  
接着输入`ls`，若出现了 `BuildTools.jar` 即可继续，如果没有请检查步骤。  
输入 `java -jar BuildTools.jar --rev 你需要构建的MC版本，例如1.16.5` 开始构建。  
[关于支持的版本列表](https://www.spigotmc.org/wiki/buildtools/#versions)  
静静等待过程，可能有一小时~30分钟~15分支不等。构建完毕后，和BuildTools.jar同目录下会有`CraftBukkit-XX版本.jar`和`Spigot-XX版本.jar`  

## 常见问题解答

Q: 我的BuildTools刚开始就卡着不动没输出了  
A：如果您**使用代理联网**，将启动命令改为:   
> java -DsocksProxyHost=`代理服务器地址，一般是localhost` -DsocksProxyPort=`代理服务器端口，一般是1080或者10808` -jar BuildTools.jar --rev `你需要构建的MC版本，例如1.16.5`