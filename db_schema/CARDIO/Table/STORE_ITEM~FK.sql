PROMPT ALTER TABLE store_item ADD CONSTRAINT fk_store_item_model FOREIGN KEY
ALTER TABLE store_item
  ADD CONSTRAINT fk_store_item_model FOREIGN KEY (
    model_id
  ) REFERENCES store_item_model (
    id
  )
/

PROMPT ALTER TABLE store_item ADD CONSTRAINT fk_store_item_partner FOREIGN KEY
ALTER TABLE store_item
  ADD CONSTRAINT fk_store_item_partner FOREIGN KEY (
    partner_id
  ) REFERENCES cardio_partner (
    id
  )
/

PROMPT ALTER TABLE store_item ADD CONSTRAINT fk_store_item_status FOREIGN KEY
ALTER TABLE store_item
  ADD CONSTRAINT fk_store_item_status FOREIGN KEY (
    status_id
  ) REFERENCES store_item_status (
    id
  )
/

PROMPT ALTER TABLE store_item ADD CONSTRAINT fk_store_item_store FOREIGN KEY
ALTER TABLE store_item
  ADD CONSTRAINT fk_store_item_store FOREIGN KEY (
    store_id
  ) REFERENCES cardio_store (
    id
  )
/

