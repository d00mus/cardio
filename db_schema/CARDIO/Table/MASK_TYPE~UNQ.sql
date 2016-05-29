PROMPT ALTER TABLE mask_type ADD CONSTRAINT pk_mask_type PRIMARY KEY
ALTER TABLE mask_type
  ADD CONSTRAINT pk_mask_type PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

