PROMPT CREATE TABLE psg_attr_cpap_vent_press
CREATE TABLE psg_attr_cpap_vent_press (
  id             NUMBER(18,0) NOT NULL,
  measuring_time DATE         DEFAULT sysdate NOT NULL,
  psg_id         NUMBER(18,0) NOT NULL,
  eepap          NUMBER(6,2)  NULL,
  ipap           NUMBER(6,2)  NULL,
  epap           NUMBER(6,2)  NULL,
  pdiff          NUMBER(6,2)  NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE psg_attr_cpap_vent_press IS 'ПСГ. Параметры CPAP, Somnovent';

COMMENT ON COLUMN psg_attr_cpap_vent_press.eepap IS 'Давление на вдохе, гегтопаскали';
COMMENT ON COLUMN psg_attr_cpap_vent_press.ipap IS 'Давление на выдохе, гегтопаскали';
COMMENT ON COLUMN psg_attr_cpap_vent_press.epap IS 'Давление в конце выдоха, гегтопаскали';
COMMENT ON COLUMN psg_attr_cpap_vent_press.pdiff IS 'Разница между IPAP и EPAP, гегтопаскали';

