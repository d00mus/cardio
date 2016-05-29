PROMPT CREATE TABLE psg_attr_pulls
CREATE TABLE psg_attr_pulls (
  id             NUMBER(18,0) NOT NULL,
  psg_id         NUMBER(18,0) NOT NULL,
  measuring_time DATE         NOT NULL,
  psg_level      NUMBER(2,0)  DEFAULT 0 NOT NULL,
  hits_per_min   NUMBER(5,0)  DEFAULT 60 NOT NULL,
  hand           CHAR(1)      NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE psg_attr_pulls IS 'Замеры пульса по время проведения ПСГ';

COMMENT ON COLUMN psg_attr_pulls.id IS 'ID';
COMMENT ON COLUMN psg_attr_pulls.psg_id IS 'Ссылка на событие ПГС, в рамках которого сделан этот замер';
COMMENT ON COLUMN psg_attr_pulls.measuring_time IS 'Дата-время замера';
COMMENT ON COLUMN psg_attr_pulls.psg_level IS 'Уровень ПГС, 0 - без ничего, 1- подл. CPAP, 2 - подкл Oxymat';
COMMENT ON COLUMN psg_attr_pulls.hits_per_min IS 'Пульс, ударов в минуту';
COMMENT ON COLUMN psg_attr_pulls.hand IS 'На какой руке меряли, R-правая, L - левая';

