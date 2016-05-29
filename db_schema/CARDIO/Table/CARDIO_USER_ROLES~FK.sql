PROMPT ALTER TABLE cardio_user_roles ADD CONSTRAINT fk_cardio_role_id FOREIGN KEY
ALTER TABLE cardio_user_roles
  ADD CONSTRAINT fk_cardio_role_id FOREIGN KEY (
    role_id
  ) REFERENCES cardio_role (
    id
  ) ON DELETE CASCADE
/

PROMPT ALTER TABLE cardio_user_roles ADD CONSTRAINT fk_cardio_user_id FOREIGN KEY
ALTER TABLE cardio_user_roles
  ADD CONSTRAINT fk_cardio_user_id FOREIGN KEY (
    user_id
  ) REFERENCES cardio_user (
    id
  ) ON DELETE CASCADE
/

