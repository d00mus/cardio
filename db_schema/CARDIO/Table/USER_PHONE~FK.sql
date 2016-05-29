PROMPT ALTER TABLE user_phone ADD CONSTRAINT fk_user_phone_type FOREIGN KEY
ALTER TABLE user_phone
  ADD CONSTRAINT fk_user_phone_type FOREIGN KEY (
    phone_type_id
  ) REFERENCES tel_type (
    id
  )
/

PROMPT ALTER TABLE user_phone ADD CONSTRAINT fk_user_phone_user FOREIGN KEY
ALTER TABLE user_phone
  ADD CONSTRAINT fk_user_phone_user FOREIGN KEY (
    user_id
  ) REFERENCES cardio_user (
    id
  )
/

