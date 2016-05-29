PROMPT ALTER TABLE division ADD CONSTRAINT pk_division PRIMARY KEY
ALTER TABLE division
  ADD CONSTRAINT pk_division PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

