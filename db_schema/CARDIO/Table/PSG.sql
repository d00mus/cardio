PROMPT CREATE TABLE psg
CREATE TABLE psg (
  id                    NUMBER(18,0)   NOT NULL,
  patient_id            NUMBER(18,0)   NOT NULL,
  nurse_id              NUMBER(18,0)   NULL,
  psg_date              DATE           DEFAULT trunc(sysdate) NOT NULL,
  cabinet_id            NUMBER(18,0)   NULL,
  current_weigth        NUMBER(6,2)    NOT NULL,
  current_height        NUMBER(6,2)    NOT NULL,
  is_done               CHAR(1)        DEFAULT 'F' NOT NULL,
  notes                 VARCHAR2(2000) NULL,
  detector_on_time      DATE           NULL,
  light_off_time        DATE           NULL,
  go_to_sleep_time      DATE           NULL,
  wake_up_time          DATE           NULL,
  total_sleep_time_hour NUMBER(6,2)    NULL,
  cpap_begin_time       DATE           NULL,
  oxymat_begin_time     DATE           NULL,
  cpap_type_id          NUMBER(18,0)   NULL,
  cpap_serial           VARCHAR2(32)   NULL,
  cpap_mask_type_id     NUMBER(18,0)   NULL,
  oxymat_mask_type_id   NUMBER(18,0)   NULL,
  cushion_type_id       NUMBER(18,0)   NULL,
  cpap_mask_size_id     NUMBER(10,0)   NULL,
  oxymat_mask_size_id   NUMBER(10,0)   NULL,
  oxymat_type_id        NUMBER(10,0)   NULL,
  psg_no                NUMBER(5,0)    DEFAULT null NOT NULL,
  is_smooth_start       CHAR(1)        NULL,
  smooth_start_duration NUMBER(4,0)    NULL,
  breath_humidity       NUMBER(4,0)    NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE psg IS '���(�������)';

COMMENT ON COLUMN psg.id IS 'ID';
COMMENT ON COLUMN psg.patient_id IS '�������';
COMMENT ON COLUMN psg.nurse_id IS '���������(����)';
COMMENT ON COLUMN psg.psg_date IS '���� ������ ���������� ���';
COMMENT ON COLUMN psg.cabinet_id IS '�������, � ������� ���� ����������';
COMMENT ON COLUMN psg.current_weigth IS '������� ��� ��������, ��';
COMMENT ON COLUMN psg.current_height IS '������� ���� ��������, ��';
COMMENT ON COLUMN psg.is_done IS '����� ��� ��������';
COMMENT ON COLUMN psg.notes IS '�������';
COMMENT ON COLUMN psg.detector_on_time IS '����� ����������� ��������';
COMMENT ON COLUMN psg.light_off_time IS '����� ���������� ����� � ������';
COMMENT ON COLUMN psg.go_to_sleep_time IS '����� ��������� ��������';
COMMENT ON COLUMN psg.wake_up_time IS '����� ����������� �������';
COMMENT ON COLUMN psg.total_sleep_time_hour IS '����� ����� ��� �������, ����';
COMMENT ON COLUMN psg.cpap_begin_time IS '����-����� ����������� CPAP';
COMMENT ON COLUMN psg.oxymat_begin_time IS '����-����� ����������� OXYMAT';
COMMENT ON COLUMN psg.cpap_type_id IS '��� CPAP';
COMMENT ON COLUMN psg.cpap_serial IS '�������� ����� CPAP';
COMMENT ON COLUMN psg.cpap_mask_type_id IS '��� ����� ��� CPAP';
COMMENT ON COLUMN psg.oxymat_mask_type_id IS '��� ����� ��� Oxymat';
COMMENT ON COLUMN psg.cushion_type_id IS '��� �������';
COMMENT ON COLUMN psg.cpap_mask_size_id IS '������ ����� CPAP';
COMMENT ON COLUMN psg.oxymat_mask_size_id IS '������ ����� OXYMAT';
COMMENT ON COLUMN psg.oxymat_type_id IS '��� OXYMAT';
COMMENT ON COLUMN psg.psg_no IS '����� ���';
COMMENT ON COLUMN psg.is_smooth_start IS 'CPAP: ������� �����';
COMMENT ON COLUMN psg.smooth_start_duration IS 'CPAP: ������������ �������� ������, �����';
COMMENT ON COLUMN psg.breath_humidity IS 'CPAP: ���������� �������';

