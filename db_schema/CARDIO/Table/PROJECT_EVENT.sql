PROMPT CREATE TABLE project_event
CREATE TABLE project_event (
  id          NUMBER(18,0)   NOT NULL,
  project_id  NUMBER(18,0)   NOT NULL,
  user_id     NUMBER(10,0)   NOT NULL,
  event_date  DATE           NOT NULL,
  create_date DATE           NOT NULL,
  label       VARCHAR2(2000) NULL,
  type_id     NUMBER(8,0)    NOT NULL,
  subj_id     NUMBER(8,0)    NOT NULL,
  employe_id  NUMBER(18,0)   NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE project_event IS 'События по проекту';

COMMENT ON COLUMN project_event.project_id IS 'Проект, к которому относится данное событие';
COMMENT ON COLUMN project_event.user_id IS 'Юзер, который событие создал';
COMMENT ON COLUMN project_event.event_date IS 'Дата события';
COMMENT ON COLUMN project_event.create_date IS 'Дата создания события';
COMMENT ON COLUMN project_event.label IS 'Метка, краткая тема';
COMMENT ON COLUMN project_event.type_id IS 'Тип события';
COMMENT ON COLUMN project_event.subj_id IS 'Предмет события';
COMMENT ON COLUMN project_event.employe_id IS 'Сотрудник, связанный с данным событием';

