PROMPT ALTER TABLE store_item_vendor_to_type ADD CONSTRAINT fk_stiv_to_type_type_id FOREIGN KEY
ALTER TABLE store_item_vendor_to_type
  ADD CONSTRAINT fk_stiv_to_type_type_id FOREIGN KEY (
    store_item_type_id
  ) REFERENCES store_item_type (
    id
  )
/

PROMPT ALTER TABLE store_item_vendor_to_type ADD CONSTRAINT fk_stiv_to_type_vendor_id FOREIGN KEY
ALTER TABLE store_item_vendor_to_type
  ADD CONSTRAINT fk_stiv_to_type_vendor_id FOREIGN KEY (
    store_item_vendor_id
  ) REFERENCES store_item_vendor (
    id
  )
/

