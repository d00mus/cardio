PROMPT ALTER TABLE doctor_assoc ADD CONSTRAINT pk_doctor_assoc PRIMARY KEY
ALTER TABLE doctor_assoc
  ADD CONSTRAINT pk_doctor_assoc PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE doctor_assoc ADD CONSTRAINT unq_doctor_assoc UNIQUE
ALTER TABLE doctor_assoc
  ADD CONSTRAINT unq_doctor_assoc UNIQUE (
    code
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

