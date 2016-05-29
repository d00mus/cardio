PROMPT CREATE TABLE psg_attr_detector_tune
CREATE TABLE psg_attr_detector_tune (
  id             NUMBER(18,0) NOT NULL,
  psg_id         NUMBER(18,0) NOT NULL,
  measuring_time DATE         NOT NULL,
  detector_id    NUMBER(8,0)  DEFAULT null NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE psg_attr_detector_tune IS 'Время поправления датчиков во время ПСГ';

COMMENT ON COLUMN psg_attr_detector_tune.id IS 'ID';
COMMENT ON COLUMN psg_attr_detector_tune.psg_id IS 'Ссылка на событие ПГС, в рамках которого сделан этот замер';
COMMENT ON COLUMN psg_attr_detector_tune.measuring_time IS 'Дата-время поправления';
COMMENT ON COLUMN psg_attr_detector_tune.detector_id IS 'Айди датчика, который поправили';

