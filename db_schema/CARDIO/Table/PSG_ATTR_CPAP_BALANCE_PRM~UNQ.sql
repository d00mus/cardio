PROMPT ALTER TABLE psg_attr_cpap_balance_prm ADD CONSTRAINT pk_psg_attr_cpap_balance_prm PRIMARY KEY
ALTER TABLE psg_attr_cpap_balance_prm
  ADD CONSTRAINT pk_psg_attr_cpap_balance_prm PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

