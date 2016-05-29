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

COMMENT ON TABLE psg_attr_cpap_vent_press IS '���. ��������� CPAP, Somnovent';

COMMENT ON COLUMN psg_attr_cpap_vent_press.eepap IS '�������� �� �����, ������������';
COMMENT ON COLUMN psg_attr_cpap_vent_press.ipap IS '�������� �� ������, ������������';
COMMENT ON COLUMN psg_attr_cpap_vent_press.epap IS '�������� � ����� ������, ������������';
COMMENT ON COLUMN psg_attr_cpap_vent_press.pdiff IS '������� ����� IPAP � EPAP, ������������';

