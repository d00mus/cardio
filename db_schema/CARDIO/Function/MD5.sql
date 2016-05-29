PROMPT CREATE OR REPLACE FUNCTION md5
CREATE OR REPLACE function md5(p_str varchar2) return varchar2 is
res varchar2(32);
begin
  select lower(rawtohex(md5_raw(p_str))) into res from dual;
 return  res;
end md5;
/

