PROMPT ALTER TABLE psg_attr_ad ADD CONSTRAINT pk_psg_attr_ad PRIMARY KEY
ALTER TABLE psg_attr_ad
  ADD CONSTRAINT pk_psg_attr_ad PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

