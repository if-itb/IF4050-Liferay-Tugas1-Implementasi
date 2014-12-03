create table socialservice_Foo (
	fooId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	field1 VARCHAR(75) null,
	field2 BOOLEAN,
	field3 INTEGER,
	field4 DATE null,
	field5 VARCHAR(75) null
);

create table socialservice_Message (
	messageId LONG not null primary key,
	title VARCHAR(75) null,
	content VARCHAR(75) null,
	date_ DATE null
);