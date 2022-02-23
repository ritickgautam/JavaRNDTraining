Develop Rest API using Spring Boot  and apply  OAUTH 2.0 for authentication.

  Note:-

1.      Use Postman for using APIs

2.      Request and response should have JSON data.

3.      Follow the rest call rules

4.      Use Java Naming Standards.

5.      Use JDK8(Optional)

6.      Please also add Your APIs description in following format.

 

Module Name

Name of APIs

Description of APIs

Input

Output

 

 

 

 

 

 

Library Management System

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

 
Business Requirement

 

We will develop a small sample application to track our personal library of books.

It will also include a list of people to whom we loan our books.

Our application should handle the information of books and users and issue return of the books user wise.

The application will have following entities: 

1.       Book [id,title,year,isbn,available(number of books)]

2.       Author [id,name].

3.       User [id,name,userName,password,email, expiray date,

4.       Publisher [id,name].

5.       Fine [paymentDate, amount]  

 Functional Requirements

 

 Your Library should perform the following operations:

       1.       Add/Edit/Delete books(admin Right)

2.       Add/Edit/Delete user (admin Right)

3.       Issue/ Return books and pay fine if applicable (Also mention the expiry date)

 