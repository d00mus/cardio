PROMPT CREATE TABLE patient_document
CREATE TABLE patient_document (
  id          NUMBER(18,0)  NOT NULL,
  patient_id  NUMBER(18,0)  NOT NULL,
  file_name   VARCHAR2(255) NOT NULL,
  file_date   DATE          NULL,
  file_size   NUMBER(8,0)   NULL,
  upload_date DATE          DEFAULT sysdate NOT NULL,
  description VARCHAR2(255) NULL,
  file_data   BLOB          NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE patient_document IS '���������, ��������� � ����������';

COMMENT ON COLUMN patient_document.patient_id IS '�������';
COMMENT ON COLUMN patient_document.file_name IS '��� �����';
COMMENT ON COLUMN patient_document.file_date IS '���� �����';
COMMENT ON COLUMN patient_document.file_size IS '������ �����';
COMMENT ON COLUMN patient_document.upload_date IS '���� �������� �����';
COMMENT ON COLUMN patient_document.description IS '��������';
COMMENT ON COLUMN patient_document.file_data IS '������ �����';

