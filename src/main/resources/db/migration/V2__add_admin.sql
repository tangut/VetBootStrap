insert into usr (id, active, password, username)
    values (0,  true,  'a',  'admin');

insert into user_role (user_id, roles)
    values (0, 'USER'), (0, 'ADMIN');