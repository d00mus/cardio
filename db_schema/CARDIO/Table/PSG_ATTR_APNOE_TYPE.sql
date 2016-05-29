PROMPT CREATE TABLE psg_attr_apnoe_type
CREATE TABLE psg_attr_apnoe_type (
  id         NUMBER(8,0)  NOT NULL,
  code       VARCHAR2(16) NOT NULL,
  name       VARCHAR2(32) NOT NULL,
  short_name VARCHAR2(16) NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE psg_attr_apnoe_type IS 'Типы апное';


