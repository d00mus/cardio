PROMPT ALTER TABLE cabinet ADD CONSTRAINT pk_cabinet PRIMARY KEY
ALTER TABLE cabinet
  ADD CONSTRAINT pk_cabinet PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE cabinet ADD CONSTRAINT unq_cabinet UNIQUE
ALTER TABLE cabinet
  ADD CONSTRAINT unq_cabinet UNIQUE (
    code
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

