PROMPT CREATE TABLE partner_event_subj
CREATE TABLE partner_event_subj (
  id                    NUMBER(8,0)   NOT NULL,
  code                  VARCHAR2(32)  NOT NULL,
  name                  VARCHAR2(255) NOT NULL,
  is_date_visible       VARCHAR2(5)   DEFAULT 'false' NOT NULL,
  is_text_visible       VARCHAR2(5)   DEFAULT 'false' NOT NULL,
  is_num_visible        VARCHAR2(5)   DEFAULT 'false' NOT NULL,
  is_comp_visible       VARCHAR2(5)   DEFAULT 'false' NOT NULL,
  is_user_visible       VARCHAR2(5)   DEFAULT 'false' NOT NULL,
  is_proxy_visible      VARCHAR2(5)   DEFAULT 'false' NOT NULL,
  is_conferece_visible  VARCHAR2(5)   DEFAULT 'false' NOT NULL,
  is_cp_subj_visible    VARCHAR2(5)   DEFAULT 'false' NOT NULL,
  is_pay_status_visible VARCHAR2(5)   DEFAULT 'false' NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE partner_event_subj IS '������� �������';

COMMENT ON COLUMN partner_event_subj.code IS '��� �������� �������';
COMMENT ON COLUMN partner_event_subj.name IS '�������� ��������';
COMMENT ON COLUMN partner_event_subj.is_date_visible IS '��������� ���� ����';
COMMENT ON COLUMN partner_event_subj.is_text_visible IS '��������� ���� text';
COMMENT ON COLUMN partner_event_subj.is_num_visible IS '��������� ���� �����';
COMMENT ON COLUMN partner_event_subj.is_comp_visible IS '��������� ���� ��������';
COMMENT ON COLUMN partner_event_subj.is_user_visible IS '��������� ���� �����';
COMMENT ON COLUMN partner_event_subj.is_proxy_visible IS '��������� ���� ������������';
COMMENT ON COLUMN partner_event_subj.is_conferece_visible IS '��������� ���� �����������';
COMMENT ON COLUMN partner_event_subj.is_cp_subj_visible IS '��������� ���� �������� ��';
COMMENT ON COLUMN partner_event_subj.is_pay_status_visible IS '��������� ���� ������ �������';

