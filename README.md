# fieldmeta: 基于springboot的字段元数据管理
version:Alpha 0.0.1

[元数据](https://baike.baidu.com/item/%E5%85%83%E6%95%B0%E6%8D%AE/1946090?fr=aladdin)（Metadata），
又称中介数据、中继数据，为描述数据的数据（data about data），
fieldmeta 就是描述数据库字段、实体字段、页面字段的属性和关系的数据，以及配置字段映射规则、约束校验规则、显示查询规则等。

<br>
程序开发离不开对数据的管理，充分利用fieldmeta可大大提高开发的效率，fieldmeta定位于成为程序员的第二类IDE。


#### fieldmeta可以做什么？

- 可以作为一个通用代码生成的框架，可用于java se、java ee、php、.net等任何你喜欢用的语言（现阶段仅支持java），然后制订相关程序代码的模板和生成规则，就可方便的生成CRUD代码。
- 可以作为一个快速开发平台的引擎，通过对字段的配置，自动实现CRUD功能。
- 可以作为一个模板超市，包括admin UI模板和服务器后端模板，定位于amdin系统的快速开发。

#### 技术选型
- 运行环境：jdk1.7
- 数据库：mysql 5.7
- java框架：springboot 1.5.6.RELEASE
- 持久层：spring-data-jpa 
- 前端框架：easyui 1.5.3

#### 部署说明
- 本项目依赖：<br>
https://gitee.com/klguang/coderfun-bom<br>
https://gitee.com/klguang/xutils<br>
将这两个项目下载到本地，并执行maven install

- 数据库配置<br>
1.项目根目录 database 文件下的fieldmeta.sql导入数据库（设置编码为UTF-8）；<br>
2.修改 src/main/resources/jdbc.properties 配置文件。

#### 项目结构
```
fieldmeta
├──src/main/java      
│    ├─common     公共模块
│    │ 
│    ├─fieldmeta  元数据模块
│    │ 
│    └─sys        数据字典模块 
│
├──src/main/resources 
│    ├─app-jpa.xml             spring-data-jpa配置
│    │ 
│    ├─application.properties  springboot配置
│    │ 
│    └─jdbc.properties         数据库配置
│
├──src/main/webapp jsp页面
```
<br>

#### 更新日志
2018-06-12 发布Alpha 0.0.1

#### 使用说明

1. 项目配置
![项目配置](http://wx2.sinaimg.cn/large/005S2p1Cgy1fs8fyqrszrj31hc0u00yf.jpg)
2. 模块配置
![模块配置](https://wx4.sinaimg.cn/large/005S2p1Cgy1fs8fxn7oflj31hc0u0wk3.jpg)
3. 实体基类
![实体基类](http://wx2.sinaimg.cn/large/005S2p1Cgy1fs8fz78smcj31hc0u0af9.jpg)
4. 可选字段
![可选字段](http://wx4.sinaimg.cn/large/005S2p1Cgy1fs8fyelumfj31hc0u0dl5.jpg)
5. 元数据管理
![元数据管理](http://wx2.sinaimg.cn/large/005S2p1Cgy1fs8fr9jvgaj31hc0u0grm.jpg)


#### 参与贡献
本项目还在处于初期，欢迎感兴趣的小伙伴加入

1. Fork 本项目
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request

#### 社群
qq群：743769300
<br>
![元数据管理](http://wx3.sinaimg.cn/mw690/005S2p1Cgy1fs8i122zmmj306a082t8u.jpg)
<br>
进群须知：star、watch、fork项目，可进群

