PROMPT ALTER TABLE psg_attr_snoring ADD CONSTRAINT pk_psg_attr_snoring PRIMARY KEY
ALTER TABLE psg_attr_snoring
  ADD CONSTRAINT pk_psg_attr_snoring PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

