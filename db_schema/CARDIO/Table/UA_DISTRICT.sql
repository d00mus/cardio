PROMPT CREATE TABLE ua_district
CREATE TABLE ua_district (
  id       NUMBER(8,0)   NOT NULL,
  state_id NUMBER(8,0)   NOT NULL,
  rus_name VARCHAR2(128) NULL,
  ukr_name VARCHAR2(128) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE ua_district IS '������ �������� �������';

COMMENT ON COLUMN ua_district.state_id IS '������ �� �������';
COMMENT ON COLUMN ua_district.rus_name IS '������� �������� ������';
COMMENT ON COLUMN ua_district.ukr_name IS '���������� �������� ������';

