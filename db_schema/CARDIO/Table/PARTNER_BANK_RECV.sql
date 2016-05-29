PROMPT CREATE TABLE partner_bank_recv
CREATE TABLE partner_bank_recv (
  id         NUMBER(18,0)  NOT NULL,
  partner_id NUMBER(18,0)  NULL,
  type_code  VARCHAR2(32)  NULL,
  account    VARCHAR2(255) NULL,
  bank_name  VARCHAR2(255) NULL,
  bank_mfo   VARCHAR2(32)  NULL,
  inn        VARCHAR2(32)  NULL,
  recv_name  VARCHAR2(255) NULL,
  notes      VARCHAR2(255) NULL,
  close_date DATE          NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE partner_bank_recv IS '�������� ��������� ��������(����������)';

COMMENT ON COLUMN partner_bank_recv.partner_id IS '����������';
COMMENT ON COLUMN partner_bank_recv.type_code IS '��� ���������';
COMMENT ON COLUMN partner_bank_recv.account IS '����� �����';
COMMENT ON COLUMN partner_bank_recv.bank_name IS '�������� �����';
COMMENT ON COLUMN partner_bank_recv.bank_mfo IS 'MFO �����';
COMMENT ON COLUMN partner_bank_recv.inn IS 'INN ����������';
COMMENT ON COLUMN partner_bank_recv.recv_name IS '�������� ����������';
COMMENT ON COLUMN partner_bank_recv.notes IS '�������';
COMMENT ON COLUMN partner_bank_recv.close_date IS '���� ��������';

