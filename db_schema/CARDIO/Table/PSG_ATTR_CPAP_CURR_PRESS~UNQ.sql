PROMPT ALTER TABLE psg_attr_cpap_curr_press ADD CONSTRAINT pk_psg_attr_cpap_curr_press PRIMARY KEY
ALTER TABLE psg_attr_cpap_curr_press
  ADD CONSTRAINT pk_psg_attr_cpap_curr_press PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

