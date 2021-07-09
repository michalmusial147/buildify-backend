create sequence hibernate_sequence start 1 increment 1
create table app_user_roles (app_user_id int4 not null, roles int4)
create table appusers (id int4 not null, first_name varchar(255), last_name varchar(255), password varchar(255), token varchar(255), username varchar(255), primary key (id))
create table candidate (id varchar(255) not null, name varchar(255), primary key (id))
create table offers (id int4 not null, city varchar(255), country varchar(255), date_posted timestamp, description TEXT, photo TEXT, postal_code varchar(255), price int4 not null, region varchar(255), rooms varchar(255), street varchar(255), title varchar(255), type varchar(255), user_id int4 not null, appuser_id int4 not null, primary key (id))
alter table if exists app_user_roles add constraint FK1cjn8skl7fvhkwyqbv1fye8ln foreign key (app_user_id) references appusers
alter table if exists offers add constraint FKnh7xxc0guhr5daee2y30x6fdi foreign key (appuser_id) references appusers
create sequence hibernate_sequence start 1 increment 1
create table app_user_roles (app_user_id int4 not null, roles int4)
create table appusers (id int4 not null, first_name varchar(255), last_name varchar(255), password varchar(255), token varchar(255), username varchar(255), primary key (id))
create table candidate (id varchar(255) not null, name varchar(255), primary key (id))
create table offers (id int4 not null, city varchar(255), country varchar(255), date_posted timestamp, description TEXT, photo TEXT, postal_code varchar(255), price int4 not null, region varchar(255), rooms varchar(255), street varchar(255), title varchar(255), type varchar(255), user_id int4 not null, appuser_id int4 not null, primary key (id))
alter table if exists app_user_roles add constraint FK1cjn8skl7fvhkwyqbv1fye8ln foreign key (app_user_id) references appusers
alter table if exists offers add constraint FKnh7xxc0guhr5daee2y30x6fdi foreign key (appuser_id) references appusers
create sequence hibernate_sequence start 1 increment 1
create table app_user_roles (app_user_id int4 not null, roles int4)
create table appusers (id int4 not null, first_name varchar(255), last_name varchar(255), password varchar(255), token varchar(255), username varchar(255), primary key (id))
create table candidate (id varchar(255) not null, name varchar(255), primary key (id))
create table offers (id int4 not null, city varchar(255), country varchar(255), date_posted timestamp, description TEXT, photo TEXT, postal_code varchar(255), price int4 not null, region varchar(255), rooms varchar(255), street varchar(255), title varchar(255), type varchar(255), user_id int4 not null, appuser_id int4 not null, primary key (id))
alter table if exists app_user_roles add constraint FK1cjn8skl7fvhkwyqbv1fye8ln foreign key (app_user_id) references appusers
alter table if exists offers add constraint FKnh7xxc0guhr5daee2y30x6fdi foreign key (appuser_id) references appusers
create sequence hibernate_sequence start 1 increment 1
create table app_user_roles (app_user_id int4 not null, roles int4)
create table appusers (id int4 not null, first_name varchar(255), last_name varchar(255), password varchar(255), token varchar(255), username varchar(255), primary key (id))
create table candidate (id varchar(255) not null, name varchar(255), primary key (id))
create table offers (id int4 not null, city varchar(255), country varchar(255), date_posted timestamp, description TEXT, photo TEXT, postal_code varchar(255), price int4 not null, region varchar(255), rooms varchar(255), street varchar(255), title varchar(255), type varchar(255), user_id int4 not null, appuser_id int4 not null, primary key (id))
alter table if exists app_user_roles add constraint FK1cjn8skl7fvhkwyqbv1fye8ln foreign key (app_user_id) references appusers
alter table if exists offers add constraint FKnh7xxc0guhr5daee2y30x6fdi foreign key (appuser_id) references appusers
create sequence hibernate_sequence start 1 increment 1
create table app_user_roles (app_user_id int4 not null, roles int4)
create table appusers (id int4 not null, first_name varchar(255), last_name varchar(255), password varchar(255), token varchar(255), username varchar(255), primary key (id))
create table candidate (id varchar(255) not null, name varchar(255), primary key (id))
create table offers (id int4 not null, city varchar(255), country varchar(255), date_posted timestamp, description TEXT, photo TEXT, postal_code varchar(255), price int4 not null, region varchar(255), rooms varchar(255), street varchar(255), title varchar(255), type varchar(255), user_id int4 not null, appuser_id int4 not null, primary key (id))
alter table if exists app_user_roles add constraint FK1cjn8skl7fvhkwyqbv1fye8ln foreign key (app_user_id) references appusers
alter table if exists offers add constraint FKnh7xxc0guhr5daee2y30x6fdi foreign key (appuser_id) references appusers
create sequence hibernate_sequence start 1 increment 1
create table app_user_roles (app_user_id int4 not null, roles int4)
create table appusers (id int4 not null, first_name varchar(255), last_name varchar(255), password varchar(255), token varchar(255), username varchar(255), primary key (id))
create table candidate (id varchar(255) not null, name varchar(255), primary key (id))
create table offers (id int4 not null, city varchar(255), country varchar(255), date_posted timestamp, description TEXT, photo TEXT, postal_code varchar(255), price int4 not null, region varchar(255), rooms varchar(255), street varchar(255), title varchar(255), type varchar(255), user_id int4 not null, appuser_id int4 not null, primary key (id))
alter table if exists app_user_roles add constraint FK1cjn8skl7fvhkwyqbv1fye8ln foreign key (app_user_id) references appusers
alter table if exists offers add constraint FKnh7xxc0guhr5daee2y30x6fdi foreign key (appuser_id) references appusers
create sequence hibernate_sequence start 1 increment 1
create table app_user_roles (app_user_id int4 not null, roles int4)
create table appusers (id int4 not null, first_name varchar(255), last_name varchar(255), password varchar(255), token varchar(255), username varchar(255), primary key (id))
create table candidate (id varchar(255) not null, name varchar(255), primary key (id))
create table offers (id int4 not null, city varchar(255), country varchar(255), date_posted timestamp, description TEXT, photo TEXT, postal_code varchar(255), price int4 not null, region varchar(255), rooms varchar(255), street varchar(255), title varchar(255), type varchar(255), user_id int4 not null, appuser_id int4 not null, primary key (id))
alter table if exists app_user_roles add constraint FK1cjn8skl7fvhkwyqbv1fye8ln foreign key (app_user_id) references appusers
alter table if exists offers add constraint FKnh7xxc0guhr5daee2y30x6fdi foreign key (appuser_id) references appusers
