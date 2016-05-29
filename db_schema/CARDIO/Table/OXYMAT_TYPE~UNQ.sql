PROMPT ALTER TABLE oxymat_type ADD CONSTRAINT pk_oxymat_type PRIMARY KEY
ALTER TABLE oxymat_type
  ADD CONSTRAINT pk_oxymat_type PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

