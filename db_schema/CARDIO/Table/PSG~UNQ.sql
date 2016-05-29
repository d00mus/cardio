PROMPT ALTER TABLE psg ADD CONSTRAINT pk_pgs PRIMARY KEY
ALTER TABLE psg
  ADD CONSTRAINT pk_pgs PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE psg ADD CONSTRAINT unq_psg_no UNIQUE
ALTER TABLE psg
  ADD CONSTRAINT unq_psg_no UNIQUE (
    patient_id,
    psg_no
  )
  DISABLE
  NOVALIDATE
/

