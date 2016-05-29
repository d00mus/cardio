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

COMMENT ON TABLE store_item IS '���������� ������, ������� � ���������';

COMMENT ON COLUMN store_item.store_id IS '�����';
COMMENT ON COLUMN store_item.model_id IS '������';
COMMENT ON COLUMN store_item.serial IS '��������';
COMMENT ON COLUMN store_item.status_id IS '������';
COMMENT ON COLUMN store_item.deliver_date IS '���� �������';
COMMENT ON COLUMN store_item.expense_date IS '���� �������';
COMMENT ON COLUMN store_item.return_date IS '���� ��������';
COMMENT ON COLUMN store_item.partner_id IS '������, � �������� ���������';

