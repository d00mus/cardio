PROMPT CREATE TABLE cabinet
CREATE TABLE cabinet (
  id   NUMBER(18,0)  NOT NULL,
  code VARCHAR2(64)  NULL,
  name VARCHAR2(255) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE cabinet IS '��������, � ������� ���������� ���';

COMMENT ON COLUMN cabinet.code IS '���, ����� ��������';
COMMENT ON COLUMN cabinet.name IS '��������';

