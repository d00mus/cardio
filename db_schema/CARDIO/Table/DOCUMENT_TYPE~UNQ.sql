PROMPT ALTER TABLE document_type ADD CONSTRAINT pk_document_type PRIMARY KEY
ALTER TABLE document_type
  ADD CONSTRAINT pk_document_type PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

PROMPT ALTER TABLE document_type ADD CONSTRAINT unk_document_type UNIQUE
ALTER TABLE document_type
  ADD CONSTRAINT unk_document_type UNIQUE (
    code
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

