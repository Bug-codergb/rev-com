# rev-com-manage

## Project setup

```
npm install
```

### Compiles and hot-reloads for development

```
npm run serve
```

### Compiles and minifies for production

```
npm run build
```

### Lints and fixes files

```
npm run lint
```

## /rev-com

```text
暂无描述
```

#### 公共 Header 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 公共 Query 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 公共 Body 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/登录

```text
暂无描述
```

#### 公共 Header 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 公共 Query 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 公共 Body 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/登录/登录

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/login

#### 请求方式

> POST

#### Content-Type

> json

#### 请求 Body 参数

```javascript
{
    "userName":"gb",
    "password":"456"
}
```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
const res = response.json;
apt.globals.set("token", res.data.token);
```

## /rev-com/登录/注册

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/register

#### 请求方式

> POST

#### Content-Type

> json

#### 请求 Body 参数

```javascript
{
    "userName":"g0brrr",
    "password":"456",
}
```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/用户

```text
暂无描述
```

#### 公共 Header 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 公共 Query 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 公共 Body 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/用户/上传头像

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/user/avatar/upload

#### 请求方式

> POST

#### Content-Type

> form-data

#### 请求 Body 参数

| 参数名 | 示例值         | 参数类型 | 是否必填 | 参数描述 |
| ------ | -------------- | -------- | -------- | -------- |
| avatar | 请选择上传文件 | File     | 是       | -        |

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/用户/获取用户头像

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/user/avatar/1651935333133

#### 请求方式

> GET

#### Content-Type

> json

#### 请求 Body 参数

```javascript

```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/导演

```text
暂无描述
```

#### 公共 Header 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 公共 Query 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 公共 Body 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/导演/添加导演

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/director/

#### 请求方式

> POST

#### Content-Type

> json

#### 请求 Body 参数

```javascript
{
    "name":"温子仁",
    "alias":" James Wan",
    "gender":"0",
    "birthPlace":"马来西亚,古晋",
    "description":"出生于马来西亚、成长于澳洲的华裔导演。早年在墨尔本上大学时主修的专业是中国民族划分。对于东方异域文化的了解对詹姆斯·温的导演风格也有着很大的影响，而造就他对于《电锯惊魂》和《死寂》(dead silence)之类血浆片独特口味的更重要的因素是他14岁时父亲过世的打击。"
}
```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/导演/获取所有导演

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/director/all?page=1&limit=5

#### 请求方式

> GET

#### Content-Type

> json

#### 请求 Query 参数

| 参数名  | 示例值 | 参数类型 | 是否必填 | 参数描述 |
| ------- | ------ | -------- | -------- | -------- |
| page    | 1      | Text     | 是       | -        |
| limit   | 5      | Text     | 是       | -        |
| keyword | 李     | Text     | 是       | -        |

#### 请求 Body 参数

```javascript

```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/导演/上传导演头像

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/director/avatar/upload/1652147804701

#### 请求方式

> POST

#### Content-Type

> form-data

#### 请求 Body 参数

| 参数名 | 示例值                                                        | 参数类型 | 是否必填 | 参数描述 |
| ------ | ------------------------------------------------------------- | -------- | -------- | -------- |
| avatar | C:\Users\guo'bin\Desktop\b55653316617fb515b3e0b9f15887af9.jpg | File     | 是       | -        |

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/导演/更新导演信息

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/director/update

#### 请求方式

> POST

#### Content-Type

> json

#### 请求 Body 参数

```javascript
{
    "id":"1652097707616",
    "name":"张艺谋JJ",
    "alias":"yimoua",
    "gender":"0",
    "occupationList":["1652100137884","1652100321467"],
    "description":"牛逼",
    "birthPlace":"纽约"
}
```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/导演/删除导演信息

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/director/delete?id=1652443093091

#### 请求方式

> POST

#### Content-Type

> json

#### 请求 Query 参数

| 参数名 | 示例值        | 参数类型 | 是否必填 | 参数描述 |
| ------ | ------------- | -------- | -------- | -------- |
| id     | 1652443093091 | Text     | 是       | -        |

#### 请求 Body 参数

```javascript

```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/导演/更新导演头像

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/director/avatar/update/1653096371152

#### 请求方式

> POST

#### Content-Type

> form-data

#### 请求 Body 参数

| 参数名 | 示例值                             | 参数类型 | 是否必填 | 参数描述 |
| ------ | ---------------------------------- | -------- | -------- | -------- |
| avatar | C:\Users\guo'bin\Desktop\photo.jpg | File     | 是       | -        |

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/演员

```text
暂无描述
```

#### 公共 Header 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 公共 Query 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 公共 Body 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/演员/添加演员

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/actor/

#### 请求方式

> POST

#### Content-Type

> json

#### 请求 Body 参数

```javascript
{
    "name":"山姆·洛克威尔 ",
    "foreignName":"Robert Downey Jr.",
    "constellation":"白羊座",
    "birth":"1990-04-04",
    "birthPlace":"纽约",
    "family":"莎拉·杰西卡",
    "description":"ffffff",
    "alias":"Bob",
    "occupationList":["1652100306026","1652100361394","1652100464525"]
}
```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/演员/获取所有演员

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/actor/all?page=1&limit=10&keyword=尔

#### 请求方式

> GET

#### Content-Type

> json

#### 请求 Query 参数

| 参数名  | 示例值 | 参数类型 | 是否必填 | 参数描述 |
| ------- | ------ | -------- | -------- | -------- |
| page    | 1      | Text     | 是       | -        |
| limit   | 10     | Text     | 是       | -        |
| keyword | 尔     | Text     | 是       | -        |

#### 请求 Body 参数

```javascript

```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/演员/更新演员信息

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/actor/update

#### 请求方式

> POST

#### Content-Type

> json

#### 请求 Body 参数

```javascript
{
    "id":"1652444349475",
    "name":"山姆·洛克威尔12 ",
    "foreignName":"Robert Downey Jr.34",
    "constellation":"白羊座",
    "birth":"2010-04-04",
    "birthPlace":"纽约45",
    "family":"莎拉·杰西1卡",
    "description":"ffffff",
    "alias":"Bob12",
    "occupationList":["1652100330901"]
}
```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/演员/删除演员

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/actor/delete?id=1652493246449

#### 请求方式

> POST

#### Content-Type

> json

#### 请求 Query 参数

| 参数名 | 示例值        | 参数类型 | 是否必填 | 参数描述 |
| ------ | ------------- | -------- | -------- | -------- |
| id     | 1652493246449 | Text     | 是       | -        |

#### 请求 Body 参数

```javascript

```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/演员/上传演员头像

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/actor/avatar/upload/1652014592779

#### 请求方式

> POST

#### Content-Type

> form-data

#### 请求 Body 参数

| 参数名 | 示例值                         | 参数类型 | 是否必填 | 参数描述 |
| ------ | ------------------------------ | -------- | -------- | -------- |
| avatar | C:\Users\guo'bin\Desktop\1.jpg | File     | 是       | -        |

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/演员/获取演员头像

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> http://localhost:8888/actor/avatar/1653099994469

#### 请求方式

> GET

#### Content-Type

> json

#### 请求 Body 参数

```javascript

```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/演员/更新演员头像

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/actor/avatar/update/1653099994469

#### 请求方式

> POST

#### Content-Type

> form-data

#### 请求 Body 参数

| 参数名 | 示例值                             | 参数类型 | 是否必填 | 参数描述 |
| ------ | ---------------------------------- | -------- | -------- | -------- |
| avatar | C:\Users\guo'bin\Desktop\p4213.jpg | File     | 是       | -        |

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/演员/获取导演合作演员

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/actor/director/cooperate?id=1652097604414&page=1&limit=5

#### 请求方式

> GET

#### Content-Type

> json

#### 请求 Query 参数

| 参数名 | 示例值        | 参数类型 | 是否必填 | 参数描述 |
| ------ | ------------- | -------- | -------- | -------- |
| id     | 1652097604414 | Text     | 是       | -        |
| page   | 1             | Text     | 是       | -        |
| limit  | 5             | Text     | 是       | -        |

#### 请求 Body 参数

```javascript

```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/演员/获取导演合作导演

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/director/cooperate?id=1652097604414&page=1&limit=5

#### 请求方式

> GET

#### Content-Type

> json

#### 请求 Query 参数

| 参数名 | 示例值        | 参数类型 | 是否必填 | 参数描述 |
| ------ | ------------- | -------- | -------- | -------- |
| id     | 1652097604414 | Text     | 是       | -        |
| page   | 1             | Text     | 是       | -        |
| limit  | 5             | Text     | 是       | -        |

#### 请求 Body 参数

```javascript

```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/演员/获取演员合作演员

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/actor/cooperate?id=1652152775219&page=1&limit=2

#### 请求方式

> GET

#### Content-Type

> json

#### 请求 Query 参数

| 参数名 | 示例值        | 参数类型 | 是否必填 | 参数描述 |
| ------ | ------------- | -------- | -------- | -------- |
| id     | 1652152775219 | Text     | 是       | -        |
| page   | 1             | Text     | 是       | -        |
| limit  | 2             | Text     | 是       | -        |

#### 请求 Body 参数

```javascript

```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/演员/获取演员合作导演

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/director/actor/cooperate?id=1652152775219&page=1&limit=5

#### 请求方式

> GET

#### Content-Type

> json

#### 请求 Query 参数

| 参数名 | 示例值        | 参数类型 | 是否必填 | 参数描述 |
| ------ | ------------- | -------- | -------- | -------- |
| id     | 1652152775219 | Text     | 是       | -        |
| page   | 1             | Text     | 是       | -        |
| limit  | 5             | Text     | 是       | -        |

#### 请求 Body 参数

```javascript

```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/职业

```text
暂无描述
```

#### 公共 Header 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 公共 Query 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 公共 Body 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/职业/新建职业

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/occupation/

#### 请求方式

> POST

#### Content-Type

> json

#### 请求 Body 参数

```javascript
{
    "name":"剪辑"
}
```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/职业/为导演演员添加职业

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/occupation/dId/1652097604414/1652100299387

#### 请求方式

> POST

#### Content-Type

> json

#### 请求 Body 参数

```javascript

```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/职业/获取所有职业

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/occupation/all

#### 请求方式

> GET

#### Content-Type

> json

#### 请求 Body 参数

```javascript

```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/电影

```text
暂无描述
```

#### 公共 Header 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 公共 Query 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 公共 Body 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/电影/形式

```text
暂无描述
```

#### 公共 Header 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 公共 Query 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 公共 Body 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/电影/形式/添加影视形式

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/movie/form

#### 请求方式

> POST

#### Content-Type

> json

#### 请求 Body 参数

```javascript
{
    "name":"短片"
}
```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/电影/形式/获取所有形式

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/movie/form/all

#### 请求方式

> GET

#### Content-Type

> json

#### 请求 Body 参数

```javascript

```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/电影/地区

```text
暂无描述
```

#### 公共 Header 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 公共 Query 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 公共 Body 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/电影/地区/新建地区

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/movie/area

#### 请求方式

> POST

#### Content-Type

> json

#### 请求 Body 参数

```javascript
{
    "name":"德国"
}
```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/电影/地区/获取所有地区

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/movie/area/all

#### 请求方式

> GET

#### Content-Type

> json

#### 请求 Body 参数

```javascript

```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/电影/类型

```text
暂无描述
```

#### 公共 Header 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 公共 Query 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 公共 Body 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/电影/类型/标签

```text
暂无描述
```

#### 公共 Header 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 公共 Query 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 公共 Body 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/电影/类型/新建类型

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/movie/cate

#### 请求方式

> POST

#### Content-Type

> json

#### 请求 Body 参数

```javascript
{
    "name":"武侠"
}
```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/电影/类型/新建标签

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/movie/tag/

#### 请求方式

> POST

#### Content-Type

> json

#### 请求 Body 参数

```javascript
{
    "name":"血腥"
}
```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/电影/类型/获取所有分类

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/movie/cate/all

#### 请求方式

> GET

#### Content-Type

> json

#### 请求 Body 参数

```javascript

```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/电影/添加电影

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/movie/

#### 请求方式

> POST

#### Content-Type

> json

#### 请求 Body 参数

```javascript
{
    "name":"复仇者联盟",
    "directorList":["1652097604414","1652105949804"],
    "screenwriterList":["1652195889420"],
    "areaList":["1652189733153","1652189745734"],
    "actorList":["1652014592779","1652152711455"],
    "language":"华语",
    "releaseTime":"2022-10-12",
    "duration":15000,
    "alias":"花花",
    "formItem":"1652189378407",
    "cateList":["1652190067124","1652190054769"],
    "description":"45"
}
```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/电影/获取所有电影

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/movie/all?page=2&limit=10

#### 请求方式

> GET

#### Content-Type

> json

#### 请求 Query 参数

| 参数名  | 示例值        | 参数类型 | 是否必填 | 参数描述 |
| ------- | ------------- | -------- | -------- | -------- |
| form    | 1652189371834 | Text     | 是       | -        |
| keyword | 尔            | Text     | 是       | -        |
| page    | 2             | Text     | 是       | -        |
| limit   | 10            | Text     | 是       | -        |

#### 请求 Body 参数

```javascript

```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/电影/更新电影信息

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/movie/update

#### 请求方式

> POST

#### Content-Type

> json

#### 请求 Body 参数

```javascript
{
    "id":"1652238044529",
    "name":"复仇者联盟",
    "directorList":["1652109786913","1652105949804"],
    "screenwriterList":["1652195889420"],
    "areaList":["1652189733153","1652189745734","1652189767862"],
    "actorList":["1652014592779","1652494690386"],
    "language":"华语",
    "releaseTime":"2022-11-12",
    "duration":15000,
    "alias":"花花",
    "formItem":"1652189378407",
    "cateList":["1652190067124","1652190106859"],
    "description":"45222"
}
```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/电影/上传电影封面

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/movie/cover/upload/1652237815469

#### 请求方式

> POST

#### Content-Type

> form-data

#### 请求 Body 参数

| 参数名 | 示例值                             | 参数类型 | 是否必填 | 参数描述 |
| ------ | ---------------------------------- | -------- | -------- | -------- |
| cover  | C:\Users\guo'bin\Desktop\photo.jpg | File     | 是       | -        |

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/电影/获取封面

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> http://localhost:8888/movie/cover/1652237815469

#### 请求方式

> GET

#### Content-Type

> json

#### 请求 Body 参数

```javascript

```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/电影/跟新电影信息

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/movie/update

#### 请求方式

> POST

#### Content-Type

> json

#### 请求 Body 参数

```javascript

```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/电影/更新电影封面

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/movie/cover/update/1653111702293

#### 请求方式

> POST

#### Content-Type

> form-data

#### 请求 Body 参数

| 参数名 | 示例值                               | 参数类型 | 是否必填 | 参数描述 |
| ------ | ------------------------------------ | -------- | -------- | -------- |
| cover  | C:\Users\guo'bin\Desktop\周慧明.jpeg | File     | 是       | -        |

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/电影/删除电影

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/movie/delete/1653111702293

#### 请求方式

> POST

#### Content-Type

> json

#### 请求 Body 参数

```javascript

```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/电影/根据导演获取电影

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/movie/director/1652105949804?page=1&limit=2

#### 请求方式

> GET

#### Content-Type

> json

#### 请求 Query 参数

| 参数名 | 示例值 | 参数类型 | 是否必填 | 参数描述 |
| ------ | ------ | -------- | -------- | -------- |
| page   | 1      | Text     | 是       | -        |
| limit  | 2      | Text     | 是       | -        |

#### 请求 Body 参数

```javascript

```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/电影/获取电影根据演员

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/movie/actor/1652014592779?page=1&limit=3

#### 请求方式

> GET

#### Content-Type

> json

#### 请求 Query 参数

| 参数名 | 示例值 | 参数类型 | 是否必填 | 参数描述 |
| ------ | ------ | -------- | -------- | -------- |
| page   | 1      | Text     | 是       | -        |
| limit  | 3      | Text     | 是       | -        |

#### 请求 Body 参数

```javascript

```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/编剧

```text
暂无描述
```

#### 公共 Header 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 公共 Query 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 公共 Body 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/编剧/新建编剧

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/screenwriter/

#### 请求方式

> POST

#### Content-Type

> json

#### 请求 Body 参数

```javascript
{
    "name":"兰晓龙",
    "alias":"Xiaolong Lan",
    "family":"兰图",
    "gender":"0",
    "birthPlace":"中国，湖南邵阳",
    "birth":"2022-04-04",
    "description":"　兰晓龙，湖南邵阳人，1973年5月26日出生。1997年毕业于中央戏剧学院，后进入北京军区战友话剧团成为一名职业编剧。曾创作了话剧《红星照耀中国》，电视剧《石磊大夫》、《步兵团长》、《士兵突击》、《我的团长我的团》、《生死线》。",
    "occupationList":["1652100361394","1652100137884"]
}
```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/编剧/获取所有编剧

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/screenwriter/all?page=1&limit=2

#### 请求方式

> GET

#### Content-Type

> json

#### 请求 Query 参数

| 参数名 | 示例值 | 参数类型 | 是否必填 | 参数描述 |
| ------ | ------ | -------- | -------- | -------- |
| page   | 1      | Text     | 是       | -        |
| limit  | 2      | Text     | 是       | -        |

#### 请求 Body 参数

```javascript

```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/读书

```text
暂无描述
```

#### 公共 Header 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 公共 Query 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 公共 Body 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/读书/作家

```text
暂无描述
```

#### 公共 Header 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 公共 Query 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 公共 Body 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/读书/作家/添加作家

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/writer

#### 请求方式

> POST

#### Content-Type

> json

#### 请求 Body 参数

```javascript
{
    "name":"毛姆",
    "gender":"0",
    "birth":"2000-04-15",
    "birthPlace":"英国",
    "area":"英国",
    "foreignName":"嘎嘎嘎",
    "alias":"W. Somerset Maugham",
    "description":"索默斯特·毛姆，英国著名小说家，剧作家，散文家。毛姆原是医学系学生，后转而致力写作。生于巴黎，中学毕业后在德国海德堡大学肄业。1892年至1897年在伦敦学医，并取得外科医师资格。他的第一部长篇小说《兰贝斯的丽莎》（1897）即根据他作为贝可医生在贫民区为产妇接生时的见闻用自由主义写法写成。1903-1933年，他创作了近30部剧本，深受观众欢迎。1908年，伦敦有4家剧院同时演出他的4部剧作，在英国形成空前盛况。他的喜剧受五尔德的影响较深，一般以家庭、婚姻"
}
```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/读书/作家/获取所有作家

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/writer/all?page=1&limit=20&keyword=毛

#### 请求方式

> GET

#### Content-Type

> json

#### 请求 Query 参数

| 参数名  | 示例值 | 参数类型 | 是否必填 | 参数描述 |
| ------- | ------ | -------- | -------- | -------- |
| page    | 1      | Text     | 是       | -        |
| limit   | 20     | Text     | 是       | -        |
| keyword | 毛     | Text     | 是       | -        |

#### 请求 Body 参数

```javascript

```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/读书/出版社

```text
暂无描述
```

#### 公共 Header 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 公共 Query 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 公共 Body 参数

| 参数名   | 示例值 | 参数描述 |
| -------- | ------ | -------- |
| 暂无参数 |        |          |

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/读书/出版社/添加出版社

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/publish

#### 请求方式

> POST

#### Content-Type

> json

#### 请求 Body 参数

```javascript
{
    "name":"人民邮电出版社",
    "foreignName":"renmin",
    "representative":"郭斌",
    "industry":"教育读物",
    "establish":"1999-08-15",
    "online":"https:www.baidu.com",
    "organizer":"大洗浴",
    "description":"欢饮来袭",
    "type":"教育"
}
```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

## /rev-com/读书/出版社/获取所有出版社

```text
暂无描述
```

#### 接口状态

> 开发中

#### 接口 URL

> {{baseUrl}}/publish/all?page=1&limit=10&keyword=1

#### 请求方式

> GET

#### Content-Type

> json

#### 请求 Query 参数

| 参数名  | 示例值 | 参数类型 | 是否必填 | 参数描述 |
| ------- | ------ | -------- | -------- | -------- |
| page    | 1      | Text     | 是       | -        |
| limit   | 10     | Text     | 是       | -        |
| keyword | 1      | Text     | 是       | -        |

#### 请求 Body 参数

```javascript

```

#### 预执行脚本

```javascript
暂无预执行脚本;
```

#### 后执行脚本

```javascript
暂无后执行脚本;
```

### Customize configuration

See [Configuration Reference](https://cli.vuejs.org/config/).
