PROMPT CREATE TABLE store_item_model
CREATE TABLE store_item_model (
  id        NUMBER(8,0)   NOT NULL,
  code      VARCHAR2(128) NOT NULL,
  name      VARCHAR2(255) NOT NULL,
  vendor_id NUMBER(8,0)   NOT NULL,
  type_id   NUMBER(8,0)   NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE store_item_model IS 'Модели товаров склада';

COMMENT ON COLUMN store_item_model.vendor_id IS 'Изготовитель';
COMMENT ON COLUMN store_item_model.type_id IS 'Тип товара';

