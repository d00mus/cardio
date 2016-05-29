PROMPT ALTER TABLE ref_info_source_type ADD CONSTRAINT pk_ref_info_source_type PRIMARY KEY
ALTER TABLE ref_info_source_type
  ADD CONSTRAINT pk_ref_info_source_type PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE ref_info_source_type ADD CONSTRAINT unq_ref_info_source_type UNIQUE
ALTER TABLE ref_info_source_type
  ADD CONSTRAINT unq_ref_info_source_type UNIQUE (
    code
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

