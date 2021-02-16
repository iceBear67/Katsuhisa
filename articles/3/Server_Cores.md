# Vanilla Minecraft Server

Vaniila 是指 Mojang 提供的原版服务端，体系后的服务端都基于此逆向工程开发。

## Outdated

无人维护的服务端，仅作纪念

### Spout

### Player API

### TacoSpigot

### TorchSpigot

## Maintained

主流体系服务端

### Bukkit API

https://bukkit.org
API 可以先理解为标准的意思，API后面的都是对于这个标准的实现。
BukkitAPI 是服务端MOD/插件生态圈最大的。
注意：1.13是Bukkit的分水岭（由于扁平化更新），1.13-的部分插件无法直接在1.13+使用。

- CraftBukkit

  对于 Bukkit 标准的实现
  在Bukkit团队GG后由SpigotMC维护

	- Cauldron

	  看下面cauldron的介绍

		- KCauldron

			- ...

	- Spigot 

	  https://www.spigotmc.org
	  来自 SpigotMC 的正统CraftBukkit继承者。
	  基于CraftBukkit核心做了性能优化相关措施，并且添加了更多功能。

		- Paper

		  https://papermc.io/
		  基于 Spigot 的优化分支。
		  添加了更多功能

			- Tuinity

			  基于 Paper 的优化分支。
			  由 spottedleaf 维护，合并了一些paper拖延已久的代码合并请求。

				- Akarin(1.14 above)

				  基于 Tuinity 的优化分支。

				- Purpur

				  基于 Tuinity 的优化分支。

				- Airplane

				  基于 Tuinity 的优化分支。

				- Yatopia (Purpur+Airplane+Origami+...)

				  基于 Tuinity 的优化分支。
				  合并了Purpur，Airplane，Origami和一些优化Mod的代码，稳定性未知。

			- Origami

			  基于 Paper 的优化分支。

			- CraftFabric

			  基于 Paper 并兼容 FabricMod.

			- Cardboard

			  基于 Paper 并兼容 FabricMod。
			  相比CraftFabric,Cardboard完成度更高一些

			- Mohist

			  基于Paper并兼容ForgeMod.
			  个人不推荐使用。

			- Akarin (1.14 below)

			  1.14以前基于Paper。
			  基于 Paper 的优化分支。

		- zSpigot like business branchs..

		  除了Paper之外，也有许多商业分支，它们是收费的，大多数都设计给 1.8 PVP服务器。
		  选择这类服务端请慎重考虑

- GlowStone

  与其他服务端不同，他并不基于原版MC开发，他直接自己写了个新的。
  虽然拓展了自定义，优化空间且支持了 BukkitAPI ，但是其本身不支持一些依赖于原版代码(NMS)的插件，随着Linkstone项目的破产落下帷幕。

- Arclight

  基于Forge实现的Bukkit API。
  仅支持高版本，开发活跃

- Bukkit

### Forge API

https://files.minecraftforge.net
生态更大的 ForgeAPI，支持对游戏作出直接修改（新的方块，新的生物，新的界面...）
注意: 1.13是forge分水岭，1.13-的Mod无法在1.13后使用。

- Cauldron (Forge + Bukkit)

  Cauldron在两个体系中都有
  Cauldron只支持1.7.10以及以下
  Cauldron的前身叫MCPC+

	- KCauldron

	  KCauldron 是 Cauldron 的优化版，不仅KCauldron是，后面的T,C,U都是递增关系的优化版。

		- Thermos

			- Contigo

				- Uranium

- Magma (Forge + Bukkit)

  一个Forge+Bukkit服务端

- SpongeForge

  基于 Forge 的 Sponge 实现

- CatServer

  将Bukkit和Forge混合了起来以同时支持两种体系。
  CatServer有的代码来自于KCauldron，Mohist实际上是CatServer的分支（抄过去的）
  截至2021.02.16 13:10，仅支持 1.12.2.

- Arclight
- ForgeVanilla

  Forge自己的实现

### Sponge API

https://spongepowered.org/
SpongeAPI 是 BukkitAPI 的进化，可惜生态小..
优点是可以在服务端同时支持安装Forge MOD和Sponge插件。

- SpongeVanilla

  纯粹的 Sponge API 实现，可以通过添加 一些特殊的Sponge插件来支持运行部分 Bukkit 插件

- SpongeForge

### Fabric API

https://fabricmc.net
1.13被创建，1.14开始兴起的新API。

- FabricVanilla

  Fabric 自己的实现

- CraftFabric
- Cardboard

## Not Vanilla based

不基于原版逆向工程的服务端，此类服务端不需要考虑法律问题，虽然Mojang本来也默许

### Cuberite (C++)

用C++写的服务端，性能很高，生态较弱，支持使用Lua，C++编写插件。
完成度较高

### GlowStone (Java)

一个BukkitAPI实现。

### Minestom (Java)

从零开始的Minecraft服务端，高度优化空间，尚未成熟。(2021.2.16)

## Author: iceBear67

版权声明，请不要删除或打码这部分内容。

### Image from Katsuhisa

### Do not delete this.

