CREATE TABLE IF NOT EXISTS users (

    id UUID PRIMARY KEY,
    universityId VARCHAR(20) NOT NULL UNIQUE,
    universityEmail VARCHAR(20) NOT NULL UNIQUE,
    email_verfied BOOLEAN NOT NULL
);