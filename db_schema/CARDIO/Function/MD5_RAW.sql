PROMPT CREATE OR REPLACE FUNCTION md5_raw
CREATE OR REPLACE function md5_raw(p_str varchar2) return varchar2 is
res varchar2(512);
begin
  dbms_obfuscation_toolkit.md5(input_string=>p_str
               ,checksum_string=>res);
 return res;
end md5_raw;
/

