# Database Schemas

- Users table
    - id(Primary key)
    - university id
    - college/uni email (.edu)
    - email_verified

- Matches table
    - id (Primary key)
    - user1_id (Foreign key - Users.id)
    - user2_id (Foreign key - Users.id)
    - timestamp(When they matched)

- Swipes table
    - swiper_id(Foreign key)
    - target_id (Foreign key)
    - Decision

- Messages table
    - id (Primary key)
    - match_id(Foreign key- matches.id)
    - sender_id (foreign key - Users.id)
    - message

- Preferences table
    - user_id(Foreign key, primary key)
    - minimum_age
    - maximum_age
    - maximum_distance_miles
    - gender
    - major

- profiles
    - user_id(foreign key)
    - name
    - birth_date
    - bio
    - gender
    - major
    - City

