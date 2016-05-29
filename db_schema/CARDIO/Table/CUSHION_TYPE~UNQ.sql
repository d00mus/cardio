PROMPT ALTER TABLE cushion_type ADD CONSTRAINT pk_cushion_type PRIMARY KEY
ALTER TABLE cushion_type
  ADD CONSTRAINT pk_cushion_type PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

