PROMPT ALTER TABLE store_document ADD CONSTRAINT fk_store_document_partner FOREIGN KEY
ALTER TABLE store_document
  ADD CONSTRAINT fk_store_document_partner FOREIGN KEY (
    partner_id
  ) REFERENCES cardio_partner (
    id
  )
/

PROMPT ALTER TABLE store_document ADD CONSTRAINT fk_store_document_status FOREIGN KEY
ALTER TABLE store_document
  ADD CONSTRAINT fk_store_document_status FOREIGN KEY (
    status_id
  ) REFERENCES document_status (
    id
  )
/

PROMPT ALTER TABLE store_document ADD CONSTRAINT fk_store_document_store FOREIGN KEY
ALTER TABLE store_document
  ADD CONSTRAINT fk_store_document_store FOREIGN KEY (
    store_id
  ) REFERENCES cardio_store (
    id
  )
/

PROMPT ALTER TABLE store_document ADD CONSTRAINT fk_store_document_type FOREIGN KEY
ALTER TABLE store_document
  ADD CONSTRAINT fk_store_document_type FOREIGN KEY (
    type_id
  ) REFERENCES document_type (
    id
  )
/

PROMPT ALTER TABLE store_document ADD CONSTRAINT fk_store_document_user FOREIGN KEY
ALTER TABLE store_document
  ADD CONSTRAINT fk_store_document_user FOREIGN KEY (
    user_id
  ) REFERENCES cardio_user (
    id
  )
/

