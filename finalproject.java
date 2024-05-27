/*
 - Final Project
 - Catalina Ocampo, Granit Troni, Yessenia Diaz
 */

import java.util.ArrayList;
import java.util.Scanner;
import javax.lang.model.util.ElementScanner14;
import java.util.Comparator;
import java.text.DecimalFormat;
import java.text.Format;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class finalproject {
    private static String menu(){
        
        String option = "";
		System.out.println("1- Enter the information a faculty");
		System.out.println("2- Enter the information of a student");
		System.out.println("3- Print tuition invoice for a student");
		System.out.println("4- Print faculty information");
		System.out.println("5- Enter the information of a staff member");
		System.out.println("6- Print the information of a staff member");
		System.out.println("7- Delete a person");
		System.out.println("8- Exit Program");
		System.out.print("\n\tEnter Your Selection: ");
		
        try
        {
            option = (new Scanner(System.in)).nextLine();
            int temp = Integer.parseInt(option);
            if(temp < 1|| temp > 8)
            {
                System.out.println("Invalid entry- please try again\n");
                option = menu();
            }                
        }
        catch(Exception e)
        {
            System.out.println("Youre in the exception");
            System.out.println("Invalid entry- please try again\n");
            option = menu();
        }
    
		return option;
    }
    public static void main(String[] args){
        System.out.println("\t\t\t\tWelcome to my Personal Management Program");
        System.out.println("\nChoose one of the options:\n");

        ArrayList<Person> list = new ArrayList<>();
        String selection;
        Scanner scanner = new Scanner(System.in);

        
        do{
            selection = menu();
            switch(selection){
                case "1":
                    String id1, rank1, name1, department1;
                    System.out.println("\nEnter the faculty info:\n");
                    System.out.print("\tName of the faculty: "); 
                    name1 = (new Scanner(System.in)).nextLine();
                    name1 = capitalizeName(name1);
                    
                    System.out.print("\tID: ");
                    id1 = (new Scanner(System.in)).nextLine();
                    id1 = correctID(list, id1);

                    System.out.print("\tRank: ");
                    rank1 = (new Scanner(System.in)).nextLine();
                    rank1 = correctRank(rank1);

                    System.out.print("\tDepartment: ");
                    department1 = (new Scanner(System.in)).nextLine();
                    department1 = correctDepartment(department1);
                    
                    Person p = new Faculty(name1, id1, department1, rank1);
                    list.add(p);
                    System.out.println("\n\t--*  Faculty added! *--\n\n");
                    
                    break;

                case "2":
                    String id2, name2, gpa, creditHours;
                    double gpa2;
                    int creditHours2;
                    System.out.println("\nEnter the student info:\n");
                    System.out.print("\tName of the student: ");
                    name2 = (new Scanner(System.in)).nextLine();
                    name2 = capitalizeName(name2);
                    
                    System.out.print("\tID: ");
                    id2 = (new Scanner(System.in)).nextLine();
                    id2 = correctID(list, id2);
                    
                    System.out.print("\tGPA: ");
                    gpa = (new Scanner(System.in)).nextLine();
                    gpa2 = correctGPA(gpa);
                    
                    System.out.print("\tCredit Hours: ");
                    creditHours = (new Scanner(System.in)).nextLine();
                    creditHours2 = correctCreditHours(creditHours);

                    Person p2 = new Student(name2, id2, gpa2, creditHours2);
                    list.add(p2);
                    System.out.println("\n\t--*  Student added! *--\n\n");
                    
                    break;
                    
                case "3":
                    String id3;
                    System.out.print("\n\tEnter the student's ID: ");
                    id3 = (new Scanner(System.in)).nextLine();
                    
                    boolean foundStudent = false;
                    for (Person person : list) {
                        if (person instanceof Student && person.getID().equalsIgnoreCase(id3)) {
                            foundStudent = true;
                            Student student = (Student) person;
                            student.print();
                            break;
                        }
                    }
                    
                    if(!foundStudent) {
                        System.out.println("\n\t--*  No student matched! *--\n\n");
                    }
                    break;
                    
                case "4":
                    String id4;
                    System.out.print("\n\tEnter the faculty's ID: ");
                    id4 = (new Scanner(System.in)).nextLine();
                    
                    boolean foundFaculty = false;
                    for (Person person : list) {
                        if (person instanceof Faculty && person.getID().equalsIgnoreCase(id4)) {
                            foundFaculty = true;
                            Faculty faculty = (Faculty) person;
                            faculty.print();
                            break;
                        }
                    }
                    
                    if(!foundFaculty) {
                        System.out.println("\n\t--*  No faculty matched! *--\n\n");
                    }

                    break;

                case "5":
                    System.out.println("\nEnter the Staff info: \n");
                    System.out.print("\tName of the staff member: ");
                    String name5 = scanner.nextLine();
                    name5 = capitalizeName(name5);

                    System.out.print("\tEnter the id: ");
                    String id5 = scanner.nextLine();
                    id5 = correctID(list, id5);
                        
                    System.out.print("\tDepartment: ");
                    String department5 = scanner.nextLine();
                    department5 = correctDepartment(department5);

                    System.out.print("\tStatus, Enter P for Part Time, or Enter F for Full Time: ");
                    String status5 = scanner.nextLine();
                    status5 = correctStatus(status5);
                    
                    Person p5 = new Staff(name5, id5, department5, status5);
                    list.add(p5);

                    System.out.println("\n\t--*  Staff member added! *--\n\n");
                    
                    break;
                    
                case "6":
                    String id6;
                    System.out.print("\n\tEnter the staff’s id: ");
                    id6 = (new Scanner(System.in)).nextLine();
                    
                    boolean foundStaff = false;
                    for (Person person : list) {
                        if (person instanceof Staff && person.getID().equalsIgnoreCase(id6)) {
                            foundStaff = true;
                            Staff staff = (Staff) person;
                            staff.print();
                            break;
                        }
                    }
                    
                    if(!foundStaff) {
                        System.out.println("\n\t--*  No staff matched! *--\n\n");
                    }
                    break;

                case "7":
                    System.out.print("\n\tEnter the ID of the person to delete: ");
                    String id7 = scanner.nextLine();

                    int temp = list.size();
                    
                    for(int i=0; i<list.size(); i++)
                    {
                        if((list.get(i).getID()).equals(id7))
                            list.remove(i);
                    }
                    
                    if(temp==list.size())
                        System.out.println("\n\t--*  Sorry, no such person exists. *--\n\n");
                    else    
                        System.out.println("\n\t--*  Person deleted! *--\n\n");

                    break;

                case "8":
                    String answer, searchOption;
                    int searchOption2;
                    System.out.print("\nWould you like to create the report? (Y/N): ");
                    answer = scanner.nextLine();
                    answer = correctYesorNo(answer);
                    answer = answer.toLowerCase();
                    if(answer.equals("n"))
                        break;
                    
                    System.out.print("Would you like to sort your students by descending GPA or name (1 for GPA, 2 for name): ");
                    searchOption = scanner.nextLine();
                    searchOption2 =  sortByGPAorName(searchOption);
                    

                    try {
                        ArrayList<Faculty> f = new ArrayList<>();
                        ArrayList<Student> s = new ArrayList<>();
                        ArrayList<Staff> st = new ArrayList<>();
                        int count = 1;

                        for(int i=0; i<list.size(); i++)
                        {
                            if(list.get(i) instanceof Faculty)
                                f.add((Faculty)list.get(i));
                            else if(list.get(i) instanceof Student)
                                s.add((Student)list.get(i));
                            else
                                st.add((Staff)list.get(i));  
                        }

                        if(searchOption2==1)
                            s.sort(new SortByGPA());
                        else if(searchOption2==2)
                            s.sort(new SortByName());
                       
                        FileWriter myWriter = new FileWriter("report.txt");                    
                        Format form = new SimpleDateFormat("MM/dd/yyyy");
                        String strDate = form.format(new Date());

                        myWriter.write("\t\tReport created on " + strDate);
                        myWriter.write("\n\t\t****************************");
                        myWriter.write("\n\nFaculty Members");
                        myWriter.write("\n-------------------------\n");
                        for(int i=0; i<f.size(); i++)
                        {
                            myWriter.write("\t" + (i+1) +". " + f.get(i).getfullName());
                            myWriter.write("\n\tID: " + f.get(i).getID());
                            myWriter.write("\n\t" + f.get(i).getRank() + ", " + f.get(i).getDepartment() + "\n");
                        }

                        myWriter.write("\n\nStaff Members");
                        myWriter.write("\n-------------------------\n");
                        for(int i=0; i<st.size(); i++)
                        {
                            myWriter.write("\t" + (i+1) +". " + st.get(i).getfullName());
                            myWriter.write("\n\t\tID: " + st.get(i).getID());
                            myWriter.write("\n\t\t" + st.get(i).getDepartment() + ", " + st.get(i).getStatus() + "\n");
                        }

                        myWriter.write("\n\nStudents");
                        myWriter.write("\n-------------------------\n");
                        for(int i=0; i<s.size(); i++)
                        {
                            myWriter.write("\t" + (i+1) +". " + s.get(i).getfullName());
                            myWriter.write("\n\t\tID: " + s.get(i).getID());
                            myWriter.write("\n\t\tGpa: " + s.get(i).getGpa());
                            myWriter.write("\n\t\tCredit Hours: "+ s.get(i).getCreditHours() + "\n");
                        }
                        
                        myWriter.close();
                        System.out.println("\n\t--*  Report created and saved on your hard drive! *--");
                      } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                      }

                    break;
                
                default:
                    System.out.println("\n\t\tInvalid entry - please try again\n");
            }

        }while(!selection.equals("8"));

        System.out.println("\t\t--*  Goodbye! *--\n");

    }
    


    
    public static String capitalizeName(String name){

        try{
            String [] firstLastName = name.split(" ");

            String firstName = firstLastName[0].substring(0,1).toUpperCase() + firstLastName[0].substring(1);
            String lastName = firstLastName[1].substring(0,1).toUpperCase() + firstLastName[1].substring(1);

            return firstName + " " + lastName;

        }catch(Exception e1){
            System.out.println("\t\tInvalid name format. Enter a full name.\n");
            //scanner = new Scanner(System.in);
            System.out.print("\tName: ");
            name = (new Scanner(System.in)).nextLine();
            name = capitalizeName(name);
        }

        return name;
    }
          
    public static String correctID(ArrayList<Person> p, String id)
    {
      
        for(int i=0; i<p.size(); i++)
        {
            if(p.get(i).getID().equals(id))
            {
                System.out.println("\t\tInvalid ID. This ID already exists.\n");
                System.out.print("\tID: ");
                id = (new Scanner(System.in)).nextLine();
                return correctID(p,id);
            }
        }
      
        if(id.length() != 6) {
            System.out.println("\t\tInvalid ID Format. Must be LetterLetterDigitDigitDigitDigit\n");
            System.out.print("\tID: ");
            id = (new Scanner(System.in)).nextLine();
            id = correctID(p,id);
        }
        else if (!Character.isLetter(id.charAt(0)) || !Character.isLetter(id.charAt(1))) {
            System.out.println("\t\tInvalid ID Format. Must be LetterLetterDigitDigitDigitDigit\n");
            System.out.print("\tID: ");
            id = (new Scanner(System.in)).nextLine();
            id = correctID(p,id);
        }

        id.substring(0,2).toLowerCase();
        for (int i = 2 ; i < id.length() ; i++) {
            if(!Character.isDigit(id.charAt(i))) {
                System.out.println("\t\tInvalid ID Format. Must be LetterLetterDigitDigitDigitDigit\n");
                System.out.print("\tID: ");
                id = (new Scanner(System.in)).nextLine();
                id = correctID(p,id);
            }
        }
        return id; 
    }   

    public static String correctYesorNo(String ans)
    {
        String temp = "";
        try
        {   
            if(ans.equals("") || ans.equals(" "))
                throw new Exception();
            else if(ans.toLowerCase().equals("y") || ans.toLowerCase().equals("n"))
                temp = ans;
            else
                throw new Exception();
        }
        catch(Exception e)
        {
            System.out.println("\t\t\"" + ans + "\" is invalid");
            System.out.print("Would you like to create the report? (Y/N): ");
            temp = (new Scanner(System.in)).nextLine();
            temp = correctYesorNo(temp);
        }

        return temp;
    }

    public static int sortByGPAorName(String s)
    {
        int temp = 0;
        String t = "";
        try
        {   
            if(s.equals("") || s.equals(" "))
                throw new Exception();
            else if(Integer.parseInt(s) == 1 || Integer.parseInt(s)==2)
                temp = Integer.parseInt(s);
            else 
                throw new Exception();
        }
        catch(Exception e)
        {
            System.out.println("\t\t\"" + s + "\" is invalid");
            System.out.print("Would you like to sort your students by descending GPA or name (1 for GPA, 2 for name): ");
            t = (new Scanner(System.in)).nextLine();
            temp = sortByGPAorName(t);
        }

        return temp;
    }

    public static int correctCreditHours(String credit)
    {
        int c = 0;
        try
        {
            int temp = Integer.parseInt(credit);
            if(credit.equals("") || credit.equals(" ") || temp<0) 
            {
                throw new Exception();
            }
            else
                c = temp;
        }   
        catch(Exception e)
        {
            System.out.println("\t\t\""+ credit + "\" is invalid\n");
            System.out.print("\tCredit Hours: ");
            credit = (new Scanner(System.in)).nextLine();
            c = correctCreditHours(credit);
        }

        return c;
    }
    
    public static double correctGPA(String GPA){
        Scanner scanner;
        double g = 0.0;
        try{
            if(GPA.equals(" ") || GPA.equals("")){
                throw new Exception();
            }
            else{
                g = Double.parseDouble(GPA);
            }
        
        }catch(Exception e){
            System.out.println("\t\t\""+ GPA + "\" is invalid\n");
            System.out.print("\tGPA: ");
            scanner = new Scanner(System.in);
            GPA = scanner.nextLine();
            g = correctGPA(GPA);
        }

        return g;
    }
    
    public static String correctRank(String rank){
        rank = rank.toLowerCase();
        String output = "";
        Scanner scanner;
      
        if(!rank.equals("") && ((rank.equals("professor") || rank.equals("adjunct")))){
            output = rank.substring(0,1).toUpperCase() + rank.substring(1);
        }
        else{
            scanner = new Scanner(System.in);
            System.out.println("\t\t\"" + rank + "\" is invalid\n");
            System.out.print("\tRank: ");
            rank = scanner.nextLine();
            output = correctRank(rank); 
        }
        return output;
    }

    public static String correctDepartment(String department){
        department = department.toLowerCase();
        String output = "";
        Scanner scanner;
        if(!department.equals("") && (department.equals("mathematics") || department.equals("engineering") || department.equals("english"))){
            output = department.substring(0,1).toUpperCase() + department.substring(1);
        }
        else{
            scanner = new Scanner(System.in);
            System.out.println("\t\t\"" + department + "\" is invalid\n");
            System.out.print("\tDepartment: ");
            department = scanner.nextLine();
            output = correctDepartment(department);
        }
        return output;
    }
    
    public static String correctStatus(String status){
        status = status.toLowerCase();
        String output = "";
        Scanner scanner;
        if(status.equals("p")){
            status = "Part Time";
        }
        else if(status.equals("f")){
            status = "Full Time";
        }
        else{
            scanner = new Scanner(System.in);
            System.out.println("\t\t\"" + status + "\" is invalid\n");
            System.out.print("\tStatus:");
            status = scanner.nextLine();
            output = correctStatus(status);
        }
        return status;
    }
}

//_________________________________________
class SortByGPA implements Comparator<Student>{
    
    public int compare(Student a, Student b)
    {   
        if(a.getGpa() == b.getGpa())
            return 0;
        else if(a.getGpa() < b.getGpa())
            return 1;
        else
            return -1;
    }
}
//_________________________________________

class SortByName implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        return s2.getfullName().compareTo(s1.getfullName());
    }
}

//_________________________________________
abstract class Person{
    private String fullName;
    private String id;
    
    public Person(){
        this.fullName = "No Name";
        this.id = "No ID";
    }

    public Person(String fullName, String id){
        this.fullName = fullName;
        this.id = id;
    }
    
    public String getfullName(){
        return fullName;
    }

    public String getID(){
        return this.id;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public void setID(String id){
        this.id = id;
    }

    public abstract void print();
}

//_________________________________________
abstract class Employee extends Person{
    private String department;
    
    public String getDepartment(){
        return department;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    public Employee (String fullName, String id, String department){
        super(fullName, id);
        this.department = department;
    }

    public Employee(){
        super();
        this.department = "No department";
    }
    
    @Override
    public void print(){
        System.out.println("\n---------------------------------------------------------------------------");
        System.out.println(super.getfullName() + "\t\t" + super.getID());
        return;
    } 
}

//_________________________________________
class Staff extends Employee{
    private String status;

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public Staff(String fullName, String id, String department, String status){
        super(fullName, id, department);
        this.status = status;
    }

    public Staff(){
        super();
        this.status = "No status";
    }
    
    @Override 
    public void print(){
        super.print();
        System.out.println(super.getDepartment() + " Department, " + status);
        System.out.println("---------------------------------------------------------------------------\n");
        return;
    }
}

class Faculty extends Employee{
    private String rank; 
    
    public Faculty(){
        super();
        this.rank = "No Rank";
    }
    
    public Faculty(String fullName, String id, String department, String rank){
        super(fullName, id, department);
        this.rank = rank;
    }
    
    public void setRank(String rank){
        this.rank = rank;
    }
    
    public String getRank(){
        return this.rank;
    }

    //override
    public void print(){
        super.print();
        System.out.println(super.getDepartment() + " Department, " + rank);
        System.out.println("---------------------------------------------------------------------------\n");
    }
}

class Student extends Person {
    private double gpa;
    private int creditHours;
    private final double fee = 52;
    private final double creditHourCost = 236.45;
    
    //constructor
    public Student(){
        super();
        this.gpa = 0;
        this.creditHours = 0; 
    }

    public Student(String fullName, String id, double gpa, int creditHours){
        super(fullName, id);
        this.gpa = gpa;
        this.creditHours = creditHours; 
    }

    //getters and setters
    public void setGpa (double gpa){
        this.gpa = gpa;
    }

    public double getGpa() {
        return this.gpa;
    }

    public void setCreditHours (int creditHours) {
        this.creditHours = creditHours;
    }

    public int getCreditHours() {
        return this.creditHours;
    }

    public double getCreditHourCost(){
        return this.creditHourCost;
    }

    public double getFee(){
        return this.fee;
    }

    //provides totalPayment based on if there is a discount or not
    public double totalPayment() {
        double totalPayment = 0; 
        double discount = 0.25 * (this.creditHours * this.creditHourCost + getFee());
        if (this.gpa >= 3.85) { 
            totalPayment = (this.creditHours * this.creditHourCost + getFee()) -  discount;
        }
        else {
            totalPayment = this.creditHours * this.creditHourCost + getFee();
        }
        return totalPayment;
    }    

    public boolean applyDiscount(){
        if(gpa>=8.85)
            return true;
        return false;
    }
    
    @Override
    public void print() {
        DecimalFormat myDecimalFormat = new DecimalFormat();
		myDecimalFormat.setMinimumFractionDigits(2);
		myDecimalFormat.setMaximumFractionDigits(2);
 
        System.out.println("\nHere is the tuition invoice for " + super.getfullName() + ":");
        System.out.println("\n---------------------------------------------------------------------------");
        System.out.println(super.getfullName() + "\t\t\t" + super.getID());
        System.out.println("Credit Hours: " + this.creditHours + " ($236.45/Credit Hour)");
        System.out.println("Fees: $" + myDecimalFormat.format(getFee()) + "\n");

        if(applyDiscount())
        {
            System.out.println("Total payment (after discount): $" + myDecimalFormat.format(totalPayment()) + "\t\t($" + myDecimalFormat.format((0.25 * totalPayment())) + " discount applied)");
        }
        else
            System.out.println("Total payment (after discount): $" + myDecimalFormat.format(totalPayment()) + "\t\t($" + 0.00 + " discount applied)");

        System.out.println("---------------------------------------------------------------------------\n");
    }    
}