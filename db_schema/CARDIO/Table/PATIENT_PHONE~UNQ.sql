PROMPT ALTER TABLE patient_phone ADD CONSTRAINT pk_patient_phone PRIMARY KEY
ALTER TABLE patient_phone
  ADD CONSTRAINT pk_patient_phone PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE patient_phone ADD CONSTRAINT unq_patient_phone UNIQUE
ALTER TABLE patient_phone
  ADD CONSTRAINT unq_patient_phone UNIQUE (
    patient_id,
    phone_raw
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

