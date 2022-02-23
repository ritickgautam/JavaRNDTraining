Develop Spring Boot application with the given scenario.

 

Technical Requirement

1.      Use SpringBoot Data property for inject db configuration.

2.      Change SpringBoot embedded server port with 7070.

3.      Change Context Path of Application via property file.

4.      Create an API Doc containing all the API’s related to project.

5.      Spring Rest Exception handling is mandatory which return error in JSON form.

6.      Apply Functional interface an Lambda expression

7.      Please also add Your APIs description in following format.

 

 

Car Rental System

 

 

Functional Requirements

Our System is designed so as to be used by Car Rental Company specializing in renting cars to customers. It is an online system through which customers can view available cars, register, view profile and book car.

 

Online Vehicle Reservation: A tools through which customers can reserve available cars online prior to their expected pick-up date or time. 

 

1.      Car can be booked for daily, weekly and monthly basis.

2.      Car will be booked on the basis of Car and type (Example. Safari, AC or non AC,)

3.      As per the car and car type charges will be applied.

4.      Charges will be for per KM.

 

Customer’s registration: A registration portal to hold customer’s details, monitor their· transaction and used same to offer better and improve services to them.

 

1.      Our System should be able to hold the customer information such as id, name, contact, address etc.

2.      Customer should be able to pay in various mode like. using card payment, Direct payment

 

 Group bookings: Allows the customer to book space for a group in the case of· weddings or corporate meetings (Event management). (Optional)

 

Functions of Customer:

1.      New Registration

2.      Login Request

3.      Registration Confirmation by the System

4.      Reserve Car

5.      Car Issued by the System

 

Functions of Car Rental Company: 

1.      Add |Edit| Delete Customer

2.      Add |Edit| Delete Car(AC | Non-AC with rates)

3.      Show the Available Cars with status(Booked  | Available)

4.      View Transaction reports

5.      Block a customer, whom we do not want to book car next time.

6.      Show the list of customers, and car booked along with duration

 

Technology Requirements:

Spring:-

1.      Do not use Spring’s XML Bean definition support.

2.      Use Spring's Java configuration.

3.      Do not use entire classpath scanning.

4.      Do not use Spring inside your domain classes. .

5.      Use  things like @Autowired in Spring-specific classes.

Hibernate

1.      Use a projection that fits your use case

2.      Log and analyze all queries during development

3.      Do not use FetchType.EAGER

4.      Initialize required lazy relationships with the initial query

5.      Avoid cascade remove for huge relationships

6.      Use second-level-cache into your application.