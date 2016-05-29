PROMPT ALTER TABLE patient_feeling ADD CONSTRAINT pk_patient_feeling PRIMARY KEY
ALTER TABLE patient_feeling
  ADD CONSTRAINT pk_patient_feeling PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

