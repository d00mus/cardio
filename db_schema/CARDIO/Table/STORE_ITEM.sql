PROMPT CREATE TABLE store_item
CREATE TABLE store_item (
  id           NUMBER(18,0)  NOT NULL,
  store_id     NUMBER(8,0)   NOT NULL,
  model_id     NUMBER(8,0)   NOT NULL,
  serial       VARCHAR2(128) NULL,
  status_id    NUMBER(8,0)   NOT NULL,
  deliver_date DATE          NULL,
  expense_date DATE          NULL,
  return_date  DATE          NULL,
  partner_id   NUMBER(18,0)  NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE store_item IS 'Содержимое склада, прошлое и настоящее';

COMMENT ON COLUMN store_item.store_id IS 'Склад';
COMMENT ON COLUMN store_item.model_id IS 'Модель';
COMMENT ON COLUMN store_item.serial IS 'Серийник';
COMMENT ON COLUMN store_item.status_id IS 'Статус';
COMMENT ON COLUMN store_item.deliver_date IS 'Дата прихода';
COMMENT ON COLUMN store_item.expense_date IS 'Дата расхода';
COMMENT ON COLUMN store_item.return_date IS 'Дата возврата';
COMMENT ON COLUMN store_item.partner_id IS 'Партнёр, у которого находится';

