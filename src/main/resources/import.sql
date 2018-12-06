INSERT INTO aircraft (id, type,location_id, reg_number ) VALUES (1,'Boeing 737',1,'FL-0001'),(2,'Airbus 321 ',2,'FL-0002'),(3,'Boeing 747-400',3,'FL-0003'),(4,'Airbus A320',4,'FL-0004');


INSERT INTO airport ( id, name, code, location ) VALUES (1,'Tegel','TXL','Berlin'),(2,'Franz Josef Strauss','MUC','Munich'),(3,'Heathrow','LHR','London'),(4,'Helmut Schmidt','HAM','Hamburg');



INSERT INTO flight_schedule (id, origin_id, destination_id, departure_time, duration ) VALUES (1,1,2, STR_TO_DATE('4/13/2018 10:00:00', '%c/%e/%Y %H:%i:%s'), STR_TO_DATE('4/13/2018 11:00:00', '%c/%e/%Y %H:%i:%s'));
INSERT INTO flight_schedule (id, origin_id, destination_id, departure_time, duration ) VALUES (2,1,2, STR_TO_DATE('4/13/2018 15:00:00', '%c/%e/%Y %H:%i:%s'), STR_TO_DATE('4/13/2018 16:00:00', '%c/%e/%Y %H:%i:%s'));
INSERT INTO flight_schedule (id, origin_id, destination_id, departure_time, duration ) VALUES (3,1,2, STR_TO_DATE('4/13/2018 16:00:00', '%c/%e/%Y %H:%i:%s'), STR_TO_DATE('4/13/2018 17:00:00', '%c/%e/%Y %H:%i:%s'));
INSERT INTO flight_schedule (id, origin_id, destination_id, departure_time, duration ) VALUES (4,1,2,  STR_TO_DATE('4/13/2018 18:00:00', '%c/%e/%Y %H:%i:%s'), STR_TO_DATE('4/13/2018 19:00:00', '%c/%e/%Y %H:%i:%s'));
INSERT INTO flight_schedule (id, origin_id, destination_id, departure_time, duration ) VALUES (5,1,4,  STR_TO_DATE('4/13/2018 21:00:00', '%c/%e/%Y %H:%i:%s'), STR_TO_DATE('4/13/2018 21:40:00', '%c/%e/%Y %H:%i:%s'));
INSERT INTO flight_schedule (id, origin_id, destination_id, departure_time, duration ) VALUES (6,2,3,STR_TO_DATE('4/13/2018 10:00:00', '%c/%e/%Y %H:%i:%s'), STR_TO_DATE('4/13/2018 11:00:00', '%c/%e/%Y %H:%i:%s'));
INSERT INTO flight_schedule (id, origin_id, destination_id, departure_time, duration ) VALUES (7,2,1,STR_TO_DATE('4/13/2018 13:00:00', '%c/%e/%Y %H:%i:%s'), STR_TO_DATE('4/13/2018 14:00:00', '%c/%e/%Y %H:%i:%s'));
INSERT INTO flight_schedule (id, origin_id, destination_id, departure_time, duration ) VALUES (8,2,1,STR_TO_DATE('4/13/2018 15:00:00', '%c/%e/%Y %H:%i:%s'), STR_TO_DATE('4/13/2018 16:00:00', '%c/%e/%Y %H:%i:%s'));
INSERT INTO flight_schedule (id, origin_id, destination_id, departure_time, duration ) VALUES (9,2,3,STR_TO_DATE('4/13/2018 15:30:00', '%c/%e/%Y %H:%i:%s'), STR_TO_DATE('4/13/2018 16:30:00', '%c/%e/%Y %H:%i:%s'));
INSERT INTO flight_schedule (id, origin_id, destination_id, departure_time, duration ) VALUES (10,2,4,STR_TO_DATE('4/13/2018 17:30:00', '%c/%e/%Y %H:%i:%s'), STR_TO_DATE('4/13/2018 18:30:00', '%c/%e/%Y %H:%i:%s'));
INSERT INTO flight_schedule (id, origin_id, destination_id, departure_time, duration ) VALUES (11,2,3,STR_TO_DATE('4/13/2018 18:00:00', '%c/%e/%Y %H:%i:%s'), STR_TO_DATE('4/13/2018 19:30:00', '%c/%e/%Y %H:%i:%s'));
INSERT INTO flight_schedule (id, origin_id, destination_id, departure_time, duration ) VALUES (12,2,3,STR_TO_DATE('4/13/2018 20:00:00', '%c/%e/%Y %H:%i:%s'), STR_TO_DATE('4/13/2018 21:00:00', '%c/%e/%Y %H:%i:%s') );
INSERT INTO flight_schedule (id, origin_id, destination_id, departure_time, duration ) VALUES (13,2,1,STR_TO_DATE('4/13/2018 22:00:00', '%c/%e/%Y %H:%i:%s'), STR_TO_DATE('4/13/2018 23:00:00', '%c/%e/%Y %H:%i:%s') );
INSERT INTO flight_schedule (id, origin_id, destination_id, departure_time, duration ) VALUES (15,3,4,STR_TO_DATE('4/13/2018 09:00:00', '%c/%e/%Y %H:%i:%s'), STR_TO_DATE('4/13/2018 12:30:00', '%c/%e/%Y %H:%i:%s') );
INSERT INTO flight_schedule (id, origin_id, destination_id, departure_time, duration ) VALUES (16,3,1,STR_TO_DATE('4/13/2018 12:00:00', '%c/%e/%Y %H:%i:%s'), STR_TO_DATE('4/13/2018 15:00:00', '%c/%e/%Y %H:%i:%s') );
INSERT INTO flight_schedule (id, origin_id, destination_id, departure_time, duration ) VALUES (17,3,1,STR_TO_DATE('4/13/2018 17:00:00', '%c/%e/%Y %H:%i:%s'), STR_TO_DATE('4/13/2018 20:00:00', '%c/%e/%Y %H:%i:%s') );
INSERT INTO flight_schedule (id, origin_id, destination_id, departure_time, duration ) VALUES (18,3,2,STR_TO_DATE('4/13/2018 20:30:00', '%c/%e/%Y %H:%i:%s'), STR_TO_DATE('4/13/2018 23:30:00', '%c/%e/%Y %H:%i:%s') );
INSERT INTO flight_schedule (id, origin_id, destination_id, departure_time, duration ) VALUES (19,4,2,STR_TO_DATE('4/13/2018 10:00:00', '%c/%e/%Y %H:%i:%s'), STR_TO_DATE('4/13/2018 11:00:00', '%c/%e/%Y %H:%i:%s') );
INSERT INTO flight_schedule (id, origin_id, destination_id, departure_time, duration ) VALUES (20,4,2,STR_TO_DATE('4/13/2018 13:00:00', '%c/%e/%Y %H:%i:%s'), STR_TO_DATE('4/13/2018 14:00:00', '%c/%e/%Y %H:%i:%s') );
INSERT INTO flight_schedule (id, origin_id, destination_id, departure_time, duration ) VALUES (21,4,2,STR_TO_DATE('4/13/2018 20:00:00', '%c/%e/%Y %H:%i:%s'), STR_TO_DATE('4/13/2018 21:00:00', '%c/%e/%Y %H:%i:%s') );