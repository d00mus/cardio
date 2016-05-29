PROMPT CREATE INDEX ifk_psg_attr_cpap_pressue
CREATE INDEX ifk_psg_attr_cpap_pressue
  ON psg_attr_cpap_vent_press (
    psg_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

