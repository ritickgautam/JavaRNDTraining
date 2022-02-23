Create PhoneBook( with fields id, name, phoneNumber, dob, having console based input /output feature.

 

1.      Create login.json file and then authenticate user by reading login.json file using Stream API.

 

Id

firstame

lastname

email

mobile

loginName

password

status

role

1

John

Doe

j@gmail.com

9826912345

john123

john@123

active

admin

2

Rose

Tailor

r@gmail.com

9826965478

rose123

rose@123

decative

user

3

Virat

Kohali

v@gmail.com

7894561231

virat123

virat@123

active

user

 

2.      If user is admin than only he will be able to delete record.

3.      Use Java 8 Date API for dob(date of birth).

4.      Use functional interface with lamda expression whereas applicable.

5.      Add new PhoneBook entry.(Prevent duplicate entries for phone numbers)

6.      Search  by id, name,phoneNumber,dob

7.      Update PhoneBook

8.      Delete PhoneBook .

9.      List all the entries

10.  Quit.                                

 

If duplicate name is added than raise a DuplicateNameException, also if same number is added with two people than it raise a DuplicateNumberException.

 

 

Note:-

 

1.      Follow proper project structure.

2.      Use different package for Domain, DAO, Service classes.

3.      Use Proper Naming convention.

4.      Use proper collection for implementing DAO(don’t use DB  for storing/retrieving  data)