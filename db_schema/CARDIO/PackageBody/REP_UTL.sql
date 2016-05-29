PROMPT CREATE OR REPLACE PACKAGE BODY rep_utl
CREATE OR REPLACE package body rep_utl is



  /**
  ѕолучить список всех дат ѕ—√
  */

function get_psg_dates(p_patient_id number) return varchar2
  is
  cursor cur
   is
    select * from psg p
    where p.patient_id = p_patient_id
    order by p.psg_date
    ;

   l_result varchar2(1024);

  begin

   for l in cur
     loop
       l_result:=l_result||to_char(l.psg_date,'dd.mm.yyyy')||', ';
     end loop;

   if(l_result is not null)
    then
      l_result :=substr(l_result,1,length(l_result)-2);
     end if;
    return l_result;
  end get_psg_dates;

-----------------------------------------------

--получить полный адрес пациента, русский
  function get_full_address_rus(p_patient_id number) return varchar2
    is
    l_result varchar2(1024);
    l_pat patient%rowtype;
    l_town_name varchar2(1024);
    l_state_name varchar2(1024);
    begin
      select p.* into l_pat from patient p where p.id = p_patient_id;

      --если это украинский адрес, тогда выбрать по ссылкам название города и области
      if(l_pat.adr_country='”краина')then
       if(l_pat.adr_ua_town_id is not null) then
        select t.rus_name into l_town_name from ua_town t where t.id = l_pat.adr_ua_town_id;
       end if;

       if(l_pat.adr_ua_state_id is not null) then
        select s.rus_name into l_state_name from ua_state s where s.id = l_pat.adr_ua_state_id;
       end if;

      else
        l_town_name := trim(l_pat.adr_city);
        l_state_name := trim(l_pat.adr_district);

      end if;

      --собрать полный адрес
      l_result := l_pat.adr_country||', ';

      if(l_state_name is not null)then
       l_result := l_result||l_state_name||' область, ';
      end if;

      if(l_town_name is not null)then
       l_result := l_result||l_town_name||', ';
      end if;

      if(l_pat.adr_street is not null) then
       l_result := l_result||l_pat.adr_street||' ';
      end if;

      if(l_pat.adr_house is not null) then
       l_result := l_result||l_pat.adr_house;
      end if;

      if(l_pat.adr_flat is not null) then
       l_result := l_result||'-'||l_pat.adr_flat;
      end if;

     return l_result;

    end get_full_address_rus;
---------------------------------

--получить полный адрес пациента, украинский
  function get_full_address_ukr(p_patient_id number) return varchar2
    is
    l_result varchar2(1024);
    l_pat patient%rowtype;
    l_town_name varchar2(1024);
    l_state_name varchar2(1024);
    begin
      select p.* into l_pat from patient p where p.id = p_patient_id;

      --если это украинский адрес, тогда выбрать по ссылкам название города и области
      if(l_pat.adr_country='”краина')then

       l_pat.adr_country :='”крањна'; --поправить страну

       if(l_pat.adr_ua_town_id is not null) then
        select t.ukr_name into l_town_name from ua_town t where t.id = l_pat.adr_ua_town_id;
       end if;

       if(l_pat.adr_ua_state_id is not null) then
        select s.ukr_name into l_state_name from ua_state s where s.id = l_pat.adr_ua_state_id;
       end if;

      else
        l_town_name := trim(l_pat.adr_city);
        l_state_name := trim(l_pat.adr_district);

      end if;

      --собрать полный адрес
      l_result := l_pat.adr_country||', ';

      if(l_state_name is not null)then
       l_result := l_result||l_state_name||' область, ';
      end if;

      if(l_town_name is not null)then
       l_result := l_result||l_town_name||', ';
      end if;

      if(l_pat.adr_street is not null) then
       l_result := l_result||l_pat.adr_street||' ';
      end if;

      if(l_pat.adr_house is not null) then
       l_result := l_result||l_pat.adr_house;
      end if;

      if(l_pat.adr_flat is not null) then
       l_result := l_result||'-'||l_pat.adr_flat;
      end if;

     return l_result;

    end get_full_address_ukr;
---------------------------------

  function get_fio(p_patient_id number) return varchar2
    is
     l_pat patient%rowtype;
--     l_result varchar2(1024);

    begin
       select p.* into l_pat from patient p
       where p.id = p_patient_id;

      return l_pat.name||' '||l_pat.first_name||' '||l_pat.second_name;
    end get_fio;

---------------------------------



begin
  -- Initialization
  null;
end rep_utl;
/

