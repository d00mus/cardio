PROMPT ALTER TABLE psg_attr_ecg ADD CONSTRAINT pk_psg_attr_ecg PRIMARY KEY
ALTER TABLE psg_attr_ecg
  ADD CONSTRAINT pk_psg_attr_ecg PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

