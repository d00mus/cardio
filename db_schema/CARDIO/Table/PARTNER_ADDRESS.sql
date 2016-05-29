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

COMMENT ON TABLE partner_address IS 'Фактические адреса партнёра(филиалы)';

COMMENT ON COLUMN partner_address.partner_id IS 'Партнёр';
COMMENT ON COLUMN partner_address.name IS 'Название ';
COMMENT ON COLUMN partner_address.phone IS 'Телефон(ы)';
COMMENT ON COLUMN partner_address.ua_state_id IS 'Ссылка на область';
COMMENT ON COLUMN partner_address.ua_town_id IS 'Ссылка на город';
COMMENT ON COLUMN partner_address.street IS 'Улица';
COMMENT ON COLUMN partner_address.house IS 'Город';

