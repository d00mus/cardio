PROMPT ALTER TABLE user_occupation ADD CONSTRAINT fk_user_occupation_comp FOREIGN KEY
ALTER TABLE user_occupation
  ADD CONSTRAINT fk_user_occupation_comp FOREIGN KEY (
    company_id
  ) REFERENCES cardio_company (
    id
  )
/

PROMPT ALTER TABLE user_occupation ADD CONSTRAINT fk_user_occupation_user FOREIGN KEY
ALTER TABLE user_occupation
  ADD CONSTRAINT fk_user_occupation_user FOREIGN KEY (
    user_id
  ) REFERENCES cardio_user (
    id
  )
/

