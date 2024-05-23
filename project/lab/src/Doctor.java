import java.time.LocalDate;
public class Doctor implements Comparable<Doctor> {
    private String name;
    private int age;
    private int id;
    private String address;
    private LocalDate birthDate;
    
    


    public Doctor(String name, int id , String address ,LocalDate birthDate) {
        this.id = id ;
        this.name = name;
        this.age = (LocalDate.now().getYear() - birthDate.getYear());
        this.address = address;
        this.birthDate = birthDate;
    }
    
   
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public LocalDate getBirthDate() {
        return birthDate;
    }


    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    

    


    


    @Override
    public int compareTo(Doctor otherDoctor) {
        return Integer.compare(this.id, otherDoctor.id);
    }
    
}

class PermanamtDoctor extends Doctor{
    private double salary;
    private int departmantId;
    private LocalDate dateOfEmployment ; 
    private static double basesalry = 12000 ;
    
    public PermanamtDoctor(String name, int id ,  String address ,LocalDate birthDate, LocalDate dateOfEmployment,  int departmantId){
        super(name, id , address, birthDate);
        this.departmantId = departmantId;
        this.salary = basesalry;
        this.dateOfEmployment = dateOfEmployment;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDepartmantId() {
        return departmantId;
    }

    public void setDepartmantId(int departmantId) {
        this.departmantId = departmantId;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void type(){
        System.out.println("permanant doctor");
    }

    @Override
    public String toString() {
        return "PermanamtDoctor [salary=" + salary + ", departmantId=" + departmantId + ", Name = " + getName()
                + ", Age = " + getAge() + ", Id()=" + getId() + ", Address = " + getAddress()
                + ", BirthDate = " + getBirthDate() + ", Salary = " + getSalary() + ", DepartmantId = "
                + getDepartmantId() + "]";
    }


}

class TrainingDoctor extends Doctor{
    private LocalDate StartingDate;
    private LocalDate EndingDate;
    private int year ;
    private double salary ;
    private static final double basesalry = 1200.0 ;

    public TrainingDoctor(String name, int id , String address ,LocalDate birthDate , int year ,LocalDate StartingDate, LocalDate EndingDate){
        super(name, id , address, birthDate);
        this.StartingDate = StartingDate;
        this.EndingDate = EndingDate;
        this.year = year;
        setSalaryBasedOnYear(year);
    }

    private void setSalaryBasedOnYear(int year) {
        if (year == 1) {
            this.salary = basesalry*0.5;
        } else if (year == 2) {
            this.salary = basesalry*0.75;
        } else {
            this.salary = 0; // Default or error value if year is invalid
        }
    }

    public LocalDate getStartingDate() {
        return StartingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        StartingDate = startingDate;
    }

    public LocalDate getEndingDate() {
        return EndingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        EndingDate = endingDate;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "TrainingDoctor [StartingDate=" + StartingDate + ", EndingDate=" + EndingDate + ", year=" + year
                + ", salary=" + salary + ", basesalry=" + basesalry + ", Name=" + getName() + ", Age="
                + getAge() + ", Id=" + getId() + ", Address=" + getAddress() + ", BirthDate="
                + getBirthDate() + ", Salary=" + getSalary() + ", StartingDate=" + getStartingDate()
                + ", EndingDate=" + getEndingDate() + "]";
    }


    
    
    
}

 class ContractedDoctor extends Doctor{
    private LocalDate contractDate;
    private double wage;

    public ContractedDoctor(String name, int id , String address ,LocalDate birthDate , LocalDate contractDate){
        super(name, id , address, birthDate);
        this.contractDate = contractDate;
    }

    public LocalDate getContractDate() {
        return contractDate;
    }

    public void setContractDate(LocalDate contractDate) {
        this.contractDate = contractDate;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }
    
    public void type(){
        System.out.println("contracted doctor");
    }

    @Override
    public String toString() {
        return "ContractedDoctor [contractDate = " + contractDate + ", wage = " + wage + ", Name = " + getName()
                + ", Age = " + getAge() + ", Id=" + getId() + ", Address=" + getAddress()
                + ", BirthDate=" + getBirthDate()  + ", ContractDate = "
                + getContractDate() + ", Wage = "  + getWage() + "]";
    }

 }