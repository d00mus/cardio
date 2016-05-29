PROMPT CREATE TABLE ua_town
CREATE TABLE ua_town (
  id          NUMBER(8,0)   NOT NULL,
  district_id NUMBER(8,0)   NOT NULL,
  state_id    NUMBER(8,0)   NOT NULL,
  rus_name    VARCHAR2(128) NOT NULL,
  ukr_name    VARCHAR2(128) NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE ua_town IS '������ �������';

COMMENT ON COLUMN ua_town.district_id IS '������ �� �������';
COMMENT ON COLUMN ua_town.state_id IS '������ �� �����';
COMMENT ON COLUMN ua_town.rus_name IS '������� �������� ������';
COMMENT ON COLUMN ua_town.ukr_name IS '���������� �������� ������';

