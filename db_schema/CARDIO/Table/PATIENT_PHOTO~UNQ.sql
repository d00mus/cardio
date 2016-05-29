PROMPT ALTER TABLE patient_photo ADD CONSTRAINT pk_patient_photo PRIMARY KEY
ALTER TABLE patient_photo
  ADD CONSTRAINT pk_patient_photo PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

