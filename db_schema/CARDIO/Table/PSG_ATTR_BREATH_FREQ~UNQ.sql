PROMPT ALTER TABLE psg_attr_breath_freq ADD CONSTRAINT pk_psg_attr_breath_freq PRIMARY KEY
ALTER TABLE psg_attr_breath_freq
  ADD CONSTRAINT pk_psg_attr_breath_freq PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

