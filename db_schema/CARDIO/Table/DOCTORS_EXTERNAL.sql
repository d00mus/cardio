PROMPT CREATE TABLE doctors_external
CREATE TABLE doctors_external (
  id           NUMBER(18,0)  NOT NULL,
  fio          VARCHAR2(128) NOT NULL,
  contacts_id  NUMBER(18,0)  NULL,
  birth_date   DATE          NOT NULL,
  send_rank_id NUMBER(18,0)  NULL,
  doc_type_id  NUMBER(18,0)  NULL,
  ua_town_id   NUMBER(8,0)   NULL,
  ua_state_id  NUMBER(8,0)   NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE doctors_external IS 'Внешние доктора, для откатов';

COMMENT ON COLUMN doctors_external.fio IS 'Фио доктора';
COMMENT ON COLUMN doctors_external.contacts_id IS 'Контакты доктора';
COMMENT ON COLUMN doctors_external.birth_date IS 'Дата рождения';
COMMENT ON COLUMN doctors_external.send_rank_id IS 'Ссылочный ранг(сколько народу он прислал)';
COMMENT ON COLUMN doctors_external.doc_type_id IS 'Тип доктора(специализация)';
COMMENT ON COLUMN doctors_external.ua_town_id IS 'Украинский город';
COMMENT ON COLUMN doctors_external.ua_state_id IS 'Украинская область';

