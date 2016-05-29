PROMPT CREATE TABLE partner_event
CREATE TABLE partner_event (
  id          NUMBER(18,0)   NOT NULL,
  partner_id  NUMBER(18,0)   NOT NULL,
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

COMMENT ON TABLE partner_event IS 'События, партнёров';

COMMENT ON COLUMN partner_event.partner_id IS 'Партнёр, к которому относится данное событие';
COMMENT ON COLUMN partner_event.user_id IS 'Юзер, который событие создал';
COMMENT ON COLUMN partner_event.event_date IS 'Дата события';
COMMENT ON COLUMN partner_event.create_date IS 'Дата создания события';
COMMENT ON COLUMN partner_event.label IS 'Метка, краткая тема';
COMMENT ON COLUMN partner_event.type_id IS 'Тип события';
COMMENT ON COLUMN partner_event.subj_id IS 'Предмет события';
COMMENT ON COLUMN partner_event.employe_id IS 'Сотрудник, связанный с данным событием';

