PROMPT CREATE TABLE cardio_user
CREATE TABLE cardio_user (
  id                 NUMBER(10,0)  NOT NULL,
  user_name          VARCHAR2(32)  NOT NULL,
  password           VARCHAR2(32)  NOT NULL,
  short_name         VARCHAR2(255) NULL,
  first_name         VARCHAR2(255) NULL,
  last_name          VARCHAR2(255) NULL,
  middle_name        VARCHAR2(255) NULL,
  birth_date         DATE          NULL,
  adr_state_id       NUMBER(8,0)   NULL,
  adr_town_id        NUMBER(8,0)   NULL,
  address            VARCHAR2(255) NULL,
  work_email         VARCHAR2(255) NULL,
  personal_email     VARCHAR2(255) NULL,
  is_outside_empl    CHAR(1)       DEFAULT 'F' NULL,
  outside_work_place VARCHAR2(255) NULL,
  outside_work_spec  VARCHAR2(255) NULL,
  pass_ser           VARCHAR2(8)   NULL,
  pass_no            VARCHAR2(32)  NULL,
  pass_giveout_date  DATE          NULL,
  pass_giveout       VARCHAR2(255) NULL,
  inn                VARCHAR2(32)  NULL,
  is_driver          CHAR(1)       NULL,
  drv_lic_no         VARCHAR2(32)  NULL,
  notes              VARCHAR2(255) NULL,
  is_have_auto       CHAR(1)       NULL,
  lic_auto_model     VARCHAR2(255) NULL,
  lic_auto_no        VARCHAR2(16)  NULL,
  fam_mbr_name       VARCHAR2(255) NULL,
  fam_mbr_phone_id   NUMBER(8,0)   NULL,
  avatar_file_id     NUMBER(8,0)   NULL,
  theme_name         VARCHAR2(255) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON COLUMN cardio_user.user_name IS '����� ������������ �������';
COMMENT ON COLUMN cardio_user.password IS '������, MD5 ���';
COMMENT ON COLUMN cardio_user.short_name IS '������� ���';
COMMENT ON COLUMN cardio_user.first_name IS '���';
COMMENT ON COLUMN cardio_user.last_name IS '�������';
COMMENT ON COLUMN cardio_user.middle_name IS '��������';
COMMENT ON COLUMN cardio_user.birth_date IS '���� ��������';
COMMENT ON COLUMN cardio_user.adr_state_id IS '�����/�������';
COMMENT ON COLUMN cardio_user.adr_town_id IS '�����/�����';
COMMENT ON COLUMN cardio_user.address IS '����� - �����, ���, ��';
COMMENT ON COLUMN cardio_user.work_email IS '������� ��. �����';
COMMENT ON COLUMN cardio_user.personal_email IS '������ ��. �����';
COMMENT ON COLUMN cardio_user.is_outside_empl IS '������������� �������� �� ��������� ��������';
COMMENT ON COLUMN cardio_user.outside_work_place IS '����� ������ �� ��������� ��������(���)';
COMMENT ON COLUMN cardio_user.outside_work_spec IS '����� ������ �� ��������� ��������(���)';
COMMENT ON COLUMN cardio_user.pass_ser IS '�������/�����';
COMMENT ON COLUMN cardio_user.pass_no IS '�������/�����';
COMMENT ON COLUMN cardio_user.pass_giveout_date IS '�������/���� ������';
COMMENT ON COLUMN cardio_user.pass_giveout IS '�������/��� �����';
COMMENT ON COLUMN cardio_user.inn IS '���';
COMMENT ON COLUMN cardio_user.is_driver IS '������� ����';
COMMENT ON COLUMN cardio_user.drv_lic_no IS '����� ����';
COMMENT ON COLUMN cardio_user.notes IS '����������';
COMMENT ON COLUMN cardio_user.is_have_auto IS '���� ������ ����';
COMMENT ON COLUMN cardio_user.lic_auto_model IS '������ ������� ����';
COMMENT ON COLUMN cardio_user.lic_auto_no IS '��� ����� ����';
COMMENT ON COLUMN cardio_user.fam_mbr_name IS '�����������';
COMMENT ON COLUMN cardio_user.fam_mbr_phone_id IS '������� ������������';
COMMENT ON COLUMN cardio_user.avatar_file_id IS '������ �� ���� � ����';
COMMENT ON COLUMN cardio_user.theme_name IS '�������� ���� ����������';

