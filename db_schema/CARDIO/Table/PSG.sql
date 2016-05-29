PROMPT CREATE TABLE psg
CREATE TABLE psg (
  id                    NUMBER(18,0)   NOT NULL,
  patient_id            NUMBER(18,0)   NOT NULL,
  nurse_id              NUMBER(18,0)   NULL,
  psg_date              DATE           DEFAULT trunc(sysdate) NOT NULL,
  cabinet_id            NUMBER(18,0)   NULL,
  current_weigth        NUMBER(6,2)    NOT NULL,
  current_height        NUMBER(6,2)    NOT NULL,
  is_done               CHAR(1)        DEFAULT 'F' NOT NULL,
  notes                 VARCHAR2(2000) NULL,
  detector_on_time      DATE           NULL,
  light_off_time        DATE           NULL,
  go_to_sleep_time      DATE           NULL,
  wake_up_time          DATE           NULL,
  total_sleep_time_hour NUMBER(6,2)    NULL,
  cpap_begin_time       DATE           NULL,
  oxymat_begin_time     DATE           NULL,
  cpap_type_id          NUMBER(18,0)   NULL,
  cpap_serial           VARCHAR2(32)   NULL,
  cpap_mask_type_id     NUMBER(18,0)   NULL,
  oxymat_mask_type_id   NUMBER(18,0)   NULL,
  cushion_type_id       NUMBER(18,0)   NULL,
  cpap_mask_size_id     NUMBER(10,0)   NULL,
  oxymat_mask_size_id   NUMBER(10,0)   NULL,
  oxymat_type_id        NUMBER(10,0)   NULL,
  psg_no                NUMBER(5,0)    DEFAULT null NOT NULL,
  is_smooth_start       CHAR(1)        NULL,
  smooth_start_duration NUMBER(4,0)    NULL,
  breath_humidity       NUMBER(4,0)    NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE psg IS 'ПСГ(События)';

COMMENT ON COLUMN psg.id IS 'ID';
COMMENT ON COLUMN psg.patient_id IS 'Пациент';
COMMENT ON COLUMN psg.nurse_id IS 'Медсестра(юзер)';
COMMENT ON COLUMN psg.psg_date IS 'Дата начала проведения ПСГ';
COMMENT ON COLUMN psg.cabinet_id IS 'Кабинет, в котором дело происходит';
COMMENT ON COLUMN psg.current_weigth IS 'Текущий вес пациента, кг';
COMMENT ON COLUMN psg.current_height IS 'Текущий рост пациента, см';
COMMENT ON COLUMN psg.is_done IS 'Сеанс ПСГ завершён';
COMMENT ON COLUMN psg.notes IS 'Заметки';
COMMENT ON COLUMN psg.detector_on_time IS 'Время подключения датчиков';
COMMENT ON COLUMN psg.light_off_time IS 'Время выключения света в палате';
COMMENT ON COLUMN psg.go_to_sleep_time IS 'Время засыпания пациента';
COMMENT ON COLUMN psg.wake_up_time IS 'Время пробуждения пацента';
COMMENT ON COLUMN psg.total_sleep_time_hour IS 'Общее время сна пацента, часы';
COMMENT ON COLUMN psg.cpap_begin_time IS 'Дата-время подключения CPAP';
COMMENT ON COLUMN psg.oxymat_begin_time IS 'Дата-время подключения OXYMAT';
COMMENT ON COLUMN psg.cpap_type_id IS 'Тип CPAP';
COMMENT ON COLUMN psg.cpap_serial IS 'Серийный номер CPAP';
COMMENT ON COLUMN psg.cpap_mask_type_id IS 'Тип маски для CPAP';
COMMENT ON COLUMN psg.oxymat_mask_type_id IS 'Тип маски для Oxymat';
COMMENT ON COLUMN psg.cushion_type_id IS 'Тип подушки';
COMMENT ON COLUMN psg.cpap_mask_size_id IS 'Размер маски CPAP';
COMMENT ON COLUMN psg.oxymat_mask_size_id IS 'Размер маски OXYMAT';
COMMENT ON COLUMN psg.oxymat_type_id IS 'Тип OXYMAT';
COMMENT ON COLUMN psg.psg_no IS 'Номер ПСГ';
COMMENT ON COLUMN psg.is_smooth_start IS 'CPAP: плавный старт';
COMMENT ON COLUMN psg.smooth_start_duration IS 'CPAP: длительность плавного старта, минут';
COMMENT ON COLUMN psg.breath_humidity IS 'CPAP: увлажнение дыхания';

