--系统资源定义表
create table idea_resource(
	id int(10) not null auto_increment,
	resource_code varchar(100),
	resource_desc varchar(200),
	operation_code varchar(100),
	opetation_desc varchar(200),
	primary key(id)
);