![互联网微服务架构与进阶-分布式CM影院系统](https://raw.githubusercontent.com/qiurunze123/imageall/master/cloud.png)

> 邮箱 : [QiuRunZe_key@163.com](QiuRunZe_key@163.com)

> Github : [https://github.com/qiurunze123](https://github.com/qiurunze123)

> QQ : [3341386488](3341386488)

> QQ群 :

![整体流程](https://raw.githubusercontent.com/qiurunze123/imageall/master/qq.png)



[![Travis](https://img.shields.io/badge/language-Java-yellow.svg)](https://github.com/qiurunze123)
高并发大流量如何进行秒杀架构，我对这部分知识做了一个系统的整理，写了一套系统。本GitHub还有许多其他的知识，随时欢迎探讨与骚扰！本文还在更新如果文章出现瑕疵请及时与我联系！

文章还有许多不足，我仍在不断改进！页面还只是在开发阶段，不喜欢勿喷！

一点小建议：学习本系列知识之前，如果你完全没接触过 `MQ`、`SpringBoot`、`Redis`、`Dubbo`、`ZK` 、`Maven`,`lua`等，那么我建议你可以先在网上搜一下每一块知识的快速入门，
也可以下载本项目边做边学习，我的项目完全是实战加讲解不想写一堆的文章，浪费我们的生命，你还不懂内层含义，想要明白就边实际操作边学习，效果会更好！加油💪💪

**整体设计包结构**
GEEKQ-CM
|_ guns-admin -- 登陆模块
|_ guns-api -- 影院api接口
|_ guns-cinema -- 影院模块
|_ guns-core -- 核心core包
|_ guns-film -- film模块
|_ guns-gateway -- 网关模块
|_ guns-generator -- 生成模块
|_ guns-order -- 订单模块
|_ guns-rest  -- rest模块
|_ guns-user  -- 用户模块
|_ guns-pay -- 支付模块

**整体设计图**

![整体流程](https://raw.githubusercontent.com/qiurunze123/imageall/master/yingyuan.png)



