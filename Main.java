import java.util.Scanner;
import java.util.ArrayList;
class person{
    protected String name;
    protected int age ;
    protected String ID;
    public person (String name , int age , String ID){
        this.name=name;
        this.age=age;
        this.ID=ID;
    }
    public String information ()
    {
        return  "\nName: "+ name + "\nAge: "+age;
    }
}
class patient extends person {
    private String disease;
    private String status;
    private int numdays;
    public patient (String name , int age,String ID,String disease,String status,int numdays)
    {
        super(name ,age , ID);
        this.disease=disease;
        this.status=status;
        this.numdays=numdays;
    }
    public int fee()
    {
        if(status.equalsIgnoreCase("critical"))
        {
            return numdays*10000;
        }
        else
        {
            return numdays*5000;
        }
    }
    public String roomtype()
    {
        if(status.equalsIgnoreCase("critical"))
        {
            return "Intensive Care";
        }
        else return "Regular Room";
    }
    @Override
    public String information ()
    {
        return "Patient nmber:" + ID + super.information() + "\nDisease: " + disease + "\nHealth Status: "+ status+ "\nRoomType: "+roomtype()+"\nDays spent: "+numdays+"\nBill Cost:"+fee();
    }
}
class employee extends person {
    private int salary ;
    public employee(String name , int age,String ID , int salary){
        super (name ,age , ID);
        this.salary= salary;
    }
    @Override public String information()
    {
        return super.information()+"\nSalary: "+ salary ;
    }
}
class doctor extends employee {
    private String department ;
    public doctor(String name , int age,String ID ,int salary, String department ){
        super (name ,age , ID, salary);
        this.department= department;
    }
    @Override public String information()
    {
        return "DR. Number:"+ID+ super.information()+"\nDepartment: "+department ;
    }
}
class nurse extends employee {
    private String shift;
    public nurse(String name , int age,String ID ,int salary, String shift ){
        super (name ,age , ID, salary);
        this.shift= shift;
    }
    @Override public String information()
    {
        return "Nurse Number:"+ID+  super.information()+"\nShift: "+shift ;
    }
}
class HospitalSystem {
    static ArrayList<person>people =new ArrayList<>();
    static Scanner input= new Scanner(System.in);
    public static void main(String []args) {
    {
        while(true)
        {
            System.out.println("=====Welcome to our Hospital System please choose operation number=====");
            System.out.println("1-Add Patient");
            System.out.println("2-Add Doctor");
            System.out.println("3-Add Nurse");
            System.out.println("4-Display information");
            System.out.println("5-Exit");
            System.out.print("=====Thanks=====");
            int choice = input.nextInt();
            input.nextLine();
            switch (choice)
            {
                case 1:
                    addPatient();
                    break;
                case 2:
                    addDoctor();
                    break;
                case 3:
                    addNurse();
                    break;
                case 4:
                    displayinfo();
                    break;
                case 5:
                    System.out.println("System Closed");
                    return;
                default :
                    System.out.println("Invalid input...Please try again");
            }
        }
    }
}
static void addPatient()
{
    System.out.println("Please enter ID ");
    String id= HospitalSystem.input.nextLine();
    System.out.println("Please enter Name ");
    String name= HospitalSystem.input.nextLine();
    System.out.println("Please enter Age ");
    int age= HospitalSystem.input.nextInt();
    HospitalSystem.input.nextLine();
    System.out.println("Please enter disease ");
    String disease= HospitalSystem.input.nextLine();
    System.out.println("Please enter status ");
    String status= HospitalSystem.input.nextLine();
    System.out.println("Please enter number of days spent by patient ");
    int days= HospitalSystem.input.nextInt();
    HospitalSystem.input.nextLine();

    patient a = new patient (name,age,id,disease,status,days);
    people.add(a);
}
static void addDoctor()
{
    System.out.println("Please enter ID ");
    String id= HospitalSystem.input.nextLine();
    System.out.println("Please enter Name ");
    String name= HospitalSystem.input.nextLine();
    System.out.println("Please enter Age ");
    int age= HospitalSystem.input.nextInt();
    System.out.println("Please enter Salary ");
    int salary= HospitalSystem.input.nextInt();
    HospitalSystem.input.nextLine();
    System.out.println("Please enter Department ");
    String department = HospitalSystem.input.nextLine();
    doctor d = new doctor (name ,age , id , salary, department);
    people.add(d);
}
static void addNurse()
{
    System.out.println("Please enter ID ");
    String id= HospitalSystem.input.nextLine();
    System.out.println("Please enter Name ");
    String name= HospitalSystem.input.nextLine();
    System.out.println("Please enter Age ");
    int age= HospitalSystem.input.nextInt();
    System.out.println("Please enter Salary ");
    int salary= HospitalSystem.input.nextInt();
    HospitalSystem.input.nextLine();
    System.out.println("Please enter shift time (morning/night)");
    String shift = HospitalSystem.input.nextLine();
    nurse n= new nurse(name,age,id,salary,shift);
    people.add(n);
}
static void displayinfo ()
{
    if(people.isEmpty())
    {
        System.out.println("No records found");
        return;
    }
    else {
        for (person p : people)
        {
            System.out.println(p.information());
        }
    }
}
    
}
