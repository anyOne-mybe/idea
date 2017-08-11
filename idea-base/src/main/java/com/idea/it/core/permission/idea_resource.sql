--系统资源定义表
create table tpl_idea_resource(
	id int(10) not null auto_increment,
	resource_code varchar(100),
	resource_desc varchar(200),
	resource_type varchar(20),
	operation_code varchar(100),
	opetation_desc varchar(200),
	app_name        varchar(50),
	available       char(1),
	update_time     TIMESTAMP,
	update_by       int(15),
	primary key(id),
	unique(resource_code,resource_type,operation_code,app_name)
);
