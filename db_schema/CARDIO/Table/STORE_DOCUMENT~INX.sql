PROMPT CREATE INDEX ifk_store_document_partner
CREATE INDEX ifk_store_document_partner
  ON store_document (
    partner_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_store_document_status
CREATE INDEX ifk_store_document_status
  ON store_document (
    status_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_store_document_store
CREATE INDEX ifk_store_document_store
  ON store_document (
    store_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_store_document_type
CREATE INDEX ifk_store_document_type
  ON store_document (
    type_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

PROMPT CREATE INDEX ifk_store_document_user
CREATE INDEX ifk_store_document_user
  ON store_document (
    user_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

