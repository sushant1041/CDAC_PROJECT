Project: Clinic Management System 🏥
This is a Spring Boot-based Clinic Management System that helps manage patients and appointments efficiently. It provides APIs for user authentication, appointment booking, and patient record management.

📌 Features of the Project
✅ User Authentication (Signup & Login)
✅ Patient Management (View, Add, Delete Patients)
✅ Appointment Booking (Schedule & View Appointments)
✅ RESTful API for front-end integration (e.g., React, Angular)
✅ Database Integration using MySQL
✅ Spring Boot + JPA for database operations


📌 Technologies Used
Spring Boot – Backend framework
Spring Data JPA – ORM for database
MySQL – Database for storing patients & appointments
Spring Security (Basic Authentication) – For login
Lombok – Reduces boilerplate code
Postman – API testing tool


📌 Explanation of Key Components
1️⃣ Controllers (API Endpoints)
AppointmentController – Manages appointments (CRUD operations)
AuthController – Handles user login and authentication
PatientController – Manages patient records
2️⃣ Entities (Database Tables)
Patient – Stores patient details
Appointment – Stores appointment details
3️⃣ DTO (Data Transfer Object)
AppointmentRequest – Handles appointment booking requests
4️⃣ Repositories (Database Operations)
PatientRepository – Queries for patient data
AppointmentRepository – Queries for appointment data
5️⃣ Services (Business Logic)
PatientService – Handles patient operations
AppointmentService – Handles appointment operations


📌 How the Project Works?
1️⃣ Patient Registration: Users register with their name, email, password
2️⃣ Login Authentication: Users log in using email & password
3️⃣ Book Appointment: Patients schedule an appointment
4️⃣ View Appointments: Fetch all scheduled appointments
5️⃣ Manage Patients: Admins can view, delete, and search patients

📌 Example API Endpoints
🔹 Authentication
🔹 POST /api/auth/login → User login

🔹 Patient Management
🔹 GET /api/patients → Get all patients
🔹 POST /api/patients/signup → Register new patient
🔹 GET /api/patients/{id} → Get patient by ID

🔹 Appointment Management
🔹 GET /api/appointments → Get all appointments
🔹 POST /api/appointments → Book new appointment
🔹 DELETE /api/appointments/{id} → Cancel appointment

📌 Future Enhancements
🚀 JWT Authentication instead of a dummy token
🚀 Role-based access control (Admin, Doctor, Patient)
🚀 Email Notifications for Appointments
