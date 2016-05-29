PROMPT ALTER TABLE document_status ADD CONSTRAINT pk_document_status PRIMARY KEY
ALTER TABLE document_status
  ADD CONSTRAINT pk_document_status PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE document_status ADD CONSTRAINT unq_document_status UNIQUE
ALTER TABLE document_status
  ADD CONSTRAINT unq_document_status UNIQUE (
    code
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

