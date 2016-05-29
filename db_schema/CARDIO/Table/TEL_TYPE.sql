PROMPT CREATE TABLE tel_type
CREATE TABLE tel_type (
  id           NUMBER(10,0)   NOT NULL,
  type_code    VARCHAR2(32)   NOT NULL,
  type_name    VARCHAR2(255)  NOT NULL,
  is_mobile    CHAR(1)        DEFAULT 'T' NOT NULL,
  is_personal  CHAR(1)        DEFAULT 'T' NOT NULL,
  is_work      CHAR(1)        DEFAULT 'F' NOT NULL,
  is_fax       CHAR(1)        DEFAULT 'F' NOT NULL,
  is_ua        CHAR(1)        DEFAULT 'T' NOT NULL,
  regexp       VARCHAR2(2000) NULL,
  format_notes VARCHAR2(2000) NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE tel_type IS 'Тип телефона';

COMMENT ON COLUMN tel_type.type_code IS 'Код типа';
COMMENT ON COLUMN tel_type.type_name IS 'Название типа';
COMMENT ON COLUMN tel_type.is_mobile IS 'Мобильный? T - мобильный, F - стационарный';
COMMENT ON COLUMN tel_type.is_personal IS 'Личный? T - принадлежит/носим данн(ому/ым) лиц(у/ом), F - не принадлежит данному лицу, например телефон жены';
COMMENT ON COLUMN tel_type.is_work IS 'Рабочий? T - телефон рабочий, для рабочих нужд, F - телефон не рабочий';
COMMENT ON COLUMN tel_type.is_fax IS 'Факс? T - на этот номер можно слать факсы, F факсы слать - нельзя';
COMMENT ON COLUMN tel_type.is_ua IS 'Украинский? T - номер украинский, F - зарубежный';
COMMENT ON COLUMN tel_type.regexp IS 'Регулярное выражение для проверки';
COMMENT ON COLUMN tel_type.format_notes IS 'Сообщение при ошибке на проверку формата';

