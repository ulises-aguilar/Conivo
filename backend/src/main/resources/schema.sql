CREATE TABLE IF NOT EXISTS users (

    id UUID PRIMARY KEY,
    university_id VARCHAR(20) NOT NULL UNIQUE,
    college_email VARCHAR(20) NOT NULL UNIQUE,
    email_verfied BOOLEAN NOT NULL
);