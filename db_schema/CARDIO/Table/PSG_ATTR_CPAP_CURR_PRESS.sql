PROMPT CREATE TABLE psg_attr_cpap_curr_press
CREATE TABLE psg_attr_cpap_curr_press (
  id             NUMBER(18,0) NOT NULL,
  measuring_time DATE         DEFAULT sysdate NOT NULL,
  psg_id         NUMBER(18,0) NOT NULL,
  val1           NUMBER(4,1)  NULL,
  val2           NUMBER(4,1)  NULL,
  val3           NUMBER(4,1)  NULL,
  val4           NUMBER(4,1)  NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE psg_attr_cpap_curr_press IS 'ПСГ, параметры CPAP - текущее давление';

COMMENT ON COLUMN psg_attr_cpap_curr_press.measuring_time IS 'Момент замера';
COMMENT ON COLUMN psg_attr_cpap_curr_press.psg_id IS 'ПСГ';
COMMENT ON COLUMN psg_attr_cpap_curr_press.val1 IS 'Замер 1';
COMMENT ON COLUMN psg_attr_cpap_curr_press.val2 IS 'Замер 2';
COMMENT ON COLUMN psg_attr_cpap_curr_press.val3 IS 'Замер 3';
COMMENT ON COLUMN psg_attr_cpap_curr_press.val4 IS 'Замер 4';

