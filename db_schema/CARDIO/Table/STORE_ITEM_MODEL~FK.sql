PROMPT ALTER TABLE store_item_model ADD CONSTRAINT fk_store_item_model_type_id FOREIGN KEY
ALTER TABLE store_item_model
  ADD CONSTRAINT fk_store_item_model_type_id FOREIGN KEY (
    type_id
  ) REFERENCES store_item_type (
    id
  )
/

PROMPT ALTER TABLE store_item_model ADD CONSTRAINT fk_store_item_model_vendor_id FOREIGN KEY
ALTER TABLE store_item_model
  ADD CONSTRAINT fk_store_item_model_vendor_id FOREIGN KEY (
    vendor_id
  ) REFERENCES store_item_vendor (
    id
  )
/

