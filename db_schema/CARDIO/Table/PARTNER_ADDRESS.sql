PROMPT CREATE TABLE partner_address
CREATE TABLE partner_address (
  id          NUMBER(18,0)  NOT NULL,
  partner_id  NUMBER(18,0)  NOT NULL,
  name        VARCHAR2(255) NOT NULL,
  phone       VARCHAR2(128) NULL,
  ua_state_id NUMBER(8,0)   NOT NULL,
  ua_town_id  NUMBER(8,0)   NOT NULL,
  street      VARCHAR2(255) NULL,
  house       VARCHAR2(100) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE partner_address IS '����������� ������ �������(�������)';

COMMENT ON COLUMN partner_address.partner_id IS '������';
COMMENT ON COLUMN partner_address.name IS '�������� ';
COMMENT ON COLUMN partner_address.phone IS '�������(�)';
COMMENT ON COLUMN partner_address.ua_state_id IS '������ �� �������';
COMMENT ON COLUMN partner_address.ua_town_id IS '������ �� �����';
COMMENT ON COLUMN partner_address.street IS '�����';
COMMENT ON COLUMN partner_address.house IS '�����';

