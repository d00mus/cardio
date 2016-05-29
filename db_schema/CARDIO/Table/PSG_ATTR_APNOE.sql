PROMPT CREATE TABLE psg_attr_apnoe
CREATE TABLE psg_attr_apnoe (
  id            NUMBER(18,0) NOT NULL,
  psg_id        NUMBER(18,0) NOT NULL,
  begin_time    DATE         NOT NULL,
  duration_sec  NUMBER(4,0)  NOT NULL,
  apnoe_type_id NUMBER(8,0)  NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE psg_attr_apnoe IS '������ �����/���������� �� ����� ���';

COMMENT ON COLUMN psg_attr_apnoe.id IS 'ID';
COMMENT ON COLUMN psg_attr_apnoe.psg_id IS '������ �� ������� ���, � ������ �������� ������ ���� �����';
COMMENT ON COLUMN psg_attr_apnoe.begin_time IS '����-����� ������ �������� ������';
COMMENT ON COLUMN psg_attr_apnoe.duration_sec IS '������������, �������';
COMMENT ON COLUMN psg_attr_apnoe.apnoe_type_id IS '��� �����';

