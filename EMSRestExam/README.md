# JavaRNDTraining

Rest Exam

Technical Requirement (Rest API)
1.      Design REST APIs optimally
Use nouns instead of verbs in the endpoint paths, which represent entities/resources to fetch or manipulate and use consistently plural nouns such as /orders/{id}/products over /order/{id}/product.
The operation must be represented by the HTTP request, GET retrieves resources. POST creates a new data record. PUT updates existing data. DELETE removes data
Nesting resources for hierarchical objects
Provide filtering, sorting, and pagination
Consider API Versioning
APIs should be fully documented.
 

Module Name

Name of APIs

Description of APIs

Input

Output

 

 

 

 

 

2.      Use Data Transfer Objects (DTOs)
3.     Leverage java bean validation
4.      Use global/custom errors handler
 
Technical Requirement (Hibernate)
1.      Use a projection that fits your use case

2.      Log and analyze all queries during development

3.      Do not use FetchType.EAGER

4.      Initialize required lazy relationships with the initial query

5.      Avoid cascade remove for huge relationships

6.      Use second-level-cache into your application.

 

 

Enquiry Management System (EMS)

 

Problem Definition:

Enquiry Management System (EMS) is an online system to handle daily students Enquiry for listed courses. 

Nowadays EMS is a common need of an institution who would like to handle daily Enquiries of students, about the courses offered.

So that latter on they can plan to send SMS, Email and do the proper follow-ups. 

Here we want you to develop an Enquiry Handling module, which will track daily Enquiry handled by per authenticate user.

This module should allow one login entry point, where all users can login, and after that Enquiry handling form will be displayed, where user can enter Enquiry information, and just below that total enquiry should be displayed in tabular format.

 

Business Requirement

1.       System should have User as well as Student Enquiry support user wise.

2.       There should not be prefilled data in tables.

3.       System should have support for options like

a.       User Login

b.       User Registration

c.       Add Enquiry

d.       Edit Enquiry

e.       Delete Enquiry

f.        Show today’s Enquiry

g.       Searching by name

4.       You need to create proper tables with proper names and have proper relationship

5.       Design the flow of application and send along with source code