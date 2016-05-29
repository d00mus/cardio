PROMPT ALTER TABLE doctor_division ADD CONSTRAINT pk_doctor_division PRIMARY KEY
ALTER TABLE doctor_division
  ADD CONSTRAINT pk_doctor_division PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE doctor_division ADD CONSTRAINT unq_pk_doctor_division UNIQUE
ALTER TABLE doctor_division
  ADD CONSTRAINT unq_pk_doctor_division UNIQUE (
    code
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

