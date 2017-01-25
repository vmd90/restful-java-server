
CREATE TABLE user(
    id BIGSERIAL,
    name VARCHAR(30) NOT NULL,
    email VARCHAR(30) NOT NULL,
    password VARCHAR(30) NOT NULL,
    
    PRIMARY KEY(id),
    UNIQUE(name)
);

CREATE TABLE talk(
    id BIGSERIAL,
    user_one BIGINT NOT NULL,
    user_two BIGINT NOT NULL,
    time TIMESTAMP DEFAULT NOW(),
    
    PRIMARY KEY(id),
    FOREIGN KEY (user_one) REFERENCES user(id),
    FOREIGN KEY (user_two) REFERENCES user(id)
);

CREATE TABLE message(
    id BIGSERIAL,
    user_id BIGINT NOT NULL,
    created_date TIMESTAMP DEFAULT NOW(),
    text TEXT NOT NULL,
    talk_id BIGINT NOT NULL,
    is_read BOOLEAN DEFAULT FALSE,
    
    PRIMARY KEY(id),
    FOREIGN KEY(user_id) REFERENCES user(id),
    FOREIGN KEY(talk_id) REFERENCES talk(id)
);

-- talk list
SELECT U.id, T.id, U.name, U.email 
    FROM user U, talk T, message M
    WHERE 
    CASE
        WHEN T.user_one = 13
        THEN T.user_two = U.id
        WHEN T.user_two = 13
        THEN T.user_one = U.id
    END
    AND T.id = M.talk_id AND (T.user_one = 13 OR T.user_two = 13) 
    ORDER BY T.id DESC;

-- talk last message
SELECT id, time, text FROM message
    WHERE talk_id = 2
    ORDER BY id DESC LIMIT 1;

