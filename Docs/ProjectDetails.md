# Convio Dating App

This is a dating app focused on college/university students. Get recommended matches from the same college/university. Filter throught possible matches by field of study or age, etc.

## Tech Stack

* Frontend - React.js, vite, tailwindcss, tanstackquery

* Backend - Springboot

* Database - postgresSql

* File Storage - Amazon S3 bucket

## Api endpoints

* Like or pass endpoint - Swiping
* Preferences endpoint - minAge/FieldOfStudy/maxDistance etc.. 
* Matching endpoint - Confirmed matches
* Messages - Messaging confirmed match
* Notifications - Email verification/New matches etc...

## Database tables

- Users
    - id 
    - university_id
    - college/university email - .edu
    - email_verified

- Matches
    - id (Unique match)
    - user1_id
    - user2_id
    - timestamp

- Swipes
    - Swiper_id
    - target_id (recommended)
    - Decision

- Messages
    - id
    - match_id
    - Message

- Preferences
    - user_id
    - minimum_age
    - maximum_age
    - maximum_distance_miles
    - gender

- Profiles
    - user_id
    - name
    - birth_date
    - bio
    - gender
    - major
    - City

