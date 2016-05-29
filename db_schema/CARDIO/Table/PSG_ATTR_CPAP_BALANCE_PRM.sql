PROMPT CREATE TABLE psg_attr_cpap_balance_prm
CREATE TABLE psg_attr_cpap_balance_prm (
  id                NUMBER(18,0) NOT NULL,
  psg_id            NUMBER(18,0) NOT NULL,
  measuring_time    DATE         DEFAULT sysdate NOT NULL,
  pr_upper_treshold NUMBER(4,1)  NULL,
  pr_lower_treshold NUMBER(4,1)  NULL,
  soft_pap_function VARCHAR2(16) DEFAULT 'soft1' NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE psg_attr_cpap_balance_prm IS 'ПГС, CPAP, параметры Somnobalance';

COMMENT ON COLUMN psg_attr_cpap_balance_prm.psg_id IS 'ПСГ';
COMMENT ON COLUMN psg_attr_cpap_balance_prm.measuring_time IS 'Время замера';
COMMENT ON COLUMN psg_attr_cpap_balance_prm.pr_upper_treshold IS 'Верхняя граница давления';
COMMENT ON COLUMN psg_attr_cpap_balance_prm.pr_lower_treshold IS 'Нижняя граница давления';
COMMENT ON COLUMN psg_attr_cpap_balance_prm.soft_pap_function IS 'Функция SoftPAP';

