drop table securechat.friends;

create table securechat.friends (
	user_id mediumint not null auto_increment,
	friend_id mediumint not null,
	primary key(user_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;