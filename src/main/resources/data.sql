INSERT INTO patient (first_name, gender, birth_date, email, blood_group)
VALUES
    ('Sahil', 'Male', '2000-05-02', 'sahil@gmail.com', 'O_POSITIVE'),
    ('Ram','Male','200-04-01','ram@gmail.com','O_NEGATIVE'),
    ('Sham','Male','200-04-04','sham@gmail.com','O_POSITIVE'),
    ('ajay','Male','200-08-05','ajay@gmail.com','O_NEGATIVE');


INSERT INTO doctor (name, spacialization, email)
VALUES
    ('Dr.Ajay', 'Cardiology', 'Ajay@gmail.com'),
    ('Dr.Rahul', 'Neurology', 'rahul@gmail.com'),
    ('Dr.Priya', 'Dermatology', 'priya@gmail.com'),
    ('Dr.Sneha', 'Orthopedic', 'sneha@gmail.com');

INSERT INTO appointment (appointment_time, reason, doctor_id, patient_id)
VALUES
    ('2025-07-01 10:30:00', 'General Checkup', 1, 2),
    ('2025-07-02 11:00:00', 'Skin Rash', 2, 2),
    ('2025-07-03 09:45:00', 'Knee Pain', 3, 3),
    ('2025-07-04 14:00:00', 'Follow-up Visit', 1, 1);


INSERT INTO users(username,email,password,role)
VALUES
    ('admin',
     'admin@gmail.com',
     'admin123',
     'ADMIN');