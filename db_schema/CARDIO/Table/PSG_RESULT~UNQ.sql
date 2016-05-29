PROMPT ALTER TABLE psg_result ADD CONSTRAINT pk_psg_result PRIMARY KEY
ALTER TABLE psg_result
  ADD CONSTRAINT pk_psg_result PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE psg_result ADD CONSTRAINT ifk_psg_result_psg UNIQUE
ALTER TABLE psg_result
  ADD CONSTRAINT ifk_psg_result_psg UNIQUE (
    psg_id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

