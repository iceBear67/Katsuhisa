# 插件，权限，命令

在开服后，我们将会学习关于`server.properties`的部分内容和插件的安装，了解权限系统和命令。

## server.properties

>  在开启服务端后，产生了大量的配置文件。但本章只会简单讲解一下`server.properties`的一些你必须知道的内容。
>
> 关于`bukkit spigot.yml`一类文件，关系到服务器调优，作为单独的章节在后头讲。
>
> 该章节较为枯燥，请耐心观看

[若您尚未习得如何读配置文件](Config.md)

这是每个 Minecraft 服务端都有的东西，用于描述服务器基本设定。

本章只会讲解几个**您必须知道的**，而不是[所有内容](https://minecraft-zh.gamepedia.com/Server.properties)。

1. `online-mode`

   用于开启正版验证，默认为`true`。（对于盗版玩家）若您发现无法进入服务器，请改成`false`

2. `port`

   服务器端口。一个程序不能绑定到一个已经存在的端口上，所以当其他程序占用了默认的端口(25565)时，请更改此项。(范围: 1~65535)

3. `spawn-protection`

   关于世界出生点的保护。默认为16，若您发现无OP无法破坏方块请更改为 0

4. `level-name`

   世界存档名。默认为`world`，对应`world`，`world_nether (地狱)`,`world_the_end (末地)`文件夹

5. `enable-command-block`

   是否开启命令方块。

## 安装插件

下载[示例插件](../../examples/After_First_Start/1/ExamplePlugin.jar)到您服务端的`plugins`中，启动服务器，观察日志变化。  
[当插件只有源码时..](./Compile_Plugin.md)  

我们可以观察到：

> [13:39:29] [Server thread/INFO]: [EditConfig] Loading EditConfig v1.0-SNAPSHOT

这说明三件事情：

- 插件正在被加载
- 插件名字实际叫 `EditConfig`
- 插件版本号是 `1.0-SNAPSHOT` 

接着服务器崩溃。查看Logs我们可以发现一条信息：

> [13:39:29] [Server thread/INFO]: [EditConfig] Please turn on the config!

`turn on the config`，启用配置，什么意思呢？

此时返回`plugins`文件夹，我们会发现多了一个文件夹。

![2020-11-28_12-39.png](https://i.loli.net/2020/11/28/LzRK3q6r4otxbQf.png)

打开`EditConfig`文件夹，会发现里面包含一个`config.yml`。**config.yml 是大多数插件的默认配置文件名**

config.yml内容:

```yaml
 enable_me: false
```

开启`enable_me`，发现服务器可以正常启动。  
[若您尚未习得如何读配置文件](Config.md)  

此时您已成功安装并配置了 `EditConfig` 插件。( 注意： 其他插件没配置不一定就是启动不成功, 请参考插件自身介绍。 )  

> plugin.yml  
用任意压缩软件打开JAR，可以发现它。  
这是插件的自我描述文件，其中`name`是插件名。请读者试着修改这个属性并且让服务器加载修改后的插件。  
通过plugin.yml文件还可以看到插件的命令，权限等，在不开服调试的情况下可以快速了解插件信息。

## 解决依赖

[下载示例插件](../../examples/After_First_Start/1/SolveDependencies-1.0-SNAPSHOT.jar)并尝试安装。

```
[12:57:33] [Server thread/ERROR]: Could not load 'plugins/SolveDependencies-1.0-SNAPSHOT.jar' in folder 'plugins'
org.bukkit.plugin.UnknownDependencyException: lol
	at org.bukkit.plugin.SimplePluginManager.loadPlugins(SimplePluginManager.java:220) [spigot-1.13.2.jar:git-Spigot-1a3504a-84f3da3]
	at org.bukkit.craftbukkit.v1_13_R2.CraftServer.loadPlugins(CraftServer.java:325) [spigot-1.13.2.jar:git-Spigot-1a3504a-84f3da3]
	at net.minecraft.server.v1_13_R2.DedicatedServer.init(DedicatedServer.java:213) [spigot-1.13.2.jar:git-Spigot-1a3504a-84f3da3]
	at net.minecraft.server.v1_13_R2.MinecraftServer.run(MinecraftServer.java:698) [spigot-1.13.2.jar:git-Spigot-1a3504a-84f3da3]
	at java.lang.Thread.run(Thread.java:834) [?:?]
```

发现报错。根据`UnknownDependencyException`可知插件缺少前置插件，而前置插件名称叫`lol`

此时只要安装`lol`即可。那**插件哪里来**呢？

- SpigotMC : https://spigotmc.org/resources
- MCBBS : http://www.mcbbs.net
- Gooooooooooooooooogle

其实在网上是找不到这个插件的，这个插件也根本不存在，因此您根本无法启动这个插件。

不过，该插件**并不实际依赖于"lol"**。所以，如果您真的很想启动它，修改EditConfig的plugin.yml以伪装lol即可。（但是大多数情况下没人这么蛋疼添加一个无用依赖。）

## 权限

Bukkit具有一套权限系统，可以控制玩家能干什么。诸如`nullcat.hand.shot`这样的，且具有权限识别性质的文本我们管叫权限节点，权限节点由插件注册。

### 角色: OP

OP是OPerator的简称，意为~~狗~~管理员，所有向 op 检验的权限都会绝对为真（相当于拥有全部权限节点的能力）

因此不要随便给OP

通过指令`op 玩家名`给予权限，`deop op名`夺走权限。而控制台是Bukkit权限系统中的顶端（相当于等级 4的OP）~~但是插件不想让你用你还是用不了~~

### 权限管理器

虽然权限节点只能由插件注册，但我们可以控制权限节点的分发，不过我们需要一个权限管理器来做这件事情。

比较出名的有：

- LuckPerms 
- GroupManagerPlus
- PermissionEx

Katsuhisa 推荐使用 LuckPerms，但是如果无法接受 LuckPerms，使用 GroupManagerPlus 也是可以的

> LuckPerms Preview
>
> ![img](https://i.imgur.com/Ta7gtd9.png)
> 上图为权限调试器(/lp verbose)
>
> ![img](https://i.imgur.com/nkdtDkG.png)
>
> LuckPerms是一个强大的权限管理器，他灵活，强大，且性能好。
>
> https://luckperms.net/wiki/Why-LuckPerms

为了篇幅考虑，本文不会介绍如何使用LuckPerms，请参考LuckPerms WIKI

## 命令

插件通常具有命令以供操作。输入`/插件名:`+`TAB`后便可看到该插件的命令列表。

[关于命令的更多细节](../1/Command_And_Arguments.md)

同样的，**通常**在plugin.yml也可以看到插件所具有的命令列表以及对应描述。

# END

本章内容结束。根据这些知识，您可以开始:
 - 去构思你的服务器内容
 - 寻找插件
 - 安装并设置
 - 建成一个服务器！

若您感到有帮助，欢迎[赞助](https://afdian.net/@omgib67)或者点个Star！

[下一章](../3/The_Fucking_SpigotEcoSystem.md)将会讲解`服务端核心`相关。