PROMPT ALTER TABLE doctors_external ADD CONSTRAINT pk_doctors_internal PRIMARY KEY
ALTER TABLE doctors_external
  ADD CONSTRAINT pk_doctors_internal PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

