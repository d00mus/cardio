PROMPT CREATE TABLE patient_photo
CREATE TABLE patient_photo (
  id          NUMBER(18,0)   NOT NULL,
  patient_id  NUMBER(18,0)   NOT NULL,
  file_name   VARCHAR2(255)  NULL,
  description VARCHAR2(2000) NULL,
  photo_date  DATE           NULL,
  upload_date DATE           DEFAULT sysdate NOT NULL,
  file_data   BLOB           NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE patient_photo IS '���������� ��������, ���������';

COMMENT ON COLUMN patient_photo.patient_id IS '������ �� ��������, ��� �����';
COMMENT ON COLUMN patient_photo.file_name IS '��� ����� � ������';
COMMENT ON COLUMN patient_photo.description IS '�������� �����';
COMMENT ON COLUMN patient_photo.photo_date IS '����, ����� ���� ������� ����';
COMMENT ON COLUMN patient_photo.upload_date IS '���� ��������';
COMMENT ON COLUMN patient_photo.file_data IS '���������� �����';

