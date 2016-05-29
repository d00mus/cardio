PROMPT CREATE TABLE patient_phone
CREATE TABLE patient_phone (
  id           NUMBER(18,0)  NOT NULL,
  patient_id   NUMBER(18,0)  NOT NULL,
  tel_type_id  NUMBER(10,0)  NULL,
  phone_raw    VARCHAR2(32)  NOT NULL,
  notes        VARCHAR2(255) NULL,
  country_code VARCHAR2(4)   NULL,
  level1_code  VARCHAR2(8)   NULL,
  level2_code  VARCHAR2(8)   NULL,
  phone_number VARCHAR2(16)  NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE patient_phone IS 'Телефоны пациентов';

COMMENT ON COLUMN patient_phone.patient_id IS 'Пациент';
COMMENT ON COLUMN patient_phone.tel_type_id IS 'Тип телефона';
COMMENT ON COLUMN patient_phone.phone_raw IS 'Полный номер телефона, без пробелов, дифисов и прочего, только цифры и знак +';
COMMENT ON COLUMN patient_phone.notes IS 'Заметки';
COMMENT ON COLUMN patient_phone.country_code IS 'Код страны';
COMMENT ON COLUMN patient_phone.level1_code IS 'Код оператора(области)';
COMMENT ON COLUMN patient_phone.level2_code IS 'Код города';
COMMENT ON COLUMN patient_phone.phone_number IS 'Номер телефона';

