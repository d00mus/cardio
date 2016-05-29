PROMPT ALTER TABLE cardio_company ADD CONSTRAINT pk_cardio_company PRIMARY KEY
ALTER TABLE cardio_company
  ADD CONSTRAINT pk_cardio_company PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

