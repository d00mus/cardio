PROMPT CREATE TABLE user_files
CREATE TABLE user_files (
  id          NUMBER(8,0)   NOT NULL,
  user_id     NUMBER(8,0)   NOT NULL,
  file_name   VARCHAR2(255) NULL,
  file_date   DATE          NULL,
  description VARCHAR2(255) NULL,
  file_data   BLOB          NULL,
  uploaded    DATE          DEFAULT sysdate NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE user_files IS 'Файлы пользователей';

COMMENT ON COLUMN user_files.user_id IS 'Юзер';
COMMENT ON COLUMN user_files.file_name IS 'Имя файла';
COMMENT ON COLUMN user_files.file_date IS 'Дата файла';
COMMENT ON COLUMN user_files.description IS 'Описание';
COMMENT ON COLUMN user_files.file_data IS 'Данные файла';
COMMENT ON COLUMN user_files.uploaded IS 'Дата загрузки';

