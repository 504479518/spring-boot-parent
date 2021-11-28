# caesar-boot

## 简介

caesar-boot是一款基于SpringBoot+MyBatis-Plus的快速开发脚手架，拥有完整的权限管理功能.

## 技术选型

| 技术                   | 版本    | 说明             |
| ---------------------- | ------- | ---------------- |
| SpringBoot             | 2.3.0   | 容器+MVC框架     |
| SpringSecurity         | 5.3.2   | 认证和授权框架   |
| MyBatis                | 3.5.4   | ORM框架          |
| MyBatis-Plus           | 3.3.2   | MyBatis增强工具  |
| MyBatis-Plus Generator | 3.3.2   | 数据层代码生成器 |
| Swagger-UI             | 2.9.2   | 文档生产工具     |
| Redis                  | 5.0     | 分布式缓存       |
| Docker                 | 18.09.0 | 应用容器引擎     |
| Druid                  | 1.1.10  | 数据库连接池     |
| JWT                    | 0.9.0   | JWT登录支持      |
| Lombok                 | 1.18.12 | 简化对象封装工具 |

### 环境搭建

简化依赖服务，只需安装最常用的MySql和Redis服务即可，数据库中需要导入`caesar_boot.sql`脚本。

### 开发规约

#### 项目包结构

``` lua
src
├── common -- 用于存放通用代码
|   ├── api -- 通用结果集封装类
|   ├── config -- 通用配置类
|   ├── domain -- 通用封装对象
|   ├── exception -- 全局异常处理相关类
|   └── service -- 通用业务类
├── config -- SpringBoot中的Java配置
├── domain -- 共用封装对象
├── generator -- MyBatis-Plus代码生成器
├── modules -- 存放业务代码的基础包
|   └── ums -- 权限管理模块业务代码
|       ├── controller -- 该模块相关接口
|       ├── dto -- 该模块数据传输封装对象
|       ├── mapper -- 该模块相关Mapper接口
|       ├── model -- 该模块相关实体类
|       └── service -- 该模块相关业务处理类
└── security -- SpringSecurity认证授权相关代码
    ├── annotation -- 相关注解
    ├── aspect -- 相关切面
    ├── component -- 认证授权相关组件
    ├── config -- 相关配置
    └── util -- 相关工具类
```

#### 资源文件说明

``` lua
resources
├── mapper -- MyBatis中mapper.xml存放位置
├── application.yml -- SpringBoot通用配置文件
├── application-dev.yml -- SpringBoot开发环境配置文件
├── application-prod.yml -- SpringBoot生产环境配置文件
└── generator.properties -- MyBatis-Plus代码生成器配置
```

#### 接口定义规则

- 创建表记录：POST /{控制器路由名称}/create

- 修改表记录：POST /{控制器路由名称}/update/{id}

- 删除指定表记录：POST /{控制器路由名称}/delete/{id}

- 分页查询表记录：GET /{控制器路由名称}/list

- 获取指定记录详情：GET /{控制器路由名称}/{id}

- 具体参数及返回结果定义可以运行代码查看Swagger-UI的Api文档：http://localhost:8080/swagger-ui.html

### 项目运行

直接运行启动类`CaesarBootApplication`的`main`函数即可。

### 业务代码开发流程

#### 编写业务代码

##### 单表查询

> 由于MyBatis-Plus提供的增强功能相当强大，单表查询几乎不用手写SQL，直接使用ServiceImpl和BaseMapper中提供的方法即可。

Copyright (c) 2020-2021 caesar
