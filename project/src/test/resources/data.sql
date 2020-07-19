insert into user_model (hash_password, mail, role, state,email_is_confirmed)
VALUES ('password', 'mail@mail.ru', 'ADMIN', 'CONFIRMED',true);
insert into admin (id)
values (1);
insert into user_model(hash_password, mail, role, state,email_is_confirmed) VALUES ('password1','student@mail.com','STUDENT','CONFIRMED',true);
insert into student(competence, competence_state, course, group_number, name, patronymic, surname, id)
VALUES ('im best','CONFIRMED',2,802,'Aydar','Rashidovich','Shaydullin',2);
insert into user_model(hash_password, mail, role, state,email_is_confirmed) VALUES ('pass2','teacher@mail.ru','TEACHER','CONFIRMED',true);
insert into teacher( name, patronymic, position_held, surname, id)
VALUES ('Marat','Mirzayevich','Arslanov','dozent',3);
insert into user_model(hash_password, mail, role, state,email_is_confirmed) VALUES ('password1','employer@mail.com','EMPLOYER','CONFIRMED',true);
insert into employer(company_name, phone_number, id) VALUES ('mail ru gr','880055536',4);

