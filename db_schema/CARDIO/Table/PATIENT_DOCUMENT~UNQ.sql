PROMPT ALTER TABLE patient_document ADD CONSTRAINT pk_patient_document PRIMARY KEY
ALTER TABLE patient_document
  ADD CONSTRAINT pk_patient_document PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

