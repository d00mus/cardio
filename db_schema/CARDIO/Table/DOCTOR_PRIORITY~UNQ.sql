PROMPT ALTER TABLE doctor_priority ADD CONSTRAINT pk_doctor_priority PRIMARY KEY
ALTER TABLE doctor_priority
  ADD CONSTRAINT pk_doctor_priority PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE doctor_priority ADD CONSTRAINT unq_doctor_priority UNIQUE
ALTER TABLE doctor_priority
  ADD CONSTRAINT unq_doctor_priority UNIQUE (
    code
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

