PROMPT CREATE OR REPLACE VIEW user_groups_view
CREATE OR REPLACE VIEW user_groups_view (
  user_name,
  role_name
) AS
select
 usr.user_name
,rol.role_name
from
     cardio_user usr
    ,cardio_role rol
    ,cardio_user_roles ur
where ur.user_id = usr.id
  and ur.role_id = rol.id
/

