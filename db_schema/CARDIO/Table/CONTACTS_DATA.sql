PROMPT CREATE TABLE contacts_data
CREATE TABLE contacts_data (
  id          NUMBER(18,0)   NOT NULL,
  contacts_id NUMBER(18,0)   NULL,
  type_id     NUMBER(18,0)   NULL,
  contact     VARCHAR2(2000) NULL,
  name        VARCHAR2(255)  NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE contacts_data IS 'Контакты, данные';

COMMENT ON COLUMN contacts_data.contacts_id IS 'Ссылка на контакт';
COMMENT ON COLUMN contacts_data.type_id IS 'Тип контакта';
COMMENT ON COLUMN contacts_data.contact IS 'Содержимое контакта';
COMMENT ON COLUMN contacts_data.name IS 'Имя контакта';

