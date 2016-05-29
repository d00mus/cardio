PROMPT CREATE TABLE task_equipment
CREATE TABLE task_equipment (
  id       NUMBER(18,0)  NOT NULL,
  task_id  NUMBER(19,0)  NOT NULL,
  model_id NUMBER(8,0)   NOT NULL,
  amount   NUMBER(10,0)  NULL,
  notes    VARCHAR2(255) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE task_equipment IS '������������ ��� ������';

COMMENT ON COLUMN task_equipment.task_id IS '������';
COMMENT ON COLUMN task_equipment.model_id IS '������';
COMMENT ON COLUMN task_equipment.amount IS '���-��';
COMMENT ON COLUMN task_equipment.notes IS '����������';

