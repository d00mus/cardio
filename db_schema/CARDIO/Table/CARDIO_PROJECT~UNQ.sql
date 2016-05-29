PROMPT ALTER TABLE cardio_project ADD CONSTRAINT pk_cardio_project PRIMARY KEY
ALTER TABLE cardio_project
  ADD CONSTRAINT pk_cardio_project PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

