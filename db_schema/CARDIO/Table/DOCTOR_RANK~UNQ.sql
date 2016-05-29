PROMPT ALTER TABLE doctor_rank ADD CONSTRAINT pk_doctor_rank PRIMARY KEY
ALTER TABLE doctor_rank
  ADD CONSTRAINT pk_doctor_rank PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE doctor_rank ADD CONSTRAINT unq_doctor_rank UNIQUE
ALTER TABLE doctor_rank
  ADD CONSTRAINT unq_doctor_rank UNIQUE (
    code
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

