<h1 align="center"><a href="https://github.com/weizujie/StuInfoSys" target="_blank">StuInfoSys</a></h1>

> :nerd_face: 电子系年度学生成果信息采集系统。

------------------------------

## 日志
- 2020年8月21日
    - 完成用户登录功能并使用JWT进行验证
- 2020年8月22日
    - 完成用户添加、用户信息修改以及头像更新功能
- 2020年8月24日
    - 完成学术统计、获奖统计增加和查询功能

## 1.1. API V1 接口说明

- 接口基准地址：`http://127.0.0.1:8888/api/v1/`
- 服务端已开启 CORS 跨域支持
- API V1 认证统一使用 Token 认证
- 需要授权的 API ，必须在请求头中使用 `Authorization` 字段提供 `token` 令牌
- 使用 HTTP Status Code 标识状态
- 数据返回格式统一使用 JSON

### 1.1.1. 支持的请求方法

- GET（SELECT）：从服务器取出资源（一项或多项）。
- POST（CREATE）：在服务器新建一个资源。
- PUT（UPDATE）：在服务器更新资源（客户端提供改变后的完整资源）。
- PATCH（UPDATE）：在服务器更新资源（客户端提供改变的属性）。
- DELETE（DELETE）：从服务器删除资源。
- HEAD：获取资源的元数据。
- OPTIONS：获取信息，关于资源的哪些属性是客户端可以改变的。

### 1.1.2. 通用返回状态说明

| *状态码* | *含义*                | *说明*                                              |
| -------- | --------------------- | --------------------------------------------------- |
| 200      | OK                    | 请求成功                                            |
| 201      | CREATED               | 创建成功                                            |
| 204      | DELETED               | 删除成功                                            |
| 400      | BAD REQUEST           | 请求的地址不存在或者包含不支持的参数                |
| 401      | UNAUTHORIZED          | 未授权                                              |
| 403      | FORBIDDEN             | 被禁止访问                                          |
| 404      | NOT FOUND             | 请求的资源不存在                                    |
| 422      | Unprocesable entity   | [POST/PUT/PATCH] 当创建一个对象时，发生一个验证错误 |
| 500      | INTERNAL SERVER ERROR | 内部错误                                            |
|          |                       |                                                     |

------

## 1.2. 登录

### 1.2.1. 登录验证接口

- 请求路径：login
- 请求方法：post
- 请求参数

| 参数名   | 参数说明 | 备注     |
| -------- | -------- | -------- |
| username | 用户名   | 不能为空 |
| password | 密码     | 不能为空 |

- 响应参数

| 参数名   | 参数说明    | 备注            |
| -------- | ----------- | --------------- |
| id       | 用户 ID     |                 |
| username | 用户名      |                 |
| mobile   | 手机号      |                 |
| email    | 邮箱        |                 |
| token    | 令牌        | 基于 jwt 的令牌 |

- 响应数据

```json
{
    "data": {
        "id": "1",
        "username": "weizujie",
        "email": "123@qq.com",
        "mobile": "123123123",
        "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6IjEiLCJleHAiOjE1OTg2ODA5OTEsInVzZXJuYW1lIjoid2VpenVqaWUifQ.qtN1pmICU9bH34QKBF_xTP7WUvqKCwXAEE_6AQqkY94"
    },
    "meta": {
        "status": 200,
        "msg": "登录成功"
    }
}
```

## 1.3. 用户管理

### 1.3.1. 用户数据列表

- 请求路径：users
- 请求方法：get
- 请求参数

| 参数名   | 参数说明     | 备注     |
| -------- | ------------ | -------- |
| pagenum  | 当前页码     | 可以为空 |
| pagesize | 每页显示条数 | 可以为空 |

- 响应参数

| 参数名    | 参数说明     | 备注 |
| --------- | ------------ | ---- |
| totalpage | 总记录数     |      |
| pagenum   | 当前页码     |      |
| users     | 用户数据集合 |      |

- 响应数据

```json
{
    "data": {
        "totalpage": 2,
        "pagenum": 1,
        "users": [
            {
                "id": 1,
                "username": "weizujie",
                "password": "weizujie",
                "email": "123@qq.com",
                "mobile": "123123123",
                "avatar": "https://cdn.jsdelivr.net/gh/weizujie/weizujie.github.io@latest/images/avatar.jpg"
            },
            {
                "id": 34,
                "username": "123123",
                "password": "123123",
                "email": null,
                "mobile": null,
                "avatar": "https://cdn.jsdelivr.net/gh/weizujie/weizujie.github.io@latest/images/avatar.jpg"
            }
        ],
        "meta": {
            "msg": "获取成功",
            "status": 200
        }
    }
}
```

### 1.3.2. 添加用户

- 请求路径：users/{id}
- 请求方法：post
- 请求参数

| 参数名   | 参数说明 | 备注     |
| -------- | -------- | -------- |
| username | 用户名称 | 不能为空 |
| password | 用户密码 | 不能为空 |
| email    | 邮箱     | 可以为空 |
| mobile   | 手机号   | 可以为空 |
| avatar   | 头像     | 默认，可以更改 |

- 响应参数

| 参数名   | 参数说明    | 备注 |
| -------- | ----------- | ---- |
| id       | 用户 ID     |      |
| username | 用户名      |      |
| mobile   | 手机号      |      |
| email    | 邮箱        |      |
| avatar   | 头像        |       |

- 响应数据

```json
{
    "data": {
        "id": "35",
        "username": "test",
        "email": "123123@qq.com",
        "mobile": "123123",
        "avatar": "https://cdn.jsdelivr.net/gh/weizujie/weizujie.github.io@latest/images/avatar.jpg"
    },
    "meta": {
        "status": 201,
        "msg": "用户创建成功"
    }
}
```

### 1.3.3 更改头像

- 请求路径：updateAvatar
- 请求方法：post
- 请求参数

| 参数名   | 参数说明    | 备注 |
| -------- | ----------- | ---- |
| token   |             |      |
| file     | 头像        |      |

- 响应参数

| 参数名   | 参数说明    | 备注 |
| -------- | ----------- | ---- |
| path       | 头像地址     |      |

- 响应数据

```json
{
    "code": 200,
    "msg": "上传成功",
    "path": "http://localhost:8888/static/images/1598076017177.jpg"
}
```

## 1.4 获奖统计

### 1.4.1 添加获奖信息

- 请求路径：obtain
- 请求方法：post
- 请求参数

| 参数名   | 参数说明    | 备注 |
| -------- | ----------- | ---- |
| studentName   | 姓名 |      |
| studentNumber | 学号      |      |
| major | 专业 | |
| cardNumber | 银行卡号 | 可以为空 |
| raceName | 竞赛名称 | |
| raceScope | 赛事范围 | |
| rank | 获奖级别 | |
| adviser | 指导老师 | |
| teamSituation | 组队情况 | 个人/团体 |
| grade | 年级 | |
| obtainTime | 获奖时间 | |

- 响应参数

| 参数名   | 参数说明    | 备注 |
| -------- | ----------- | ---- |
| path       |      |      |

- 响应数据

```json
{
    "code": 201,
    "msg": "添加成功"
}
```

### 1.4.1 查询获奖信息

- 请求路径：obtain
- 请求方法：get
- 请求参数

| 参数名   | 参数说明    | 备注 |
| -------- | ----------- | ---- |
| pagesize | 每页显示条数 | 可以为空 |
| pagenum | 当前页码 | 可以为空 |
|  |  |  |


- 响应参数

| 参数名   | 参数说明    | 备注 |
| -------- | ----------- | ---- |
| studentName   | 姓名 |      |
| studentNumber | 学号      |      |
| major | 专业 | |
| cardNumber | 银行卡号 | 选填 |
| raceName | 竞赛名称 | |
| raceScope | 赛事范围 | |
| rank | 获奖级别 | |
| adviser | 指导老师 | |
| teamSituation | 组队情况 | 个人/团体 |
| grade | 年级 | |
| obtainTime | 获奖时间 | |

- 响应数据

```json
{
    "data": {
        "obtain": [
            {
                "id": 1,
                "studentName": "张三",
                "studentNumber": "17990425",
                "major": "电信",
                "cardNumber": "1231232123213",
                "raceName": "嚯嚯嚯",
                "raceScope": "嘿嘿",
                "rank": "市级",
                "adviser": "李四",
                "teamSituation": " 团队",
                "grade": "大一",
                "obtainTime": "2020-08-23T13:30:22.000+00:00"
            }
        ]
    },
    "meta": {
        "code": 200,
        "msg": "获取数据成功"
    }
}
```

## 1.5 学术统计

### 1.4.1 添加学术信息

- 请求路径：scholarism
- 请求方法：post
- 请求参数

| 参数名   | 参数说明    | 备注 |
| -------- | ----------- | ---- |
| resultName | 成果     | 专利/论文 |
| grade           | 年级    |      |
| major | 专业 | |
| paperName | 论文名称 | 可以为空 |
| patentName | 专利名称 | 可以为空 |
| applicant | 申请人   | |
| adviser | 指导老师 | 可以为空 |
| patentNumber | 专利号   | |
| paperNumber | 论文编号 |  |
| applicationTime | 申请时间 | 可以为空 |
| postedTime | 发表时间 | 可以为空 |

- 响应参数

| 参数名   | 参数说明    | 备注 |
| -------- | ----------- | ---- |
| path       |      |      |

- 响应数据

```json
{
    "code": 201,
    "msg": "添加成功"
}
```

### 1.4.1 查询学术信息

- 请求路径：scholarism
- 请求方法：get
- 请求参数

| 参数名   | 参数说明    | 备注 |
| -------- | ----------- | ---- |
| pagesize | 每页显示条数 | 可以为空 |
| pagenum | 当前页码 | 可以为空 |
|  |  |  |


- 响应参数

| 参数名   | 参数说明    | 备注 |
| -------- | ----------- | ---- |
| resultName | 成果     | 专利/论文 |
| grade           | 年级    |      |
| major | 专业 | |
| paperName | 论文名称 | 可以为空 |
| patentName | 专利名称 | 可以为空 |
| applicant | 申请人   | |
| adviser | 指导老师 | 可以为空 |
| patentNumber | 专利号   | |
| paperNumber | 论文编号 |  |
| applicationTime | 申请时间 | 可以为空 |
| postedTime | 发表时间 | 可以为空 |

- 响应数据

```json
{
    "data": {
        "scholarism": [
            {
                "id": 1,
                "resultName": "paper",
                "grade": "大一",
                "major": null,
                "paperName": null,
                "patentName": null,
                "applicant": "张三",
                "adviser": "王五",
                "patentNumber": "123123aaaa",
                "paperNumber": "12313aaa",
                "applicationTime": "2020-08-23T03:49:09.000+00:00",
                "postedTime": "2020-08-23T03:49:11.000+00:00"
            },
        ]
    },
    "meta": {
        "code": 200,
        "msg": "获取数据成功"
    }
}
```