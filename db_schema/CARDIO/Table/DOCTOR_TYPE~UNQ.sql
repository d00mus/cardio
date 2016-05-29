PROMPT ALTER TABLE doctor_type ADD CONSTRAINT pk_doctor_type PRIMARY KEY
ALTER TABLE doctor_type
  ADD CONSTRAINT pk_doctor_type PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE doctor_type ADD CONSTRAINT unq_pk_doctor_type UNIQUE
ALTER TABLE doctor_type
  ADD CONSTRAINT unq_pk_doctor_type UNIQUE (
    code
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

