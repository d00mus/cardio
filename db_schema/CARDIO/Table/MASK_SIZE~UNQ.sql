PROMPT ALTER TABLE mask_size ADD CONSTRAINT pk_mask_size PRIMARY KEY
ALTER TABLE mask_size
  ADD CONSTRAINT pk_mask_size PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

