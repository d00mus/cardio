PROMPT ALTER TABLE psg_attr_apnoe_type ADD CONSTRAINT pk_psg_attr_apnoe_type PRIMARY KEY
ALTER TABLE psg_attr_apnoe_type
  ADD CONSTRAINT pk_psg_attr_apnoe_type PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

