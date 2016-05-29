PROMPT ALTER TABLE psg_result_author ADD CONSTRAINT pk_psg_result_author PRIMARY KEY
ALTER TABLE psg_result_author
  ADD CONSTRAINT pk_psg_result_author PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

