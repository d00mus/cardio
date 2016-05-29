PROMPT ALTER TABLE psg_attr_detector ADD CONSTRAINT pk_psg_attr_detector PRIMARY KEY
ALTER TABLE psg_attr_detector
  ADD CONSTRAINT pk_psg_attr_detector PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE psg_attr_detector ADD CONSTRAINT unq_psg_attr_detector UNIQUE
ALTER TABLE psg_attr_detector
  ADD CONSTRAINT unq_psg_attr_detector UNIQUE (
    code
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

