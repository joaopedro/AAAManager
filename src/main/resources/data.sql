  DROP TABLE Token;

CREATE TABLE ApplicationUser (
   username VARCHAR(50) NOT NULL,
   name VARCHAR(50),
   password VARCHAR(50) NOT NULL,
   comment VARCHAR(20),
   enabled boolean not null,
   PRIMARY KEY (username)
);

create table UserAuthority (
  username varchar_ignorecase(50) not null,
  authority varchar_ignorecase(50) not null,
  constraint fk_authorities_users foreign key(username) references ApplicationUser(username));
  create unique index ix_auth_username on UserAuthority (username,authority);

create table Token (
    token_id varchar(36) not null,
    acess_token varchar(2000) not null,
    expires_in datetime not null,
    token_type varchar(50)
)