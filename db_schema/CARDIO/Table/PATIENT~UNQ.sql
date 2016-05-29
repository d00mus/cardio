PROMPT ALTER TABLE patient ADD CONSTRAINT pk_patient PRIMARY KEY
ALTER TABLE patient
  ADD CONSTRAINT pk_patient PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

