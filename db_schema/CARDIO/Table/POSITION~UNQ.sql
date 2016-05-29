PROMPT ALTER TABLE position ADD CONSTRAINT pk_position PRIMARY KEY
ALTER TABLE position
  ADD CONSTRAINT pk_position PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE position ADD CONSTRAINT unq_position UNIQUE
ALTER TABLE position
  ADD CONSTRAINT unq_position UNIQUE (
    code
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

