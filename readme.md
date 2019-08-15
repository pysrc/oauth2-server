## OAuth2-Server

### 表说明

#### 用户表：tb_user

定义用户

#### 角色表：tb_role

定义角色

#### 权限表：tb_permission

定义各种权限名称


#### 用户-角色关联表：tb_user_role

将用户与角色关联

#### 角色-权限关联表：tb_role_permission

将角色与权限关联

#### 其余表

OAuth2系统必须的表

#### 客户端定义表 oauth_client_details

其中client_secret字段需要与密码一样加密见：com.github.pysrc.oauth2.Encoder



### 初始化的用户

#### 管理员

admin:admin

#### 测试用户（只能查看资源，在OAuth2客户端定义权限对应的路径）

test:test

### 用户登入


登入之前需要启动客户端才能执行登陆成功的跳转

`http://localhost:8080/oauth/authorize?client_id=client&response_type=code`


## OAuth2-Client

https://github.com/pysrc/oauth2-client
