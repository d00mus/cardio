PROMPT CREATE TABLE psg_result
CREATE TABLE psg_result (
  id             NUMBER(18,0) NOT NULL,
  psg_id         NUMBER(18,0) NOT NULL,
  dg_iag         NUMBER(6,2)  NULL,
  dg_oa_epis     NUMBER(6,0)  NULL,
  dg_gipo_epis   NUMBER(6,0)  NULL,
  dg_ca_epis     NUMBER(6,0)  NULL,
  dg_avg_spo2    NUMBER(6,2)  NULL,
  dg_min_spo2    NUMBER(6,2)  NULL,
  dg_desatur_idx NUMBER(6,2)  NULL,
  neck_size      NUMBER(5,2)  NULL,
  height         NUMBER(5,2)  NULL,
  weigth         NUMBER(5,2)  NULL,
  wg_idx         NUMBER(5,2)  NULL,
  waist          NUMBER(5,2)  NULL,
  stegna         NUMBER(5,2)  NULL,
  chest          NUMBER(5,2)  NULL,
  tr_iag         NUMBER(6,2)  NULL,
  tr_oa_epis     NUMBER(6,0)  NULL,
  tr_gipo_epis   NUMBER(6,0)  NULL,
  tr_ca_epis     NUMBER(6,0)  NULL,
  tr_avg_spo2    NUMBER(6,2)  NULL,
  tr_min_spo2    NUMBER(6,2)  NULL,
  tr_desatur_idx NUMBER(6,2)  NULL,
  author_id      NUMBER(8,0)  NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE psg_result IS 'Результаты обследования';

COMMENT ON COLUMN psg_result.psg_id IS 'Ссылка на ПСГ';
COMMENT ON COLUMN psg_result.dg_iag IS 'Диагностическая ночь, ІАГ';
COMMENT ON COLUMN psg_result.dg_oa_epis IS 'Диагностическая ночь. Епізоди  ОА';
COMMENT ON COLUMN psg_result.dg_gipo_epis IS 'Диагностическая ночь. Епізоди гіпопное';
COMMENT ON COLUMN psg_result.dg_ca_epis IS 'Диагностическая ночь. Епізоди   ЦА';
COMMENT ON COLUMN psg_result.dg_avg_spo2 IS 'Диагностическая ночь. Сер. SpO2';
COMMENT ON COLUMN psg_result.dg_min_spo2 IS 'Диагностическая ночь. Мін.SpO2';
COMMENT ON COLUMN psg_result.dg_desatur_idx IS 'Диагностическая ночь. Індекс десатурації';
COMMENT ON COLUMN psg_result.neck_size IS 'Размер шеи';
COMMENT ON COLUMN psg_result.height IS 'Рост';
COMMENT ON COLUMN psg_result.weigth IS 'Вес';
COMMENT ON COLUMN psg_result.wg_idx IS 'Индекс массы тела';
COMMENT ON COLUMN psg_result.waist IS 'Талия, см';
COMMENT ON COLUMN psg_result.stegna IS 'Размер бёдер, см';
COMMENT ON COLUMN psg_result.chest IS 'Обьём груди, см';
COMMENT ON COLUMN psg_result.tr_iag IS 'Терапевтическая ночь, ІАГ';
COMMENT ON COLUMN psg_result.tr_oa_epis IS 'Терапевтическая ночь, Епізоди  ОА';
COMMENT ON COLUMN psg_result.tr_gipo_epis IS 'Терапевтическая ночь, Епізоди гіпопное';
COMMENT ON COLUMN psg_result.tr_ca_epis IS 'Терапевтическая ночь, Епізоди   ЦА';
COMMENT ON COLUMN psg_result.tr_avg_spo2 IS 'Терапевтическая ночь, Сер. SpO2';
COMMENT ON COLUMN psg_result.tr_min_spo2 IS 'Терапевтическая ночь, Мін.SpO2';
COMMENT ON COLUMN psg_result.tr_desatur_idx IS 'Терапевтическая ночь, Індекс десатурації';
COMMENT ON COLUMN psg_result.author_id IS 'Автор заключения';

