PROMPT ALTER TABLE doctor_position ADD CONSTRAINT pk_doctor_position PRIMARY KEY
ALTER TABLE doctor_position
  ADD CONSTRAINT pk_doctor_position PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE doctor_position ADD CONSTRAINT unq_doctor_position UNIQUE
ALTER TABLE doctor_position
  ADD CONSTRAINT unq_doctor_position UNIQUE (
    code
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

