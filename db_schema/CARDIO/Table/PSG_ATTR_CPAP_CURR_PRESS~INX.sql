PROMPT CREATE INDEX ifk_psg_attr_cpap_curr_press
CREATE INDEX ifk_psg_attr_cpap_curr_press
  ON psg_attr_cpap_curr_press (
    psg_id
  )
  STORAGE (
    NEXT       1024 K
  )
/

