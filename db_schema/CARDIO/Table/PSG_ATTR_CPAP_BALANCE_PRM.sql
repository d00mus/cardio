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

COMMENT ON TABLE psg_attr_cpap_balance_prm IS '���, CPAP, ��������� Somnobalance';

COMMENT ON COLUMN psg_attr_cpap_balance_prm.psg_id IS '���';
COMMENT ON COLUMN psg_attr_cpap_balance_prm.measuring_time IS '����� ������';
COMMENT ON COLUMN psg_attr_cpap_balance_prm.pr_upper_treshold IS '������� ������� ��������';
COMMENT ON COLUMN psg_attr_cpap_balance_prm.pr_lower_treshold IS '������ ������� ��������';
COMMENT ON COLUMN psg_attr_cpap_balance_prm.soft_pap_function IS '������� SoftPAP';

