PROMPT ALTER TABLE ex_doc_type ADD CONSTRAINT pk_ex_doc_type PRIMARY KEY
ALTER TABLE ex_doc_type
  ADD CONSTRAINT pk_ex_doc_type PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE ex_doc_type ADD CONSTRAINT unq_ex_doc_type UNIQUE
ALTER TABLE ex_doc_type
  ADD CONSTRAINT unq_ex_doc_type UNIQUE (
    code
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

