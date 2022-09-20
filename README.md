# 金牛区综合执法调度指挥平台  mapFenceJinNiu
## 代码流程
· 现在github默认分支是main，本地git一般是master，所以请注意分支名称的不同，自己本地做好修改
- [ ] Fork一份进自己的github仓库
- [ ] git clone 到自己的本地
- [ ] git new branch dev分支，建议不要在main分支进行改动
- [ ] 改动完毕后，本地merger进main分支,记得先update远端的改动
- [ ] git push进自己的远程仓库
- [ ] 在自己的仓库提交pull/request(简称pr),等待owner review
## 将来需要实现的功能概览 -todo 
### 用户管理模块
- [ ] 权限管理
- [ ] 人员管理
- [ ] 人员分配
### 围栏管理模块
- [ ] 围栏管理
-  [ ] 围栏设置


## 数据库设计-todo
> 牵扯到权限管理，用户模块和围栏模块，需要仔细设计一下表，目前前期由于没有涉及到登录只使用了两张表.
### fence表
```
-- `map`.fence definition

CREATE TABLE `fence` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `creator` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `point_list` json DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```
### user_admin表
```
-- `map`.user_admin definition

CREATE TABLE `user_admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `tel` varchar(100) DEFAULT NULL,
  `vx` varchar(100) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `fence_id` int DEFAULT NULL,
  `street` varchar(100) DEFAULT NULL,
  `role` varchar(100) DEFAULT NULL,
  `permission` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```


## 后端配置
>由于安全,隐藏了src/main/resources/application.properties,一些涉及到mybatis数据源的配置

```
#mybatis
spring.datasource.url=/
spring.datasource.username=
spring.datasource.password=
```
需要自行配置，详情google或者联系owner。


## 数据持久化 Mybatis-plus https://baomidou.com/
### Mybatis generator
>MyBatis的代码生成器，可以根据数据库生成model、mapper.xml、mapper接口和Example，通常情况下的单表查询不用再手写mapper

### 配置文件 /generator/MyBatisPlusGenerator.java
>运行配置文件，生成对应代码,实现controller中的业务接口

##  后端通用返回接口 CommonResult
```
{
"code": status_code,
"message": String message,
"data": object,如Table,JSONObject,JSONArray,entity等
}
```
### 表格类 Table 
haerderNames,表格头名
dataNames,数据名,前端解析用
格式:
```
 {
"headerNames": [
                "未处理投诉案件",
                "处理中投诉案件",
                "已结案投诉案件",
                "投诉案件结案率"
            ],
 "dataNames": [
                "todo",
                "onProcess",
                "done",
                "rate"
            ],
 "data": [
              {
                 "todo": 0,
                 "onProcess": 1,
                 "done": 12,
                 "rate": "92.30769%"
               }
            ]
        },
```
### 人员类 UserAdmin
```
见代码
```
### 围栏   Fence
```
见代码
```


