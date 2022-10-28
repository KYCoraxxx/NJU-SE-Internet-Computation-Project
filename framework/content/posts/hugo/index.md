---
title: "使用HUGO快速搭建静态网站"
description: 
date: 2022-10-28
math: true
license: 
categories: 工具
image: cover.jpg
tags: [ HUGO ]
readingTime: true
hidemeta: true
hidden: false
comments: true
draft: false
---

## 基础环境配置

> 我是环境高手，不需要指南一步步引导，快把链接端上来罢！

于是建站小白丢给了你一个[链接](https://gohugo.io/)🛏

### 安装Chocolatey🍫

与`Linux`的安装包管理机制`apt`，`npm`，`yum`类似，同样也有开发者为Windows操作系统制作了安装包管理机制，它的名字就是[chocolatey](https://chocolatey.org/)，这里已经给出了链接，请自行访问它的官网

Chocolatey安装好后会自动为你配置系统环境变量，所以可以**开箱即用**

不过它并不智能的点在于它的默认安装路径位于C盘下，建议自行搜索如何更改其默认安装路径，不过HUGO本体并不大，如果你的C盘不是很吃紧也无所谓

**和Linux同样类似的是，Windows的安装包管理机制也不只它一个，如果你不想用这个可爱😄的package manager也可以换成别的😔**

### 安装HUGO🦊

在任意目录下**以管理员身份**打开`PowerShell`，用类似Linux下的package manager的命令安装hugo即可

~~~~bash
choco install hugo -confirm
choco install hugo-extended -confirm
~~~~

上面的两条命令执行结束之后，HUGO和它的扩展版就安装完毕了，🍫会为它配置好环境变量，所以也是可以**开箱即用**的

**注意HUGO的extended version是必需的，因为解析SCSS需要用到它的功能**

在`PowerShell`中输入命令
~~~~bash
hugo version
~~~~

可以查看安装的HUGO版本，需要注意到版本号的后面应该跟有`+extended`

这样一来环境配置就完成辣🌶

## HUGO的使用

### 运行此网站

HUGO是用`GO`语言编写，利用模板和用户输入的可识别的html, md等格式文件进行**静态网站**的快速搭建工具

如果只是想在本地运行此网站，你只需要在文件根目录下**以管理员身份**运行`PowerShell`， 输入以下命令

~~~~bash
hugo server -D
~~~~

然后HUGO就会提示你已经完成了此网站在 localhost:1313 的监听，然后你就可以看到这个网站长什么样子辣~

**此时不能关闭PowerShell**

怎么取消监听？读读命令行给你的反馈提示罢！

### 修改此网站

首先需要介绍的是HUGO的页面绑定机制，所有的实质性内容都位于content目录下，与之对应的配置位于**根目录下的config.yaml**文件中，如果你需要修改某个页面的内容，你只需要找到对应的文件夹，修改其下面的index.md文档即可~

如何做到精准修改？

呃呃自己仔细阅读config.yaml罢😄读不懂就来群里提问建站小白~

如果你要新建一个markdown或者其他格式的文件，在`PowerShell`中输入

~~~~bash
hugo new <dir/file-name>
~~~~

**一定要用这个命令创建，hugo新建的文件会带有模板需要的参数说明（就是每个markdown文档最上面的那些东西）**

### 发布此网站

在文件根目录下**以管理员身份**运行`PowerShell`， 输入命令

~~~~bash
hugo
~~~~

即可将网站配置导出到public目录下

**如果你并不想用它来搭建个人的网页，那么就可以到此为止了**

### HUGO的更多使用

~~其实也没什么好写的，主要还是靠自己摸索~~

**HUGO的官方手册和各模板的手册与windows的适配性不是太好，完全按照它的手册做一般不能成功**

在HUGO的[官网](https://themes.gohugo.io/)上提供了诸多主题模板，要使用它你需要

~~~~bash
hugo new site <dirname>
cd <dirname>/themes
git clone <theme-url>
~~~~

接下来就该好好阅读这个模板自己的手册，然后慢慢摸索了~😄，每个模板都有不同的地方，所以并没有万金油的捷径可走

**重要的是可以参考每个theme下都会带有的exampleSite目录，它虽然应该不能直接运行，但是可能会给你不少启发**

Good Luck and Have Fun😊
