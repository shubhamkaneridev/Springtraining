-- Create table
create table APPLICANTS
(
  ID       VARCHAR(50) not null,
  GENDER   VARCHAR(10) not null,
  NAME     VARCHAR(50) not null,
  POSITION VARCHAR(50) not null,
  SKILLS   VARCHAR(255) not null,
  EMAIL    VARCHAR(50) not null,
  primary key (ID)
) ;