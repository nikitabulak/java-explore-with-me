CREATE TABLE hits (
  hit_id bigint PRIMARY KEY,
  app varchar(300),
  uri varchar(300),
  ip varchar(100),
  timestamp timestamp
);
