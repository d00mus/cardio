PROMPT ALTER TABLE send_rank ADD CONSTRAINT pk_send_rank PRIMARY KEY
ALTER TABLE send_rank
  ADD CONSTRAINT pk_send_rank PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE send_rank ADD CONSTRAINT unq_send_rank_code UNIQUE
ALTER TABLE send_rank
  ADD CONSTRAINT unq_send_rank_code UNIQUE (
    code
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE send_rank ADD CONSTRAINT unq_send_rank_name UNIQUE
ALTER TABLE send_rank
  ADD CONSTRAINT unq_send_rank_name UNIQUE (
    name
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

