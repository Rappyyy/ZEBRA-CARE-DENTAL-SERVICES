# [team name] Design Document

## Instructions

*Save a copy of this template for your team in the same folder that contains
this template.*

*Replace italicized text (including this text!) with details of the design you
are proposing for your team project. (Your replacement text shouldn't be in
italics)*

*You should take a look at the example design document in the same folder as
this template for more guidance on the types of information to capture, and the
level of detail to aim for.*

## *Project Title* Design

## 1. Problem Statement

*Explain clearly what problem you are trying to solve.*

This design document highlights the significance of Zebra Care Dental Services,
a dental clinic appointment application that offers a range of dental services.
Our application is tailored to meet the diverse needs of our customers, providing a seamless experience for scheduling 
dental appointments. With our user-friendly interface, customers can easily choose their preferred date and time and 
specific dental services they require.


## 2. Top Questions to Resolve in Review

*List the most important questions you have about your design, or things that
you are still debating internally that you might like help working through.*

1. How many and what are the models we're going to use.

## 3. Use Cases

*This is where we work backwards from the customer and define what our customers
would like to do (and why). You may also include use cases for yourselves, or
for the organization providing the product to customers.*

U1. As a  customer, I want to create an appointment with given services.

U2. As a customer, I want to create, view, update and remove my appointment.
    
U3. As a dentist, I want to open my portal and see my schedules.

## 4. Project Scope

*Clarify which parts of the problem you intend to solve. It helps reviewers know
what questions to ask to make sure you are solving for what you say and stops
discussions from getting sidetracked by aspects you do not intend to handle in
your design.*

### 4.1. In Scope

*Which parts of the problem defined in Sections 1 and 3 will you solve with this
design?*

* Creating, retrieving and updating appointments
* Check status of appointments for customer and dentist


### 4.2. Out of Scope

*Based on your problem description in Sections 1 and 3, are there any aspects
you are not planning to solve? Do potential expansions or related problems occur
to you that you want to explicitly say you are not worrying about now? Feel free
to put anything here that you think your team can't accomplish in the unit, but
would love to do with more time.*

* The ability to provide a reminder before appointment starts.
* Being able to provide different payment methods. 
* Being able to provide clinics available base on your location

# 5. Proposed Architecture Overview

*Describe broadly how you are proposing to solve for the requirements you
described in Section 3.*

*This may include class diagram(s) showing what components you are planning to
build.*

*You should argue why this architecture (organization of components) is
reasonable. That is, why it represents a good data flow and a good separation of
concerns. Where applicable, argue why this architecture satisfies the stated
requirements.*

This initial iteration will provide the minimum lovable product (MLP) including
creating, retrieving, and updating an appointment.

We will use API Gateway and Lambda to create five endpoints (`CreateAppointment`,
 `UpdateAppointment`, `GetAppointment`)
that will handle the creation, update, and retrieval of appointments to satisfy our
requirements.

We will store all the appointments in a table in DynamoDB. For simpler schedule retrieval.

Zebra Care Dental Services will also provide a web interface for users to manage
their appointments. A main page providing a list view of all of their appointments that
will let them create, update and check the status of their schedules.


# 6. API

## 6.1. Public Models

*Define the data models your service will expose in its responses via your
*`-Model`* package. These will be equivalent to the *`PlaylistModel`* and
*`SongModel`* from the Unit 3 project.*


// PatientModel

String patientId;
String patientName;
String contactInfo;
String address;

// AppointmentModel

 String appointmentId;
 LocalDateTime startTime;
 LocalDateTime endTime;
 String patientName;
 String patientId;
 String dentistName;
 String description;
 String service;
 List<Appointment> appointmentList;
  

// DentistModel

String id;
String name;
String position;
List<Weekday> availability;
int contactNumber;

## 6.2. *Get Appointment Endpoint*

*Describe the behavior of the first endpoint you will build into your service
API. This should include what data it requires, what data it returns, and how it
will handle any known failure cases. You should also include a sequence diagram
showing how a user interaction goes from user to website to service to database,
and back. This first endpoint can serve as a template for subsequent endpoints.
(If there is a significant difference on a subsequent endpoint, review that with
your team before building it!)*

*(You should have a separate section for each of the endpoints you are expecting
to build...)*

## 6.3 *Create Appointment Endpoint*

*(repeat, but you can use shorthand here, indicating what is different, likely
primarily the data in/out and error conditions. If the sequence diagram is
nearly identical, you can say in a few words how it is the same/different from
the first endpoint)*

## 6.4 *Update Appointment Endpoint*

*(repeat, but you can use shorthand here, indicating what is different, likely
primarily the data in/out and error conditions. If the sequence diagram is
nearly identical, you can say in a few words how it is the same/different from
the first endpoint)*

# 7. Tables

### 7.1. `Appointments`

```
appointmentId // partition key, string
startTime // LocalDateTime
endTime // LocalDateTime
patientName // string
patientId // string
dentistName // string
description // string
service // string
appointmentList // List <Appointment>

```

### 7.2. `Dentists`
```
id // partition key, string
name // string
position // string
contactNumber // string
availability // List<Weekday>

```
### 7.3. `Patients`
```
patientId // partition key, string
patientName // string
contactInfo // string 
address // string
```



*Define the DynamoDB tables you will need for the data your service will use. It
may be helpful to first think of what objects your service will need, then
translate that to a table structure, like with the *`Playlist` POJO* versus the
`playlists` table in the Unit 3 project.*

# 8. Pages

*Include mock-ups of the web pages you expect to build. These can be as
sophisticated as mockups/wireframes using drawing software, or as simple as
hand-drawn pictures that represent the key customer-facing components of the
pages. It should be clear what the interactions will be on the page, especially
where customers enter and submit data. You may want to accompany the mockups
with some description of behaviors of the page (e.g. “When customer submits the
submit-dog-photo button, the customer is sent to the doggie detail page”)*
