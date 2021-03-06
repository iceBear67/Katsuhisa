## 额外章节：编译插件

有的时候，插件作者并没有直接提供了插件的下载，但提供了插件的源码....此时应该怎么办呢？

1. 判断构建工具

   检查源码根目录下的文件。

   若你看到了 "gradlew"文件，则代表这是一个基于Gradle构建的插件

   若你看到了"pom.xml"文件，则代表这是一个基于Maven构建的插件

   若你看到了"ant"相关文件，则代表这是一个基于Ant构建的插件

   若你看到了".classpath"文件，则代表这是一个Eclipse项目

   若上述所有情况都不符合，两种可能：

   - 插件不使用任何构建工具
   - 插件使用的构建工具未列出

2. 准备环境&编译

   编译一个插件需要准备好**JDK**，若您用的是第一篇开服教程提供的Java则不需要担心。

   接着在代码的目录打开`cmd/Powershell/命令提示符`。 (对着文件浏览器Shift+右键可以看到选项, Powershell用户可能需要设置安全策略。)  

   对于 Gradle 构建的插件：输入`./gradlew tasks`，若有`shadowjar`字眼出现请使用`./gradlew shadowjar`，若无请使用`./gradlew build`，插件成品在生成的`build/libs`文件夹内

   对于使用Maven构建的插件，请安装Maven并使用`mvn package`编译插件，插件成品在生成的`target`文件夹内

   对于使用Ant构建的插件，请百度

   对于Eclipse项目，请安装Eclipse/Intellij IDEA导入项目并且编译 (教程部分 TODO )

*能找开发者编译就找开发者编译，他们知道怎么做，但你要注意人品....*