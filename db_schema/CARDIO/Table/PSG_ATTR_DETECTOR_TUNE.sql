PROMPT CREATE TABLE psg_attr_detector_tune
CREATE TABLE psg_attr_detector_tune (
  id             NUMBER(18,0) NOT NULL,
  psg_id         NUMBER(18,0) NOT NULL,
  measuring_time DATE         NOT NULL,
  detector_id    NUMBER(8,0)  DEFAULT null NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE psg_attr_detector_tune IS '����� ����������� �������� �� ����� ���';

COMMENT ON COLUMN psg_attr_detector_tune.id IS 'ID';
COMMENT ON COLUMN psg_attr_detector_tune.psg_id IS '������ �� ������� ���, � ������ �������� ������ ���� �����';
COMMENT ON COLUMN psg_attr_detector_tune.measuring_time IS '����-����� �����������';
COMMENT ON COLUMN psg_attr_detector_tune.detector_id IS '���� �������, ������� ���������';

