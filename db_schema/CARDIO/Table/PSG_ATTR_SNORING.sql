PROMPT CREATE TABLE psg_attr_snoring
CREATE TABLE psg_attr_snoring (
  id         NUMBER(18,0) NOT NULL,
  psg_id     NUMBER(18,0) NOT NULL,
  psg_level  NUMBER(2,0)  DEFAULT 0 NOT NULL,
  begin_time DATE         NOT NULL,
  end_time   DATE         NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE psg_attr_snoring IS '����������� �����, �� ����� ���';

COMMENT ON COLUMN psg_attr_snoring.id IS 'ID';
COMMENT ON COLUMN psg_attr_snoring.psg_id IS '������ �� ������� ���, � ������ �������� ������ ���� �����';
COMMENT ON COLUMN psg_attr_snoring.psg_level IS '������� ���, 0 - ��� ������, 1- ����. CPAP, 2 - ����� Oxymat';
COMMENT ON COLUMN psg_attr_snoring.begin_time IS '����-����� ������ �����';
COMMENT ON COLUMN psg_attr_snoring.end_time IS '����-����� ��������� �����';

