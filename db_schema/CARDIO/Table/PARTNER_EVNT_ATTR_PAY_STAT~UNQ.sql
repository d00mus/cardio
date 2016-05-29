PROMPT ALTER TABLE partner_evnt_attr_pay_stat ADD CONSTRAINT pk_partner_evnt_attr_pay_stat PRIMARY KEY
ALTER TABLE partner_evnt_attr_pay_stat
  ADD CONSTRAINT pk_partner_evnt_attr_pay_stat PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

