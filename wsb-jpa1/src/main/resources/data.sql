insert into address (id, address_line1, address_line2, city, postal_code)
            values (1, 'xx', 'yy', 'city', '62-030'),
                   (2, '456 Oak St', 'Suite 2', 'Shelbyville', '67890');
INSERT INTO PATIENT (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, created_at)
VALUES (1, 'Jane', 'Smith', '987-654-3210', 'janesmith@example.com', 'PAT456', '1980-04-23', '2024-04-17'),
       (2, 'Bob', 'Brown', '654-987-3210', 'bobb@example.com', 'PAT789', '1992-08-15', '2024-04-17');
INSERT INTO DOCTOR (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
VALUES (1, 'John', 'Doe', '123-456-7890', 'johndoe@example.com', 'DOC123', 'SURGEON'),
       (2, 'Alice', 'Johnson', '321-654-0987', 'alicej@example.com', 'DOC456', 'SURGEON');
INSERT INTO VISIT (id, description, time, doctor_id, patient_id)
VALUES (1, 'Annual Checkup', '2023-10-04 14:00:00', 1, 1),
       (2, 'Routine Vaccination', '2023-10-05 09:30:00', 2, 2);
