PROMPT CREATE TABLE partner_event_type
CREATE TABLE partner_event_type (
  id   NUMBER(8,0)   NOT NULL,
  code VARCHAR2(32)  NOT NULL,
  name VARCHAR2(255) NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE partner_event_type IS '���� ������� � ���������';

COMMENT ON COLUMN partner_event_type.code IS '��� ����';
COMMENT ON COLUMN partner_event_type.name IS '�������� ���� �������';

