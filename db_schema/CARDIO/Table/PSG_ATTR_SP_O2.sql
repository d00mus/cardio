PROMPT CREATE TABLE psg_attr_sp_o2
CREATE TABLE psg_attr_sp_o2 (
  id             NUMBER(18,0) NOT NULL,
  psg_id         NUMBER(18,0) NOT NULL,
  measuring_time DATE         NOT NULL,
  psg_level      NUMBER(2,0)  NULL,
  sp_o2_min      NUMBER(5,2)  NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE psg_attr_sp_o2 IS '������ SpO2 � ������� ���';

COMMENT ON COLUMN psg_attr_sp_o2.id IS 'ID';
COMMENT ON COLUMN psg_attr_sp_o2.psg_id IS '������ �� ������ ���, � ������� ��� �����';
COMMENT ON COLUMN psg_attr_sp_o2.measuring_time IS '����-����� ���������';
COMMENT ON COLUMN psg_attr_sp_o2.psg_level IS '������� ���, 0 - ��� ������, 1-����� CPAP, 2-���������� Oxymat';
COMMENT ON COLUMN psg_attr_sp_o2.sp_o2_min IS '����������� ��������, � %';

