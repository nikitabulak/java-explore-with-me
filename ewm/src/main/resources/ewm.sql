CREATE TABLE events (
  event_id bigint PRIMARY KEY,
  annotation varchar(300),
  category_id bigint,
  created_on timestamp,
  description varchar(500),
  event_date timestamp,
  initiator_id bigint,
  paid boolean,
  participant_limit int,
  published_on timestamp,
  request_moderation boolean,
  state varchar(20),
  title varchar(50)
);

CREATE TABLE categories (
  category_id bigint PRIMARY KEY,
  name varchar(100)
);

CREATE TABLE users (
  user_id bigint PRIMARY KEY,
  name varchar(100),
  email varchar(50)
);

CREATE TABLE compilations (
  compilation_id bigint PRIMARY KEY,
  title varchar(100),
  pinned boolean
);

CREATE TABLE compilations_events (
  compilation_id bigint,
  event_id bigint,
  PRIMARY KEY (compilation_id, event_id)
);

CREATE TABLE requests (
  request_id bigint PRIMARY KEY,
  requester_id bigint,
  event_id bigint,
  created timestamp,
  status varchar(20)
);

ALTER TABLE events ADD FOREIGN KEY (category_id) REFERENCES categories (category_id) ON DELETE CASCADE;

ALTER TABLE events ADD FOREIGN KEY (initiator_id) REFERENCES users (user_id) ON DELETE CASCADE;

ALTER TABLE requests ADD FOREIGN KEY (event_id) REFERENCES events (event_id);

ALTER TABLE requests ADD FOREIGN KEY (requester_id) REFERENCES users (user_id);

ALTER TABLE compilations_events ADD FOREIGN KEY (event_id) REFERENCES events (event_id);

ALTER TABLE compilations_events ADD FOREIGN KEY (compilation_id) REFERENCES compilations (compilation_id) ON DELETE CASCADE;
