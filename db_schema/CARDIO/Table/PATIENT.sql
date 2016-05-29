PROMPT CREATE TABLE patient
CREATE TABLE patient (
  id                     NUMBER(18,0)   NOT NULL,
  name                   VARCHAR2(64)   NULL,
  first_name             VARCHAR2(64)   NULL,
  second_name            VARCHAR2(64)   NULL,
  pseudo_name            VARCHAR2(64)   NULL,
  sex                    CHAR(1)        DEFAULT 'M' NOT NULL,
  birth_date             DATE           NOT NULL,
  adr_country            VARCHAR2(64)   DEFAULT '�������' NOT NULL,
  adr_city               VARCHAR2(64)   NULL,
  adr_street             VARCHAR2(64)   NULL,
  adr_house              VARCHAR2(8)    NULL,
  adr_flat               VARCHAR2(8)    NULL,
  cur_height             NUMBER(8,2)    NULL,
  cur_weight             NUMBER(8,2)    NULL,
  pass_ser               VARCHAR2(8)    NULL,
  pass_no                VARCHAR2(16)   NULL,
  pass_date              DATE           NULL,
  pass_gived_by          VARCHAR2(255)  NULL,
  contacts_id            NUMBER(18,0)   NULL,
  avatar_id              NUMBER(18,0)   NULL,
  work_town              VARCHAR2(64)   NULL,
  work_place             VARCHAR2(64)   NULL,
  is_foto_ads_allowed    CHAR(1)        DEFAULT 'F' NOT NULL,
  is_tv_ads_allowed      CHAR(1)        DEFAULT 'F' NOT NULL,
  is_other_ads_allowed   CHAR(1)        DEFAULT 'F' NOT NULL,
  vip_rank_id            NUMBER(18,0)   NULL,
  ref_info_doc_id        NUMBER(18,0)   NULL,
  ref_info_patient_id    NUMBER(18,0)   NULL,
  ref_rank_id            NUMBER(18,0)   NULL,
  is_checked             CHAR(1)        DEFAULT 'F' NOT NULL,
  is_active              CHAR(1)        DEFAULT 'T' NOT NULL,
  is_interest            CHAR(1)        DEFAULT 'F' NOT NULL,
  create_date            DATE           DEFAULT sysdate NOT NULL,
  last_psg_date          DATE           NULL,
  adr_district           VARCHAR2(64)   NULL,
  adr_ua_town_id         NUMBER(8,0)    NULL,
  adr_ua_state_id        NUMBER(8,0)    NULL,
  self_story             VARCHAR2(4000) NULL,
  nurse_notes            VARCHAR2(4000) NULL,
  special_notes          VARCHAR2(4000) NULL,
  doc_conlusion          VARCHAR2(4000) NULL,
  ref_info_src_type_id   NUMBER(8,0)    NULL,
  ref_info_src_detail    VARCHAR2(1000) NULL,
  cured_by_doc           VARCHAR2(255)  NULL,
  is_lor_invasion        CHAR(1)        DEFAULT 'F' NOT NULL,
  lor_invasion_details   VARCHAR2(1000) NULL,
  is_allergic            CHAR(1)        DEFAULT 'F' NOT NULL,
  allergic_detail        VARCHAR2(2000) NULL,
  is_gepatit             CHAR(1)        DEFAULT 'F' NOT NULL,
  is_botkin              CHAR(1)        DEFAULT 'F' NOT NULL,
  is_cert_given          CHAR(1)        DEFAULT 'F' NOT NULL,
  next_psg_date          DATE           NULL,
  created_by_user_id     NUMBER(10,0)   NULL,
  partner_name           VARCHAR2(255)  NULL,
  partner_phone_id       NUMBER(18,0)   NULL,
  fam_member_name        VARCHAR2(255)  NULL,
  fam_member_phone_id    NUMBER(18,0)   NULL,
  email_addr_list        VARCHAR2(2000) NULL,
  work_ua_town_id        NUMBER(8,0)    NULL,
  tracked_by_user_id     NUMBER(10,0)   NULL,
  cpap_status            VARCHAR2(64)   NULL,
  is_birth_day_not_valid CHAR(1)        DEFAULT 'T' NULL,
  is_card_prg_passed     CHAR(1)        NULL,
  patalogy_detail        VARCHAR2(2000) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE patient IS '��������';

COMMENT ON COLUMN patient.name IS '�������';
COMMENT ON COLUMN patient.first_name IS '���';
COMMENT ON COLUMN patient.second_name IS '��������';
COMMENT ON COLUMN patient.pseudo_name IS '���������';
COMMENT ON COLUMN patient.sex IS '��� (M,F)';
COMMENT ON COLUMN patient.birth_date IS '���� ��������';
COMMENT ON COLUMN patient.adr_country IS '����� - ������';
COMMENT ON COLUMN patient.adr_city IS '����� - �����';
COMMENT ON COLUMN patient.adr_street IS '����� - �����';
COMMENT ON COLUMN patient.adr_house IS '����� - ���';
COMMENT ON COLUMN patient.adr_flat IS '����� - ��������';
COMMENT ON COLUMN patient.cur_height IS '������� ����, ��';
COMMENT ON COLUMN patient.cur_weight IS '������� ���, ��';
COMMENT ON COLUMN patient.pass_ser IS '�������: �����';
COMMENT ON COLUMN patient.pass_no IS '�������: �����';
COMMENT ON COLUMN patient.pass_date IS '�������: ���� ������';
COMMENT ON COLUMN patient.pass_gived_by IS '�������: ��� �����';
COMMENT ON COLUMN patient.contacts_id IS '������ �� ��������';
COMMENT ON COLUMN patient.avatar_id IS '������ �� ����� - ������';
COMMENT ON COLUMN patient.work_town IS '�����, � ������� ��������';
COMMENT ON COLUMN patient.work_place IS '����� ������';
COMMENT ON COLUMN patient.is_foto_ads_allowed IS '�������� �� ������������� � ����-�������';
COMMENT ON COLUMN patient.is_tv_ads_allowed IS '�������� �� ������������� � ��-�������';
COMMENT ON COLUMN patient.is_other_ads_allowed IS '�������� �� ������������� � ������ �������';
COMMENT ON COLUMN patient.vip_rank_id IS '������� �������� ��������';
COMMENT ON COLUMN patient.ref_info_doc_id IS '�������� ����������: ��� �� �������� ��� �������';
COMMENT ON COLUMN patient.ref_info_patient_id IS '�������� ����������: ��� �� ��������� ��� �������';
COMMENT ON COLUMN patient.ref_rank_id IS '������� ��� ���� ������� �������� ������, ��� ��������� �������';
COMMENT ON COLUMN patient.is_checked IS '������ ��������� ���������������';
COMMENT ON COLUMN patient.is_active IS '������� ����, ��� ������� �������(�������)';
COMMENT ON COLUMN patient.is_interest IS '���������� �������?';
COMMENT ON COLUMN patient.create_date IS '���� �������� ������';
COMMENT ON COLUMN patient.last_psg_date IS '���� ��������� ���';
COMMENT ON COLUMN patient.adr_district IS '����� - �������, ��������';
COMMENT ON COLUMN patient.adr_ua_town_id IS '����� - ������ �� ���������� �����';
COMMENT ON COLUMN patient.adr_ua_state_id IS '����� - ������ �� ���������� �������';
COMMENT ON COLUMN patient.self_story IS '������� ��������, ������';
COMMENT ON COLUMN patient.nurse_notes IS '������� - ��� ������, �����';
COMMENT ON COLUMN patient.special_notes IS '������ ������� - �������, ��������� ���������������, ���';
COMMENT ON COLUMN patient.doc_conlusion IS '���������� �����';
COMMENT ON COLUMN patient.ref_info_src_type_id IS '�������� ����������:������ �� ��� ����������, ������� ������� �������� � �������';
COMMENT ON COLUMN patient.ref_info_src_detail IS '�������� ����������:������������, ������������ ���� ����';
COMMENT ON COLUMN patient.cured_by_doc IS '������� ����, ��������, ������������, ������������, ��������, ���';
COMMENT ON COLUMN patient.is_lor_invasion IS '���-�������������: ����?';
COMMENT ON COLUMN patient.lor_invasion_details IS '���-�������������:�����������';
COMMENT ON COLUMN patient.is_allergic IS '�������: ����?';
COMMENT ON COLUMN patient.allergic_detail IS '�������: �����������';
COMMENT ON COLUMN patient.is_gepatit IS '�������?';
COMMENT ON COLUMN patient.is_botkin IS '������?';
COMMENT ON COLUMN patient.is_cert_given IS '����� �� ����������?';
COMMENT ON COLUMN patient.next_psg_date IS '���� ��������� ���, ������ ���������� �� ����������� ��� � �������??';
COMMENT ON COLUMN patient.created_by_user_id IS '����, ������� ������ ������';
COMMENT ON COLUMN patient.partner_name IS '������ ��������';
COMMENT ON COLUMN patient.partner_phone_id IS '������� �������, �� ��������� ��������� ������� ��������';
COMMENT ON COLUMN patient.fam_member_name IS '���� ����� ��������';
COMMENT ON COLUMN patient.fam_member_phone_id IS '������� ����� �����, �� ��������� ��������� ������� ��������';
COMMENT ON COLUMN patient.email_addr_list IS '������ email-������� ��������, ���������� ��������';
COMMENT ON COLUMN patient.work_ua_town_id IS '������ �� ���������� �����, � ������� �������� �������';
COMMENT ON COLUMN patient.tracked_by_user_id IS '������ �� ������������, ������� ���� ������';
COMMENT ON COLUMN patient.cpap_status IS 'CPAP: �����/ �� �����/ ������';
COMMENT ON COLUMN patient.is_birth_day_not_valid IS '������� ����, ��� ���� �������� �������� �������� �����';
COMMENT ON COLUMN patient.is_card_prg_passed IS '�������� �� ������ ���������?';
COMMENT ON COLUMN patient.patalogy_detail IS '������������� ���������';

