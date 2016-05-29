PROMPT ALTER TABLE psg_attr_toilet_wake ADD CONSTRAINT pk_psg_attr_toilet_wake PRIMARY KEY
ALTER TABLE psg_attr_toilet_wake
  ADD CONSTRAINT pk_psg_attr_toilet_wake PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

