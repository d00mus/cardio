PROMPT ALTER TABLE cardio_role ADD CONSTRAINT pk_cardio_role PRIMARY KEY
ALTER TABLE cardio_role
  ADD CONSTRAINT pk_cardio_role PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE cardio_role ADD CONSTRAINT unq_cardio_role UNIQUE
ALTER TABLE cardio_role
  ADD CONSTRAINT unq_cardio_role UNIQUE (
    role_name
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

