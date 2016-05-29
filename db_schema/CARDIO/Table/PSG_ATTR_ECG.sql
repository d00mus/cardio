PROMPT CREATE TABLE psg_attr_ecg
CREATE TABLE psg_attr_ecg (
  id             NUMBER(18,0)  NOT NULL,
  psg_id         NUMBER(18,0)  NOT NULL,
  measuring_time DATE          NOT NULL,
  psg_level      NUMBER(2,0)   DEFAULT 0 NOT NULL,
  notes          VARCHAR2(255) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE psg_attr_ecg IS 'Замеры артериального давления во время ПСГ';

COMMENT ON COLUMN psg_attr_ecg.id IS 'ID';
COMMENT ON COLUMN psg_attr_ecg.psg_id IS 'Ссылка на событие ПГС, в рамках которого сделан этот замер';
COMMENT ON COLUMN psg_attr_ecg.measuring_time IS 'Дата-время замера';
COMMENT ON COLUMN psg_attr_ecg.psg_level IS 'Уровень ПГС, 0 - без ничего, 1- подл. CPAP, 2 - подкл Oxymat';
COMMENT ON COLUMN psg_attr_ecg.notes IS 'Примечания';

