# 新建一个 Minecraft 服务器

在新建一个 Minecraft 服务器之前，你的服务器需要安装 Java 8+。（1.8下的**原版**请使用 Java 7）

[若您的服务器尚未安装Java...](./Get_Java.md)

## 开始部署

请下载: [Example.1.zip](../../examples/A_New_Server/1/Example.1.zip)

> 关于下载
>
> 本教程中所有的可下载资源均在 examples 开源，不需要担心安全问题。

新建一个文件夹，将"Example.1.zip"解压到里面，确保不要有多余的文件，这个文件夹我们称之为**`根目录`**。  

这是一个 `服务端`，是一个Minecraft服务器的基本组成单元，通过它，我们可以开起来我们的第一个服务器。

解压后，双击 `双击我.bat`。

## ...一个黑窗口？

*它出现了，刷出一些白色的信息之后...它消失了..*

但它也留下了一些东西。
![2020-11-07_12-23.png](https://i.loli.net/2020/11/07/yW4CcpFTawmV9hq.png)

再试一次 `双击我.bat`呢？

![2020-11-07_13-39.png](https://i.loli.net/2020/11/07/ZICjte32ml6Q5HB.png)
看起来logs文件夹多出了点东西。**这是因为 logs 文件夹存放着服务端留下的信息**

所以，让我们把目光移到logs文件夹:
![2020-11-07_13-41.png](https://i.loli.net/2020/11/07/TkAcQxgVOD2ofCe.png)

这里有两个文件，一个是一个压缩包，另一个就是服务端上一次运行留下的信息。

打开 `latest.log`:

```
Loading libraries, please wait...
Loaded 0 recipes
[13:39:30 INFO]: Loaded 0 recipes
[13:39:30 INFO]: Starting minecraft server version 1.13.2
[13:39:30 INFO]: Loading properties
[13:39:30 INFO]: You need to agree to the EULA in order to run the server. Go to eula.txt for more info.
[13:39:30 INFO]: Stopping server
[13:39:30 INFO]: Saving worlds
>⏎ 
```

是不是有点眼熟？这就是刚刚在黑窗口打印的信息。服务端通常会把在控制台输出的所有内容都同步拷贝一份到`latest.log`里，而像`latest.log`这样具有记录行为的性质的文件我们统称为`日志文件`。

那么，我们来看看日志要告诉我们什么:

```
[13:39:30 INFO]: You need to agree to the EULA in order to run the server. Go to eula.txt for more info.
```

*大意： 您需要同意Mojang最终用户协议（EULA）才能启动服务器。前往 eula.txt 了解更多*

好的，那么我们已经知道了问题所在。接下来，我们返回根目录，打开eula.txt看看它到底是个什么玩意儿

```
#By changing the setting below to TRUE you are indicating your agreement to our EULA (https://account.mojang.com/documents/minecraft_eula).
#Sat Nov 07 13:39:30 HKT 2020
eula=false
```

恩..一份协议书。开服需要同意Mojang的最终用户协议，我们选择同意。  将**eula=false**改成**eula=true**

[关于Mojang Eula](../What_is_eula.md)

再次双击`双击我.bat`。

![2020-11-07_13-57.png](https://i.loli.net/2020/11/07/fnPMx9U13vJ6yKq.png)

大约一分钟后，服务端不再输出信息，变成了上图所示的样子。  

根据`Done!`的信息提示，您成功架设了您的第一个服务器，并且成功的根据日志诊断了您的第一个开服问题，您可以为此点一份汉堡庆祝一下。*今后遇到的很多问题都可以通过用日志来诊断*

不过，现在这个服务器非常简陋。所以我们将在后面的章节教会您一步一步改造您的服务器，将"Yourscraft"变成"Minecraft"。  

### 那么，现在我要怎么做？

关闭它。

您所见到的 `黑窗口` 实际上就是`"控制台"`。在控制台内您可以通过 `指令` 的方式操控服务器。  

来试试: `say Hello! Katsuhisa.`

![](https://i.loli.net/2020/11/07/bokq9D3FrlyTRKM.png)

..以及 Done 告诉你的 `help`

![](https://i.loli.net/2020/11/07/VnpILRXoeTFx7O3.png)

这可真多命令！事实上，目前大部分的命令如同他的描述一般，是原版Minecraft提供的命令。不过需要注意的是，**在控制台输入命令*不要*在命令前面带一个 / **

[关于命令与参数](Command_And_Arguments.md)

### 我要如何关闭我的服务器

请不要使用Ctrl+C,Ctrl+Z,甚至直接杀死进程，按右上角的X也不行，这会让你丢失没来得及保存的数据。

服务端提供了一条命令用于科学友爱和谐的关闭服务器：**stop**

输入stop，按下回车，等待服务器慢慢关闭。

# END

本章结束。[下一章](../2/After_First_Start.md)

若您感到有帮助，欢迎[赞助](https://afdian.net/@omgib67)或者点个Star！

术语表:

>根目录 —— 服务端所在的目录。用`/`表示根目录，用`/子目录`表示子目录，例如`/logs`
>
>服务端 —— Minecraft 服务器组成的基本单元。
>
>log/日志文件 —— 储存，记录程序运行信息的文件。
>
>控制台 —— 服务器权限最高点，服主操控服务器的"后台"
>
>指令 —— 用于描述操控服务器动作的工具



在本章中，您应该学会了：

- 安装 Java
- 通过日志文件诊断问题
- 使用控制台与命令
