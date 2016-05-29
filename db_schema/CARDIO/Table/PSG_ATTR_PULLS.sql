PROMPT CREATE TABLE psg_attr_pulls
CREATE TABLE psg_attr_pulls (
  id             NUMBER(18,0) NOT NULL,
  psg_id         NUMBER(18,0) NOT NULL,
  measuring_time DATE         NOT NULL,
  psg_level      NUMBER(2,0)  DEFAULT 0 NOT NULL,
  hits_per_min   NUMBER(5,0)  DEFAULT 60 NOT NULL,
  hand           CHAR(1)      NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE psg_attr_pulls IS '������ ������ �� ����� ���������� ���';

COMMENT ON COLUMN psg_attr_pulls.id IS 'ID';
COMMENT ON COLUMN psg_attr_pulls.psg_id IS '������ �� ������� ���, � ������ �������� ������ ���� �����';
COMMENT ON COLUMN psg_attr_pulls.measuring_time IS '����-����� ������';
COMMENT ON COLUMN psg_attr_pulls.psg_level IS '������� ���, 0 - ��� ������, 1- ����. CPAP, 2 - ����� Oxymat';
COMMENT ON COLUMN psg_attr_pulls.hits_per_min IS '�����, ������ � ������';
COMMENT ON COLUMN psg_attr_pulls.hand IS '�� ����� ���� ������, R-������, L - �����';

