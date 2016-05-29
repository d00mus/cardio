PROMPT ALTER TABLE psg_attr_apnoe ADD CONSTRAINT pk_psg_attr_apnoe PRIMARY KEY
ALTER TABLE psg_attr_apnoe
  ADD CONSTRAINT pk_psg_attr_apnoe PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

