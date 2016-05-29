PROMPT ALTER TABLE psg_attr_cpap_vent_press ADD CONSTRAINT pk_psg_attr_cpap_pressue PRIMARY KEY
ALTER TABLE psg_attr_cpap_vent_press
  ADD CONSTRAINT pk_psg_attr_cpap_pressue PRIMARY KEY (
    id
  )
  USING INDEX
    STORAGE (
      NEXT       1024 K
    )
/

