--菜单栏目表
CREATE TABLE IDEA_MENUE(
	ID          INT(15) NOT NULL AUTO_INCREMENT,
	NAME        VARCHAR(50),
	PARENT_ID   INT(15),
	URL         VARCHAR(200),
	APP_NAME    VARCHAR(100),
	sort        int(3),
	CREATE_BY   INT(15),
	UPDATE_BY   INT(15),
	CRATE_DATE  TIMESTAMP,
	UPDATE_DATE TIMESTAMP,
	PRIMARY KEY(ID)
);