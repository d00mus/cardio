PROMPT CREATE TABLE psg_attr_ad
CREATE TABLE psg_attr_ad (
  id              NUMBER(18,0) NOT NULL,
  psg_id          NUMBER(18,0) NOT NULL,
  measuring_time  DATE         NOT NULL,
  psg_level       NUMBER(2,0)  DEFAULT 0 NOT NULL,
  systol_pressue  NUMBER(3,0)  NOT NULL,
  diastol_pressue NUMBER(3,0)  NOT NULL,
  hand            CHAR(1)      NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE psg_attr_ad IS 'Замеры артериального давления во время ПСГ';

COMMENT ON COLUMN psg_attr_ad.id IS 'ID';
COMMENT ON COLUMN psg_attr_ad.psg_id IS 'Ссылка на событие ПГС, в рамках которого сделан этот замер';
COMMENT ON COLUMN psg_attr_ad.measuring_time IS 'Дата-время замера';
COMMENT ON COLUMN psg_attr_ad.psg_level IS 'Уровень ПГС, 0 - без ничего, 1- подл. CPAP, 2 - подкл Oxymat';
COMMENT ON COLUMN psg_attr_ad.systol_pressue IS 'Систолическое давление';
COMMENT ON COLUMN psg_attr_ad.diastol_pressue IS 'Диастолическое давление';
COMMENT ON COLUMN psg_attr_ad.hand IS 'На какой руке меряли, R-правая, L - левая';

