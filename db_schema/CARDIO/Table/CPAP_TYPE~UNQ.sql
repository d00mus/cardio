PROMPT ALTER TABLE cpap_type ADD CONSTRAINT pk_cpap_type PRIMARY KEY
ALTER TABLE cpap_type
  ADD CONSTRAINT pk_cpap_type PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

