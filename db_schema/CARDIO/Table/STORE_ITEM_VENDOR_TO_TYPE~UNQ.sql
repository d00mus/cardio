PROMPT ALTER TABLE store_item_vendor_to_type ADD CONSTRAINT pk_store_item_vendor_to_type PRIMARY KEY
ALTER TABLE store_item_vendor_to_type
  ADD CONSTRAINT pk_store_item_vendor_to_type PRIMARY KEY (
    store_item_vendor_id,
    store_item_type_id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

