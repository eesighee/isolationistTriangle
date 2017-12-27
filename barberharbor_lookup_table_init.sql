insert into user_roles (user_roles_id, role) values (1, 'User');
insert into user_roles (user_roles_id, role) values (2, 'Barber');
insert into user_roles (user_roles_id, role) values (3, 'Admin');

insert into appointment_status (status_id, status) values (1, 'Pending');
insert into appointment_status (status_id, status) values (2, 'Completed');
insert into appointment_status (status_id, status) values (3, 'Cancelled');

insert into service_types (service_types_id, type) values (1, 'Haircut');
insert into service_types (service_types_id, type) values (2, 'Shave');
insert into service_types (service_types_id, type) values (3, 'Shampoo');
insert into service_types (service_types_id, type) values (4, 'Fade');
insert into service_types (service_types_id, type) values (5, 'Edgeups');
insert into service_types (service_types_id, type) values (6, 'Beard Trim');
insert into service_types (service_types_id, type) values (7, 'Waxing');
insert into service_types (service_types_id, type) values (8, 'Other');

commit;
