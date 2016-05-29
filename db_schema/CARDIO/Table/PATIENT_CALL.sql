PROMPT CREATE TABLE patient_call
CREATE TABLE patient_call (
  id                  NUMBER(18,0)   NOT NULL,
  patient_id          NUMBER(18,0)   NOT NULL,
  nurse_id            NUMBER(18,0)   NOT NULL,
  phone_id            NUMBER(18,0)   NOT NULL,
  call_date           DATE           NOT NULL,
  is_accepted         CHAR(1)        DEFAULT 'T' NOT NULL,
  recall_after_req    DATE           NULL,
  call_details        VARCHAR2(4000) NULL,
  new_psg_date        DATE           NULL,
  curr_press_sis      NUMBER(4,0)    NULL,
  curr_press_dia      NUMBER(4,0)    NULL,
  curr_weight         NUMBER(6,2)    NULL,
  sp02_min            NUMBER(6,2)    NULL,
  sp02_avg            NUMBER(6,2)    NULL,
  msr_freq            NUMBER(4,0)    NULL,
  cmn_feeling_id      NUMBER(8,0)    NULL,
  is_sleep_mode_ok    CHAR(1)        NULL,
  is_sleep_culture_ok CHAR(1)        NULL,
  is_sleepy_is        CHAR(1)        NULL,
  is_sleep_pos_ok     CHAR(1)        NULL,
  is_doc_consulted    CHAR(1)        NULL,
  consulted_by_doc    VARCHAR2(64)   NULL,
  is_card_prg_passed  CHAR(1)        NULL,
  is_card_prg_in_utm  CHAR(1)        NULL,
  have_q_abo_mask     CHAR(1)        NULL,
  have_q_abo_dev      CHAR(1)        NULL,
  fltr_repla_freq     NUMBER(4,0)    NULL,
  nurse_notes         VARCHAR2(4000) NULL,
  is_ad_control       CHAR(1)        NULL,
  is_sp02_control     CHAR(1)        NULL,
  cpr_is_sleep_normal CHAR(1)        NULL,
  cpr_is_active_grow  CHAR(1)        NULL,
  cpr_is_cardio_ok    CHAR(1)        NULL,
  cpr_is_slimming     CHAR(1)        NULL,
  cpr_slimming_by     NUMBER(6,2)    NULL,
  cpr_is_sexual_ok    CHAR(1)        NULL,
  cpr_is_live_fun     CHAR(1)        NULL,
  cpr_is_depress_off  CHAR(1)        NULL,
  cpr_other           VARCHAR2(1024) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE patient_call IS 'Звонк пациенту, попытка, результат';

COMMENT ON COLUMN patient_call.patient_id IS 'Пациент, которому звонили';
COMMENT ON COLUMN patient_call.nurse_id IS 'Юзер - медсестра, которая звонила';
COMMENT ON COLUMN patient_call.phone_id IS 'Телефон, по которому звонили';
COMMENT ON COLUMN patient_call.call_date IS 'Дата/время звоника';
COMMENT ON COLUMN patient_call.is_accepted IS 'Звонок принят';
COMMENT ON COLUMN patient_call.recall_after_req IS 'Попросили перезвонить позже';
COMMENT ON COLUMN patient_call.call_details IS 'Детали разговора';
COMMENT ON COLUMN patient_call.new_psg_date IS 'Дата записи на очердное ПСГ';
COMMENT ON COLUMN patient_call.curr_press_sis IS 'Давление, систолическое';
COMMENT ON COLUMN patient_call.curr_press_dia IS 'Давление, диастолическое';
COMMENT ON COLUMN patient_call.curr_weight IS 'Текущий вес';
COMMENT ON COLUMN patient_call.sp02_min IS 'Sp02 - мин';
COMMENT ON COLUMN patient_call.sp02_avg IS 'Sp02 - ср';
COMMENT ON COLUMN patient_call.msr_freq IS 'Частота замеров в сутки';
COMMENT ON COLUMN patient_call.cmn_feeling_id IS 'Общее самочувствие';
COMMENT ON COLUMN patient_call.is_sleep_mode_ok IS 'Соблюдается ли режим сна?';
COMMENT ON COLUMN patient_call.is_sleep_culture_ok IS 'Соблюдается ли культура сна?';
COMMENT ON COLUMN patient_call.is_sleepy_is IS 'Есть ли сонливость?';
COMMENT ON COLUMN patient_call.is_sleep_pos_ok IS 'Подобрали ли позицию в кровати?';
COMMENT ON COLUMN patient_call.is_doc_consulted IS 'Были ли на консультации у лечащего врача?';
COMMENT ON COLUMN patient_call.consulted_by_doc IS 'Фио доктора, который консультировал';
COMMENT ON COLUMN patient_call.is_card_prg_passed IS 'Проходилась ли КП(кардио-программа)?';
COMMENT ON COLUMN patient_call.is_card_prg_in_utm IS 'Проходили в УТМ?';
COMMENT ON COLUMN patient_call.have_q_abo_mask IS 'Есть ли вопросы по маске?';
COMMENT ON COLUMN patient_call.have_q_abo_dev IS 'Есть ли вопросы по девайсу?';
COMMENT ON COLUMN patient_call.fltr_repla_freq IS 'Частота замены фильтров в месяц';
COMMENT ON COLUMN patient_call.nurse_notes IS 'Заметки медсестры';
COMMENT ON COLUMN patient_call.is_ad_control IS 'Осуществляется ли контроль АД';
COMMENT ON COLUMN patient_call.is_sp02_control IS 'Осуществляется ли контроль Sp02';
COMMENT ON COLUMN patient_call.cpr_is_sleep_normal IS 'Результат лечения. Нормализация полноценного сна';
COMMENT ON COLUMN patient_call.cpr_is_active_grow IS 'Результат лечения. Повышение работоспособности';
COMMENT ON COLUMN patient_call.cpr_is_cardio_ok IS 'Результат лечения. Улучшение сердечных показателей - давление и ритм';
COMMENT ON COLUMN patient_call.cpr_is_slimming IS 'Результат лечения. Есть похудение';
COMMENT ON COLUMN patient_call.cpr_slimming_by IS 'Результат лечения. Похудение на сколько килограмм';
COMMENT ON COLUMN patient_call.cpr_is_sexual_ok IS 'Результат лечения. Восстановление потенции и активизация половой функции';
COMMENT ON COLUMN patient_call.cpr_is_live_fun IS 'Результат лечения. Возвращение радости жизни';
COMMENT ON COLUMN patient_call.cpr_is_depress_off IS 'Результат лечения. Устранение депрессии';
COMMENT ON COLUMN patient_call.cpr_other IS 'Результат лечения. Другие положительные результаты, описать';

