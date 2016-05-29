PROMPT CREATE TABLE project_equipment
CREATE TABLE project_equipment (
  id         NUMBER(18,0)  NOT NULL,
  project_id NUMBER(19,0)  NOT NULL,
  model_id   NUMBER(8,0)   NOT NULL,
  amount     NUMBER(10,0)  NULL,
  notes      VARCHAR2(255) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE project_equipment IS 'Оборудование под проект';

COMMENT ON COLUMN project_equipment.project_id IS 'Проект';
COMMENT ON COLUMN project_equipment.model_id IS 'Модель';
COMMENT ON COLUMN project_equipment.amount IS 'Кол-во';
COMMENT ON COLUMN project_equipment.notes IS 'Примечание';

