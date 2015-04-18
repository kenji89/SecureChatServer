drop table securechat.users;

create table securechat.users (
	id mediumint not null auto_increment,
	username varchar(20) not null,
	hashed_password varchar(255) not null,
	primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;