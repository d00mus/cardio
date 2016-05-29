PROMPT CREATE TABLE patient_call
CREATE TABLE patient_call (
  id                  NUMBER(18,0)   NOT NULL,
  patient_id          NUMBER(18,0)   NOT NULL,
  nurse_id            NUMBER(18,0)   NOT NULL,
  phone_id            NUMBER(18,0)   NOT NULL,
  call_date           DATE           NOT NULL,
  is_accepted         CHAR(1)        DEFAULT 'T' NOT NULL,
  recall_after_req    DATE           NULL,
  call_details        VARCHAR2(4000) NULL,
  new_psg_date        DATE           NULL,
  curr_press_sis      NUMBER(4,0)    NULL,
  curr_press_dia      NUMBER(4,0)    NULL,
  curr_weight         NUMBER(6,2)    NULL,
  sp02_min            NUMBER(6,2)    NULL,
  sp02_avg            NUMBER(6,2)    NULL,
  msr_freq            NUMBER(4,0)    NULL,
  cmn_feeling_id      NUMBER(8,0)    NULL,
  is_sleep_mode_ok    CHAR(1)        NULL,
  is_sleep_culture_ok CHAR(1)        NULL,
  is_sleepy_is        CHAR(1)        NULL,
  is_sleep_pos_ok     CHAR(1)        NULL,
  is_doc_consulted    CHAR(1)        NULL,
  consulted_by_doc    VARCHAR2(64)   NULL,
  is_card_prg_passed  CHAR(1)        NULL,
  is_card_prg_in_utm  CHAR(1)        NULL,
  have_q_abo_mask     CHAR(1)        NULL,
  have_q_abo_dev      CHAR(1)        NULL,
  fltr_repla_freq     NUMBER(4,0)    NULL,
  nurse_notes         VARCHAR2(4000) NULL,
  is_ad_control       CHAR(1)        NULL,
  is_sp02_control     CHAR(1)        NULL,
  cpr_is_sleep_normal CHAR(1)        NULL,
  cpr_is_active_grow  CHAR(1)        NULL,
  cpr_is_cardio_ok    CHAR(1)        NULL,
  cpr_is_slimming     CHAR(1)        NULL,
  cpr_slimming_by     NUMBER(6,2)    NULL,
  cpr_is_sexual_ok    CHAR(1)        NULL,
  cpr_is_live_fun     CHAR(1)        NULL,
  cpr_is_depress_off  CHAR(1)        NULL,
  cpr_other           VARCHAR2(1024) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE patient_call IS '����� ��������, �������, ���������';

COMMENT ON COLUMN patient_call.patient_id IS '�������, �������� �������';
COMMENT ON COLUMN patient_call.nurse_id IS '���� - ���������, ������� �������';
COMMENT ON COLUMN patient_call.phone_id IS '�������, �� �������� �������';
COMMENT ON COLUMN patient_call.call_date IS '����/����� �������';
COMMENT ON COLUMN patient_call.is_accepted IS '������ ������';
COMMENT ON COLUMN patient_call.recall_after_req IS '��������� ����������� �����';
COMMENT ON COLUMN patient_call.call_details IS '������ ���������';
COMMENT ON COLUMN patient_call.new_psg_date IS '���� ������ �� �������� ���';
COMMENT ON COLUMN patient_call.curr_press_sis IS '��������, �������������';
COMMENT ON COLUMN patient_call.curr_press_dia IS '��������, ��������������';
COMMENT ON COLUMN patient_call.curr_weight IS '������� ���';
COMMENT ON COLUMN patient_call.sp02_min IS 'Sp02 - ���';
COMMENT ON COLUMN patient_call.sp02_avg IS 'Sp02 - ��';
COMMENT ON COLUMN patient_call.msr_freq IS '������� ������� � �����';
COMMENT ON COLUMN patient_call.cmn_feeling_id IS '����� ������������';
COMMENT ON COLUMN patient_call.is_sleep_mode_ok IS '����������� �� ����� ���?';
COMMENT ON COLUMN patient_call.is_sleep_culture_ok IS '����������� �� �������� ���?';
COMMENT ON COLUMN patient_call.is_sleepy_is IS '���� �� ����������?';
COMMENT ON COLUMN patient_call.is_sleep_pos_ok IS '��������� �� ������� � �������?';
COMMENT ON COLUMN patient_call.is_doc_consulted IS '���� �� �� ������������ � �������� �����?';
COMMENT ON COLUMN patient_call.consulted_by_doc IS '��� �������, ������� ��������������';
COMMENT ON COLUMN patient_call.is_card_prg_passed IS '����������� �� ��(������-���������)?';
COMMENT ON COLUMN patient_call.is_card_prg_in_utm IS '��������� � ���?';
COMMENT ON COLUMN patient_call.have_q_abo_mask IS '���� �� ������� �� �����?';
COMMENT ON COLUMN patient_call.have_q_abo_dev IS '���� �� ������� �� �������?';
COMMENT ON COLUMN patient_call.fltr_repla_freq IS '������� ������ �������� � �����';
COMMENT ON COLUMN patient_call.nurse_notes IS '������� ���������';
COMMENT ON COLUMN patient_call.is_ad_control IS '�������������� �� �������� ��';
COMMENT ON COLUMN patient_call.is_sp02_control IS '�������������� �� �������� Sp02';
COMMENT ON COLUMN patient_call.cpr_is_sleep_normal IS '��������� �������. ������������ ������������ ���';
COMMENT ON COLUMN patient_call.cpr_is_active_grow IS '��������� �������. ��������� �����������������';
COMMENT ON COLUMN patient_call.cpr_is_cardio_ok IS '��������� �������. ��������� ��������� ����������� - �������� � ����';
COMMENT ON COLUMN patient_call.cpr_is_slimming IS '��������� �������. ���� ���������';
COMMENT ON COLUMN patient_call.cpr_slimming_by IS '��������� �������. ��������� �� ������� ���������';
COMMENT ON COLUMN patient_call.cpr_is_sexual_ok IS '��������� �������. �������������� �������� � ����������� ������� �������';
COMMENT ON COLUMN patient_call.cpr_is_live_fun IS '��������� �������. ����������� ������� �����';
COMMENT ON COLUMN patient_call.cpr_is_depress_off IS '��������� �������. ���������� ���������';
COMMENT ON COLUMN patient_call.cpr_other IS '��������� �������. ������ ������������� ����������, �������';

