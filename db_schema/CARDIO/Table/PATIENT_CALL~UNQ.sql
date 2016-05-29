PROMPT ALTER TABLE patient_call ADD CONSTRAINT pk_patient_call PRIMARY KEY
ALTER TABLE patient_call
  ADD CONSTRAINT pk_patient_call PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

