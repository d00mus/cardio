PROMPT CREATE TABLE psg_attr_ad
CREATE TABLE psg_attr_ad (
  id              NUMBER(18,0) NOT NULL,
  psg_id          NUMBER(18,0) NOT NULL,
  measuring_time  DATE         NOT NULL,
  psg_level       NUMBER(2,0)  DEFAULT 0 NOT NULL,
  systol_pressue  NUMBER(3,0)  NOT NULL,
  diastol_pressue NUMBER(3,0)  NOT NULL,
  hand            CHAR(1)      NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE psg_attr_ad IS '������ ������������� �������� �� ����� ���';

COMMENT ON COLUMN psg_attr_ad.id IS 'ID';
COMMENT ON COLUMN psg_attr_ad.psg_id IS '������ �� ������� ���, � ������ �������� ������ ���� �����';
COMMENT ON COLUMN psg_attr_ad.measuring_time IS '����-����� ������';
COMMENT ON COLUMN psg_attr_ad.psg_level IS '������� ���, 0 - ��� ������, 1- ����. CPAP, 2 - ����� Oxymat';
COMMENT ON COLUMN psg_attr_ad.systol_pressue IS '������������� ��������';
COMMENT ON COLUMN psg_attr_ad.diastol_pressue IS '�������������� ��������';
COMMENT ON COLUMN psg_attr_ad.hand IS '�� ����� ���� ������, R-������, L - �����';

