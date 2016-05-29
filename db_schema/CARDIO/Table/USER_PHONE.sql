PROMPT CREATE TABLE user_phone
CREATE TABLE user_phone (
  id            NUMBER(8,0)   NOT NULL,
  user_id       NUMBER(8,0)   NOT NULL,
  phone         VARCHAR2(32)  NULL,
  phone_type_id NUMBER(8,0)   NULL,
  notes         VARCHAR2(255) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE user_phone IS 'Телефоны сотрудников';

COMMENT ON COLUMN user_phone.user_id IS 'Сотрудник';
COMMENT ON COLUMN user_phone.phone IS 'Телефон';
COMMENT ON COLUMN user_phone.phone_type_id IS 'Тип телефона';
COMMENT ON COLUMN user_phone.notes IS 'Примечание';

