PROMPT CREATE TABLE store_document
CREATE TABLE store_document (
  id          NUMBER(18,0)  NOT NULL,
  store_id    NUMBER(8,0)   NOT NULL,
  type_id     NUMBER(8,0)   NOT NULL,
  status_id   NUMBER(8,0)   NOT NULL,
  user_id     NUMBER(8,0)   NOT NULL,
  post_date   DATE          NULL,
  doc_no      VARCHAR2(128) NULL,
  description VARCHAR2(255) NULL,
  partner_id  NUMBER(18,0)  NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE store_document IS '��������� �������� �� ������';

COMMENT ON COLUMN store_document.store_id IS '�����';
COMMENT ON COLUMN store_document.type_id IS '��� ��������';
COMMENT ON COLUMN store_document.status_id IS '������ ���������, ���� �� ������������';
COMMENT ON COLUMN store_document.user_id IS '������������, ������� ������';
COMMENT ON COLUMN store_document.post_date IS '���� ��������';
COMMENT ON COLUMN store_document.doc_no IS '����� ���������';
COMMENT ON COLUMN store_document.description IS '��������';
COMMENT ON COLUMN store_document.partner_id IS '����������, ������ ��� ��������?';

