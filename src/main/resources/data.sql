insert into person(id,name,location,birth_date) values(100,'bashar','Amman',sysdate());
insert into person(id,name,location,birth_date) values(101,'Ahmad','Amman',sysdate());
insert into person(id,name,location,birth_date) values(102,'Yaman','Amman',sysdate());




//insert into course_details(id,name) values(10001L,'JPA in 50 steps');
//insert into course_details(id,name) values(10002L,'Spring in 150 steps');
//insert into course_details(id,name) values(10003L,'Java in 10 steps');






//insert into course(id,FULLNAME) values(10001L,'JPA in 50 steps');
//insert into course(id,FULLNAME) values(10002L,'Spring in 150 steps');
//insert into course(id,FULLNAME) values(10003L,'Java in 10 steps');

//insert into course(id,name) values(10001L,'JPA in 50 steps');
//insert into course(id,name) values(10002L,'Spring in 150 steps');
//insert into course(id,name) values(10003L,'Java in 10 steps');



insert into course(id,name,create_date,last_update_date) 
values(10001L,'JPA in 50 steps', sysdate(), sysdate());
insert into course(id,name,create_date,last_update_date) 
values(10002L,'Spring in 100 steps',sysdate(), sysdate());
insert into course(id,name,create_date,last_update_date) 
values(10003L,'Java in 10 steps',sysdate(), sysdate());

insert into passport(id,number)
values(40001,'B123456');
insert into passport(id,number)
values(40002,'Y123456');
insert into passport(id,number)
values(40003,'A123456');
// if you put the table  passport after student , an issues will happen
// select * from student , passport  where student.passport_id = passport.id
// Passport_ID is foriegn ke , which is id of another table or the primary key of passport key , and use it forign key in student table

insert into student(id,name,PASSPORT_ID)
values(20001,'bashar',40001);
insert into student(id,name,PASSPORT_ID)
values(20002,'Yaman',40002);
insert into student(id,name,PASSPORT_ID)
values(20003,'Ahmad',40003);



insert into Review(id,rating,description)
values(50001,'5','Great Course');

insert into Review(id,rating,description)
values(50002,'4','Wonderfull Course');

insert into Review(id,rating,description)
values(50003,'4','Awesome Course');

