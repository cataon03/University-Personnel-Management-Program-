# University Personnel Management Program

## Description
This project involves implementing a simple university personnel management program. The program contains three kinds of objects: `Staff`, `Student`, and `Faculty`. Each object stores relevant information such as university ID, name, etc. The main goals of this project are to demonstrate the use of inheritance, abstract classes, abstract methods, and method overriding.

## Project Structure
Your project should be structured with the following classes and interfaces:

1. `Person` (abstract class)
2. `Student` (inherits from `Person`)
3. `Employee` (abstract class, inherits from `Person`)
4. `Faculty` (inherits from `Employee`)
5. `Staff` (inherits from `Employee`)

The project should include the following functionalities:
- Enter the information of a `Student`, `Faculty`, or `Staff`.
- Print tuition invoice for a `Student`.
- Print information for a `Faculty` or `Staff`.
- Delete a person by ID.
- Save a report of all personnel data to a text file, sorted by either GPA or name.

## Implementation Details

### Classes

#### Person (abstract class)
- `String fullName`
- `String id`
- `public abstract void print()`

#### Student
- `String fullName`
- `String id`
- `double gpa`
- `int creditHours`
- `public void print()`
- `public double calculateTuition()`

#### Employee (abstract class)
- `String fullName`
- `String id`
- `String department`

#### Faculty
- `String fullName`
- `String id`
- `String department`
- `String rank`
- `public void print()`

#### Staff
- `String fullName`
- `String id`
- `String department`
- `String status`
- `public void print()`

### Inheritance Hierarchy
```plaintext
Person
├── Student
├── Employee
│   ├── Faculty
│   └── Staff
```

## Usage Instructions

### Compilation and Execution
- javac FinalProject.java
- java FinalProject

### Sample Run
Welcome to my Personal Management Program
Choose one of the options:
1- Enter the information of a faculty
2- Enter the information of a student
3- Print tuition invoice for a student
4- Print faculty information
5- Enter the information of a staff member
6- Print the information of a staff member
7- Delete a person
8- Exit Program
...

### Sample Report (report.txt)
Report created on [Date]
***********************
Faculty Members
-------------------------
1. John Miller
   ID: jo7894
   Professor, Engineering

Staff Members
-------------------
1. Jamal Kareem
   ID: ja6980
   English, Full Time

Students (Sorted by gpa in descending order)
-------------------
1. Julia Alvarez
   ID: ju1254
   Gpa: 3.26
   Credit hours: 7
2. Matt Jones
   ID: ma0258
   Gpa: 2.78
   Credit hours: 0








