PROMPT ALTER TABLE cardio_user_roles ADD CONSTRAINT unq_cardio_user_roles PRIMARY KEY
ALTER TABLE cardio_user_roles
  ADD CONSTRAINT unq_cardio_user_roles PRIMARY KEY (
    user_id,
    role_id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

