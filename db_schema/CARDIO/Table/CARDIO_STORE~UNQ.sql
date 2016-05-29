PROMPT ALTER TABLE cardio_store ADD CONSTRAINT pk_cardio_store PRIMARY KEY
ALTER TABLE cardio_store
  ADD CONSTRAINT pk_cardio_store PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

