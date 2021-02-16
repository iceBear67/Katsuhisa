# 服务端体系
除了 `spigot-1.13.2` 当然还有别的服务端核心...我不是指`spigot-1.13.1`。  
下图是一个较为全面的思维导图，描述了Minecraft服务端核心体系。  


![Vanilla Minecraft Server.png](https://i.loli.net/2021/02/16/7wYCZ5Pid8U6nx4.png)

# 如何选择合适的服务端核心
有一说一，服务端核心体系确实乱，那么我们要怎么寻找合适的服务端核心呢？  
## Mod，插件

你需要先知道Mod和插件指的是什么。  
![image.png](https://i.loli.net/2021/02/16/rPqW25tiS1KpheB.png)
这是Mod，你可以看到他的明显特征是**添加了新的机制，新的方块，甚至新的GUI，新的生物**...它可以把 Minecraft 翻个底朝天，它几乎什么都能干。  
![image.png](https://i.loli.net/2021/02/16/gRHlMs8NOyIBoCD.png)
这些是插件，虽然看起来里面的机器是新的方块，但他们**实际上并不是**，这些都是原版内容，图中的方块只是头颅，悬浮的字体只是隐身的盔甲架的名字罢了。  
所以，区别也很显然了：
 - Mod 可以真正的修改 Minecraft
 - 插件只能利用客户端支持的内容，例如指令，材质包模型，头颅。

那么，既然Mod这么强大，又为什么要选择插件呢？这是因为插件其实也是Mod，但是它的意图正是为了**避免去修改客户端**，对于Mod来说，你每加一个修改了游戏内容的Mod你就要去在客户端同步加上一个一样的Mod，这除了麻烦以外也有[安全问题]()。有的Mod也可以只在服务端运行，但是由于服务端核心的策略，客户端仍然需要安装某些东西才能进入服务器。

![image.png](https://i.loli.net/2021/02/16/vbxRoAp5WCT1wFh.png)  

---
## API (Application Programming Interface)

> 为什么 Mod 不能当插件用呢？

这是因为它们所使用的 API 不同。  
举个例子。我们想让一个叫 NullCat 的玩家穿上女装  
一个用了 BukkitAPI 的插件: `从位于org.xxx的玩家管理器里拿出叫NullCat的玩家，然后给他设置女装属性为true`  
一个用了 ForgeAPI 的Mod: `从位于com.xxx的服务器里拿出叫NullCat的玩家，然后从女装仓库里面拿一件女装放到他的饰品栏里面`  
但如果你把用了 BukkitAPI 的插件交给 ForgeAPI ，而 ForgeAPI 并不存在`玩家管理器`，更不用说org.xxx了，因此将会直接无法运行，**它们之间代码的描述方法，API提供的功能有差异**。  

> Spigot 实现 Bukkit API 是什么意思？  
> 这涉及到了编程上的概念，读者可以暂时理解为 "可以在 Spigot 服务端上使用基于 BukkitAPI 的插件”，因为 Spigot 提供了 BukkitAPI 的一切功能。

---
## NMS  
  
~~重申一遍，不要在NMS后面加上L~~    

NMS是 `net.minecraft.server` 的缩写，与 Minecraft 自己的代码有关，通常这个东西只在 `BukkitAPI` 系服务端核心内存在。  
接着用上文的例子。假设一个基于 BukkitAPI 的插件(以下简称 Bukkit 插件)需要一个玩家管理器，但是恰好，BukkitAPI 没有玩家管理器，但实际上MC里面是有一个玩家管理器的，只是 BukkitAPI 把它藏了起来或者忘记包装成它的一部分了。  
那么这个 Bukkit 插件怎么办呢？它就只能去使用原版 Minecraft 里面的那个玩家管理器。  
  
但实际上 `net.minecraft.server` 只是服务端核心开发组取得一个名字，原本的MC代码名大概会是 `a.b.c.d` 又或者是 `ii.li.il` ，谁知道呢？原版 Minecraft 代码实际上被随机打乱过，且开发组并不对这里面的变动负责... 大量的 Bukkit 插件只能呆在 CraftBukkit 分支上，因为其他实现了 BukkitAPI 的服务端核心大部分都不想管这坨在 API 范围之外难以维护难以预料的屎，这也是某些服务端被终结的原因。

---
## 稳定性 & 性能

Bukkit 上的分支几乎都是为了同一个目的设计的——`优化`  
但是优化的越多，意味着对 Minecraft 作出的修改也越多。Minecraft 源码是被混淆/加密的，即使大部分的代码被解密开来，但我们仍然不是 Mojang 员工，我们不知道 Mojang 里面是怎么想的。

如果我们做的所谓优化是自以为是...没人知道会发生什么。

因此，无论是优化插件还是优化后的服务端，对 Minecraft "优化"的越多，这些问题**可能**就越有可能影响到**玩家**：
 - 区块加载机制被修改以至于无法制作区块加载器
 - 生物生成被干预以至于刷怪塔无法正常运作
 - 服务器稳定性与可能出现的分支特有漏洞
 - ...

但如果服务器性能不够强大，玩家可能会遇到这样的问题：
 - 服务器卡顿
 - 服务器稳定性差，经常出现问题
 - 无法支撑大量的人数，性能差
 - ...

# Spigot and Paper
由图可知，Spigot 和 Paper是两个关键节点，就连本教程在第一章提供的示例都是 Spigot.  

## Bukkit编年史
先来讲一遍 Bukkit 编年史。
相信读者已经发现了一个特殊的节点: `Bukkit`, 它名字看起来像是 BukkitAPI 的正统实现，理应成为它上面那个 `CraftBukkit`，那么为什么它挂了呢？  

其实就是版权问题  
TL;DR
>Bukkit 已经多次转手开发，因此先在的开发者与过去开发过 Bukkit 的开发者开始[争论](https://www.packtpub.com/books/content/brief-history-minecraft-modding)谁是此作品的著作权持有者。  
> 最终在2014年，一个名为 Warren“EvilSeph”Loo 的开发者尝试在游戏中的代码加入著作权，然而此一事造成了Bukkit有[很长一段时间处于失修的状态](http://gamepolitics.com/2014/09/05/mod-turns-latest-ongoing-minecraft-bukkit-saga/)。后来 Mojang [介入](http://gamepolitics.com/2014/09/05/mod-turns-latest-ongoing-minecraft-bukkit-saga/)以挽救该项目。最后的著作权持有者变为由 Mojang 持有，也因此，另一个由社区开发名为 “CraftBukkit” 的独立服务器，由于部分代码基于 Bukkit，因此有侵犯著作权之虞，而遭到终止，它被另一个独立服务器 *spigot* 所替代。  
> 
> https://zh.wikipedia.org/wiki/%E6%88%91%E7%9A%84%E4%B8%96%E7%95%8C%E6%A8%A1%E7%B5%84

 * [CraftBukkit 和 Bukkit 之间的关系](https://bukkit.gamepedia.com/FAQ#What_is_the_difference_between_Bukkit_and_CraftBukkit.3F)  
**注意：** CraftBukkit 实现的是 BukkitAPI，而Bukkit本身并不是一个 API，它实现了它自己的API。

## Spigot
https://www.spigotmc.org/  
Bukkit 死了，CraftBukkit "死"了，唯独 Spigot "活了下来"。  
实际上，Spigot 仍然处于黑色地带，但是 Mojang 被认为默许了它的存在。  

---
### BuildTools
Spigot 通过 BuildTools 绕开了 DMCA 。  
直到今天，您仍然可以使用它构建出 Spigot 和 **CraftBukkit**  
(是的，`md_5`复活了它。)
> 关于 BuildTools 的工作原理  
> 它首先从 Mojang 下载最新版本的 Minecraft 服务器文件，再下载对应版本的 Bukkit 和 Spigot 代码，这些代码中带有 `git patch` 以修改反编译后的 Minecraft 服务器。  
> 反编译服务器，应用补丁，重新打包.... BuildTools 一步呵成。

[如何使用 BuildTools 构建一个 Spigot **官方直供无第三方接手**过的核心](./How_To_Use_BuildTools.md)  
强烈建议每位腐竹都尝试一遍自己构建，不要经常依赖一些构建网站，[且分发核心实际上是犯法的](../What_is_eula.md)。

---
### 中间人物

Spigot 稳定且相比 Vanilla(原版服务器) 具有更好的性能，适用于绝大多数服务器。  
它占有相当大的市场份额。有 150 项性能优化仅在 Spigot 有，例如:
 - 多服联服支持
 - 多项服务器内部参数的设置项，比如作物的生长速度，饥饿，生物寻路，地图各项种子设置
 - 服务器狗，监控服务器的运行和捕获问题
 - 更多关于性能的配置项
 - 更好的区块加载器
 - （对于开发者）拓展了更多有用的 API 功能
  
> There are over 150 improvements present in only in Spigot, including BungeeCord support; configuration of many internal server values such as crop growth rates, hunger, entity tracking, map seeds; enhanced watchdog and timings profiling to catch plugin issues; further configuration to heavy elements such as entity activation and hoppers; rewritten chunk loading, unloading and saving; and some useful API additions for developers.
>
> https://www.spigotmc.org/wiki/about-spigot/

但仍然有人不能满足。

---
## Paper
https://papermc.io/  
Paper (PaperSpigot) 是一个基于 Spigot 进行了大量优化和性能提升的服务端，此后又有许多服务端基于 Paper 进行了优化产生了很多分支。  
与 Spigot 相比，具有以下优势：
 - Paper 所使用的 PaperClip 比 BuildTools 更加便携，腐竹无需额外构建，直接作为服务端核心启动即可
 - PaperAPI 添加了更多功能，允许开发者做更多的事情。  
 - 由于和 Spigot 是继承关系，它完全支持 Spigot 插件在它上面运行。

如果你想得到更好的性能，你也可以考虑在 Paper 后的一些分支，例如 [Tuinity](https://github.com/Spottedleaf/Tuinity)
> 最后，在选择服务端时请不要忘记 `稳定性 & 性能` 一节所传达给你的知识。



# 服务端核心的介绍

Katsuhisa 对于大多数服务端核心都做了介绍。有条件的读者请使用 XMind Zen/2020 来阅读[XMind导出文件](./Server_Cores.xmind)(免费版即可)，无条件的读者请前往[导出后的大纲](./Server_Cores.md)  
> 关于Server_Cores.md
> 对于贡献者: 请不要直接修改这章节的内容，请修改[XMind导出文件](./Server_Cores.xmind)后导出大纲为Markdown.  
> 对于读者：有条件的读者请使用 XMind Zen/2020 来阅读[XMind导出文件](./Server_Cores.xmind)。

所有在思维导图/提纲中提到的服务端核心均可在 [GitHub](https://github.com/search) 上搜索到项目。

> 如果您使用了 XMind 来阅读..
> 
> ![image.png](https://i.loli.net/2021/02/16/CafzQDYT4NI7cE9.png)