PROMPT CREATE TABLE division
CREATE TABLE division (
  id      NUMBER(18,0)  NOT NULL,
  code    VARCHAR2(16)  NULL,
  name    VARCHAR2(64)  NULL,
  address VARCHAR2(128) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE division IS '���������, �������� �������';

COMMENT ON COLUMN division.code IS '��� ���������';
COMMENT ON COLUMN division.name IS '��������';
COMMENT ON COLUMN division.address IS '�����';

