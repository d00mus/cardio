PROMPT CREATE INDEX ifk_psg_attr_cpap_balance_prm
CREATE INDEX ifk_psg_attr_cpap_balance_prm
  ON psg_attr_cpap_balance_prm (
    psg_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

