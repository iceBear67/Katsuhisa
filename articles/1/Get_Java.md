# 安装Java

 1. Oracle JRE

    前往 https://www.oracle.com/cn/java/technologies/javase/javase-jdk8-downloads.html 下载 (要登录)

 2. AdoptOpenjdk

    前往 https://adoptopenjdk.net/?variant=openjdk8&jvmVariant=hotspot 下载 (国内速度慢)

若您不知道应该选择哪一种，请选择 AdoptOpenJdk

Windows X64: https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u272-b10/OpenJDK8U-jdk_x64_windows_hotspot_8u272b10.zip

Windows X86(32): https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u272-b10/OpenJDK8U-jdk_x86-32_windows_hotspot_8u272b10.zip

解压，打开安装包，一路同意并点击Next按钮就可以安装。

# 检查自己是否安装

按下`Win+R`键，输入`cmd`，按下回车。

输入`java --version`后回车，若不是输出"未知命令"一类的提示，就是安装成功了

例如笔者电脑:

```
> java --version
openjdk 11.0.8 2020-07-14
OpenJDK Runtime Environment (build 11.0.8+10)
OpenJDK 64-Bit Server VM (build 11.0.8+10, mixed mode)
```

