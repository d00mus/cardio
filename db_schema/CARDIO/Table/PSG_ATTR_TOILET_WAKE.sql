PROMPT CREATE TABLE psg_attr_toilet_wake
CREATE TABLE psg_attr_toilet_wake (
  id             NUMBER(18,0) NOT NULL,
  psg_id         NUMBER(18,0) NOT NULL,
  measuring_time DATE         NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE psg_attr_toilet_wake IS '������ �������� � ������ �� ����� ���';

COMMENT ON COLUMN psg_attr_toilet_wake.id IS 'ID';
COMMENT ON COLUMN psg_attr_toilet_wake.psg_id IS '������ �� ������� ���, � ������ �������� ������ ���� �����';
COMMENT ON COLUMN psg_attr_toilet_wake.measuring_time IS '����-����� ������';

