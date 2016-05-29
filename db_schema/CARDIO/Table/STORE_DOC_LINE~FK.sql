PROMPT ALTER TABLE store_doc_line ADD CONSTRAINT fk_store_doc_line_doc FOREIGN KEY
ALTER TABLE store_doc_line
  ADD CONSTRAINT fk_store_doc_line_doc FOREIGN KEY (
    document_id
  ) REFERENCES store_document (
    id
  ) ON DELETE CASCADE
/

PROMPT ALTER TABLE store_doc_line ADD CONSTRAINT fk_store_doc_line_item FOREIGN KEY
ALTER TABLE store_doc_line
  ADD CONSTRAINT fk_store_doc_line_item FOREIGN KEY (
    item_id
  ) REFERENCES store_item (
    id
  )
/

