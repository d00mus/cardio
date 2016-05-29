PROMPT ALTER TABLE cardio_user ADD CONSTRAINT pk_cardio_user PRIMARY KEY
ALTER TABLE cardio_user
  ADD CONSTRAINT pk_cardio_user PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE cardio_user ADD CONSTRAINT unq_cardio_user UNIQUE
ALTER TABLE cardio_user
  ADD CONSTRAINT unq_cardio_user UNIQUE (
    user_name
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

