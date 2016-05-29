PROMPT CREATE TABLE tel_type
CREATE TABLE tel_type (
  id           NUMBER(10,0)   NOT NULL,
  type_code    VARCHAR2(32)   NOT NULL,
  type_name    VARCHAR2(255)  NOT NULL,
  is_mobile    CHAR(1)        DEFAULT 'T' NOT NULL,
  is_personal  CHAR(1)        DEFAULT 'T' NOT NULL,
  is_work      CHAR(1)        DEFAULT 'F' NOT NULL,
  is_fax       CHAR(1)        DEFAULT 'F' NOT NULL,
  is_ua        CHAR(1)        DEFAULT 'T' NOT NULL,
  regexp       VARCHAR2(2000) NULL,
  format_notes VARCHAR2(2000) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE tel_type IS '��� ��������';

COMMENT ON COLUMN tel_type.type_code IS '��� ����';
COMMENT ON COLUMN tel_type.type_name IS '�������� ����';
COMMENT ON COLUMN tel_type.is_mobile IS '���������? T - ���������, F - ������������';
COMMENT ON COLUMN tel_type.is_personal IS '������? T - �����������/����� ����(���/��) ���(�/��), F - �� ����������� ������� ����, �������� ������� ����';
COMMENT ON COLUMN tel_type.is_work IS '�������? T - ������� �������, ��� ������� ����, F - ������� �� �������';
COMMENT ON COLUMN tel_type.is_fax IS '����? T - �� ���� ����� ����� ����� �����, F ����� ����� - ������';
COMMENT ON COLUMN tel_type.is_ua IS '����������? T - ����� ����������, F - ����������';
COMMENT ON COLUMN tel_type.regexp IS '���������� ��������� ��� ��������';
COMMENT ON COLUMN tel_type.format_notes IS '��������� ��� ������ �� �������� �������';

