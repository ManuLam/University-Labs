CREATE TABLE cs_lab5(
car_id SERIAL NOT NULL,
car_registration VARCHAR(16) NOT NULL,
direction VARCHAR(12) NOT NULL,
vehicle_occupants INTEGER NOT NULL,
entrance_time TIMESTAMP NOT NULL,
exit_time TIMESTAMP NOT NULL,
CONSTRAINT complaintsDatabase_pkey
PRIMARY KEY(car_id) 
)

INSERT INTO cs_lab5
(car_registration, direction, vehicle_occupants, entrance_time,exit_time)
VALUES
('171-KE-2098','Eastbound',3,'2017-01-01 15:15:30','2017-01-01 15:17:50');

INSERT INTO cs_lab5
(car_registration, direction, vehicle_occupants, entrance_time,exit_time)
VALUES
('161-CD-987','Westbound',1,'2017-02-13 04:30:20','2017-02-13 04:31:40');

INSERT INTO cs_lab5
(car_registration, direction, vehicle_occupants, entrance_time,exit_time)
VALUES
('J19-CS130','Eastbound',4,'2017-05-31 18:00:00','2017-05-31 18:02:40');

INSERT INTO cs_lab5
(car_registration, direction, vehicle_occupants, entrance_time,exit_time)
VALUES
('12-WD-1767','Westbound',2,'2017-05-07 07:40:10','2017-05-07 07:41:50');