PROMPT ALTER TABLE vip_rank ADD CONSTRAINT pk_vip_rank PRIMARY KEY
ALTER TABLE vip_rank
  ADD CONSTRAINT pk_vip_rank PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE vip_rank ADD CONSTRAINT unq_vip_rank UNIQUE
ALTER TABLE vip_rank
  ADD CONSTRAINT unq_vip_rank UNIQUE (
    code
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

