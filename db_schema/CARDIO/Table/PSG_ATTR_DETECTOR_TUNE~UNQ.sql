PROMPT ALTER TABLE psg_attr_detector_tune ADD CONSTRAINT pk_psg_attr_detector_tune PRIMARY KEY
ALTER TABLE psg_attr_detector_tune
  ADD CONSTRAINT pk_psg_attr_detector_tune PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

