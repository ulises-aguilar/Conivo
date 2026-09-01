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

CREATE TABLE IF not EXISTS profiles (
    user_id UUID PRIMARY KEY,
    name VARCHAR(25) NOT NULL,
    DOB DATE NOT NULL,
    bio VARCHAR(75),
    gender VARCHAR(20) NOT NULL,
    major VARCHAR(20) NOT NULL,
    city VARCHAR(20) NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users(id)
)