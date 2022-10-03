DROP TABLE IF EXISTS EVENTS, CATEGORIES, USERS, COMPILATIONS, COMPILATIONS_EVENTS, REQUESTS;

CREATE TABLE USERS
(
    id bigint GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name    varchar(100) NOT NULL,
    email   varchar(50) NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id),
    CONSTRAINT UQ_USER_EMAIL UNIQUE (email)
);

CREATE TABLE CATEGORIES
(
    id bigint GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name        varchar(100),
    CONSTRAINT pk_categories PRIMARY KEY (id),
    CONSTRAINT uq_categories_name UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS EVENTS
(
    id           bigint GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    annotation         varchar(2000) NOT NULL,
    category_id        bigint REFERENCES CATEGORIES (id) ON DELETE CASCADE NOT NULL,
    created_on         timestamp NOT NULL,
    description        varchar(7000) NOT NULL,
    event_date         timestamp NOT NULL,
    initiator_id       bigint REFERENCES USERS (id) ON DELETE CASCADE NOT NULL,
    paid               boolean,
    participant_limit  int,
    published_on       timestamp NOT NULL,
    request_moderation boolean,
    state              varchar(20) NOT NULL,
    title              varchar(120) NOT NULL,
    CONSTRAINT pk_events PRIMARY KEY (id)
);

CREATE TABLE COMPILATIONS
(
    id bigint GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    title          varchar(100),
    pinned         boolean,
    CONSTRAINT pk_compilations PRIMARY KEY (id)
);

CREATE TABLE COMPILATIONS_EVENTS
(
    compilation_id bigint REFERENCES COMPILATIONS (id) ON DELETE CASCADE,
    event_id       bigint REFERENCES EVENTS (id),
    CONSTRAINT pk_compilations_events PRIMARY KEY (compilation_id, event_id)
);

CREATE TABLE REQUESTS
(
    id   bigint GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    requester_id bigint REFERENCES USERS (id),
    event_id     bigint REFERENCES EVENTS (id),
    created      timestamp,
    status       varchar(20),
    CONSTRAINT pk_requests PRIMARY KEY (id)
);