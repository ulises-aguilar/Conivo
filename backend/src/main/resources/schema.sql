CREATE TABLE IF NOT EXISTS users (

    id UUID PRIMARY KEY,
    universityId VARCHAR(20) NOT NULL UNIQUE,
    universityEmail VARCHAR(20) NOT NULL UNIQUE,
    email_verified BOOLEAN NOT NULL
);


CREATE TABLE IF NOT EXISTS swipes (

    swiper_id UUID NOT NULL,
    target_id UUID NOT NULL,
    decision BOOLEAN NOT NULL,
    CHECK (swiper_id <> target_id),

    PRIMARY KEY (swiper_id, target_id),

    FOREIGN KEY (swiper_id) REFERENCES users(id),
    FOREIGN KEY (target_id) REFERENCES users(id)
);