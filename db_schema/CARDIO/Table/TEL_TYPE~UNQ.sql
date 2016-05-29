PROMPT ALTER TABLE tel_type ADD CONSTRAINT pk_tel_type PRIMARY KEY
ALTER TABLE tel_type
  ADD CONSTRAINT pk_tel_type PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE tel_type ADD CONSTRAINT unq_tel_type_type_code UNIQUE
ALTER TABLE tel_type
  ADD CONSTRAINT unq_tel_type_type_code UNIQUE (
    type_code
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

