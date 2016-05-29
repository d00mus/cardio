PROMPT CREATE TABLE contact_type
CREATE TABLE contact_type (
  id          NUMBER(18,0)   NOT NULL,
  code        VARCHAR2(16)   NOT NULL,
  name        VARCHAR2(64)   NOT NULL,
  description VARCHAR2(128)  NULL,
  regexp      VARCHAR2(2000) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE contact_type IS '���� ���������';

COMMENT ON COLUMN contact_type.code IS '��� ����';
COMMENT ON COLUMN contact_type.name IS '��������';
COMMENT ON COLUMN contact_type.description IS '��������';
COMMENT ON COLUMN contact_type.regexp IS '������� ��� �������� ������������ �������';

