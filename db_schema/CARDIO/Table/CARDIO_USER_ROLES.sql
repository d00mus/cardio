PROMPT CREATE TABLE cardio_user_roles
CREATE TABLE cardio_user_roles (
  user_id NUMBER(10,0) NOT NULL,
  role_id NUMBER(10,0) NOT NULL
)
  STORAGE (
    NEXT       1024 K
  )
/

COMMENT ON TABLE cardio_user_roles IS 'Роли, назначенные юзерам';


