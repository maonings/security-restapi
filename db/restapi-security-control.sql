set charset utf8;

# 创建并使用数据库
CREATE DATABASE IF NOT EXISTS restapi_security_control default charset utf8 COLLATE utf8_general_ci;
use restapi_security_control;

# 系统用户表,更多字段根据具体业务自行扩展
create table IF NOT EXISTS sys_user (
	id int primary key auto_increment,
	username varchar(20) UNIQUE KEY not null comment '登录用户名',
	password varchar(128) not null comment '登录密码',
	disabled tinyint default 0 not null comment '0：未禁用，1：被禁用'
) ENGINE = INNODB;

# 系统用户角色表
create table IF NOT EXISTS sys_role (
	id tinyint primary key AUTO_INCREMENT,
	code varchar(20) UNIQUE KEY not null comment '角色编码，eg: admin、user、guester',
	name varchar(128) not null comment '角色名称，eg：超级管理员、普通用户，访客',
	disabled tinyint default 0 not null comment '0：未禁用，1：被禁用'
) ENGINE = INNODB;

# 权限表
create table IF NOT EXISTS sys_permission (
	id tinyint primary key AUTO_INCREMENT,
	resource_id int not null comment '资源ID',
	action_id tinyint not null comment '操作ID',
	permission_type tinyint not null comment '1：资源访问权限，2：按钮可见性'
) ENGINE = INNODB;

# 用户角色关联变
create table IF NOT EXISTS sys_relation_user_role (
	id int primary key AUTO_INCREMENT,
	user_id int not null,
	role_id int not null
) ENGINE = INNODB;

# 角色权限表
create table IF NOT EXISTS sys_relation_role_permission (
	id int primary key AUTO_INCREMENT,
	role_id int not null,
	permission_id int not null
) ENGINE = INNODB;

# 资源表(树结构)
create table IF NOT EXISTS sys_resource (
	id int primary key AUTO_INCREMENT,
	pid int comment '父节点，null代表根节点',
	url varchar(50) not null comment '资源路径，#代表非链接菜单',
	name varchar(20) comment '资源名称',
	is_menu tinyint not null comment '0：不是菜单，1：是菜单',
	icon_unicode varchar(6) comment '菜单Unicode格式图标',
	description varchar(100) comment '资源描述'
) ENGINE = INNODB;

# 操作表
create table IF NOT EXISTS sys_action (
	id tinyint primary key AUTO_INCREMENT,
	action_name varchar(20),
	http_method varchar(20)
) ENGINE = INNODB;

# 按钮表
create table IF NOT EXISTS sys_button (
	id tinyint primary key AUTO_INCREMENT,
	button_type varchar(20),
	button_name varchar(20)
) ENGINE = INNODB;