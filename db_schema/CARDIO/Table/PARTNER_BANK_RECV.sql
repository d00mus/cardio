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

COMMENT ON TABLE partner_bank_recv IS 'Платёжные реквизиты партнёров(учреждений)';

COMMENT ON COLUMN partner_bank_recv.partner_id IS 'Учреждение';
COMMENT ON COLUMN partner_bank_recv.type_code IS 'Тип реквизита';
COMMENT ON COLUMN partner_bank_recv.account IS 'Номер счёта';
COMMENT ON COLUMN partner_bank_recv.bank_name IS 'Название банка';
COMMENT ON COLUMN partner_bank_recv.bank_mfo IS 'MFO банка';
COMMENT ON COLUMN partner_bank_recv.inn IS 'INN получателя';
COMMENT ON COLUMN partner_bank_recv.recv_name IS 'Название получателя';
COMMENT ON COLUMN partner_bank_recv.notes IS 'Заметки';
COMMENT ON COLUMN partner_bank_recv.close_date IS 'Дата закрытия';

