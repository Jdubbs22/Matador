
 insert into member(id,email,first_name,last_name,phone_number)
 values(1,"test1@gmail.com","ted","smith","123456789"),
 (2,"test2@gmail.com","fred","smith","123456123"),
 (3,"test3@gmail.com","john ","smith","789456789"),
 (4,"test4@gmail.com","carl","lee","123123789"),
 (5,"test5@gmail.com","janet","lee","987654321");

 insert into instructor(instructor_id, description, member_id)
  values (2, "specialize in muay thai", 2),
  (1, "specialize in boxing", 1)
  ;


insert into lesson(id, start_time, end_time, status,  instructor_id)
values
( 4, now(), now(), "open", 2),
( 2, now(), now(), "open", 2),
( 3, now(), now(), "open", 1)
;
