PROMPT ALTER TABLE psg_attr_pulls ADD CONSTRAINT pk_psg_attr_pulls PRIMARY KEY
ALTER TABLE psg_attr_pulls
  ADD CONSTRAINT pk_psg_attr_pulls PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

