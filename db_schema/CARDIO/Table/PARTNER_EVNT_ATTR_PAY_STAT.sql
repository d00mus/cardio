PROMPT CREATE TABLE partner_evnt_attr_pay_stat
CREATE TABLE partner_evnt_attr_pay_stat (
  id   NUMBER(8,0)   NOT NULL,
  code VARCHAR2(32)  NOT NULL,
  name VARCHAR2(255) NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE partner_evnt_attr_pay_stat IS 'Статус платежа, для события партнёра';


