PROMPT ALTER TABLE patient ADD CONSTRAINT ck_pat_sex CHECK
ALTER TABLE patient
  ADD CONSTRAINT ck_pat_sex CHECK (
    sex in ('M','F')
  )
/

