PROMPT CREATE TABLE psg_attr_ecg
CREATE TABLE psg_attr_ecg (
  id             NUMBER(18,0)  NOT NULL,
  psg_id         NUMBER(18,0)  NOT NULL,
  measuring_time DATE          NOT NULL,
  psg_level      NUMBER(2,0)   DEFAULT 0 NOT NULL,
  notes          VARCHAR2(255) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE psg_attr_ecg IS '������ ������������� �������� �� ����� ���';

COMMENT ON COLUMN psg_attr_ecg.id IS 'ID';
COMMENT ON COLUMN psg_attr_ecg.psg_id IS '������ �� ������� ���, � ������ �������� ������ ���� �����';
COMMENT ON COLUMN psg_attr_ecg.measuring_time IS '����-����� ������';
COMMENT ON COLUMN psg_attr_ecg.psg_level IS '������� ���, 0 - ��� ������, 1- ����. CPAP, 2 - ����� Oxymat';
COMMENT ON COLUMN psg_attr_ecg.notes IS '����������';

