PROMPT CREATE TABLE cardio_project
CREATE TABLE cardio_project (
  id              NUMBER(18,0)  NOT NULL,
  partner_id      NUMBER(18,0)  NULL,
  status_id       NUMBER(8,0)   NULL,
  user_id         NUMBER(10,0)  NULL,
  name            VARCHAR2(255) NULL,
  notes           VARCHAR2(255) NULL,
  contact_pers_id NUMBER(18,0)  NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE cardio_project IS 'Проекты инженеров';

COMMENT ON COLUMN cardio_project.partner_id IS 'Учреждение';
COMMENT ON COLUMN cardio_project.status_id IS 'Статус';
COMMENT ON COLUMN cardio_project.user_id IS 'Ведущий юзер';
COMMENT ON COLUMN cardio_project.name IS 'Название';
COMMENT ON COLUMN cardio_project.notes IS 'Примечания';
COMMENT ON COLUMN cardio_project.contact_pers_id IS 'Контактная персона, сотрудник Учреждения';

