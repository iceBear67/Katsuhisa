# 命令与参数

`say Hello! Katsuhisa.`

![](https://i.loli.net/2020/11/07/bokq9D3FrlyTRKM.png)

如你所见，这是一条简单的命令，它负责输出一段话。  

这样一条命令的组成，一共有两部分：

> 命令 参数 更多参数...

根据这个简单法则，我们可以把`say Hello! Katsuhisa`分解成这样:

>命令: say
>
>参数: Hello!
>
>更多参数: Katsuhisa.

不过say其实只有一条参数("Hello! Katsuhisa")。

但你也可以看作`say`将所有的参数拼接上了空格输出了出来("Hello!"+" "+"Katsuhisa.")。

关于命令选择器，坐标语法，原版命令列表：https://minecraft-zh.gamepedia.com/%E5%91%BD%E4%BB%A4

## 可选和必选

人们描述命令的时候，总会需要描述一些命令是可选还是必选的，因此我们引入下面两个符号包裹住参数：

`[参数名]`与`<参数名>`。

方括号表示 **可选，可省略不写**

尖括号表示 **必选，必须写**

若命令参数没有写方括号或者尖括号，我们一般都当作是尖括号。

## 命名空间

*前置知识：Meet Spigot*

Spigot作为一个框架，是允许插件开发者自己注册自己的命令的。  

例如: `/let nullcat goto womenDress and get F*CKED`

像这样的命令，显然原版不可能有。但是我们就是能用，也是因为来源于插件。

那么，假设A插件注册了这条命令，而B插件也注册了同名命令呢？接下来使用let命令会发生什么是`undefined(不可预测)`的。NullCat或许会被**，或许会反受为攻。但我们需要NullCat被**。  

我们可以选择使用`命名空间`指定用哪个插件的let命令，避免开冲突。  

`/<namespace>:<command> ....` (例如:`/A:let nullcat .....`)

`namespace` 通常使用插件名。Minecraft也有自己的命名空间，叫`minecraft`，不同的数据包通常也有不同的命名空间。

这样一来，我们就可以让NullCat被**了。