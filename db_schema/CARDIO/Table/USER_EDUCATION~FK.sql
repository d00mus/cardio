PROMPT ALTER TABLE user_education ADD CONSTRAINT fk_user_educaion_user FOREIGN KEY
ALTER TABLE user_education
  ADD CONSTRAINT fk_user_educaion_user FOREIGN KEY (
    user_id
  ) REFERENCES cardio_user (
    id
  )
/

