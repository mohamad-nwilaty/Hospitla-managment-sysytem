
import java.time.LocalDate;
import java.util.ArrayList;
public class Patient implements Comparable<Patient> {
    private int id;
    private String name;
    private int age;
    private String address;
    private LocalDate birthDate;
    private ArrayList<InpatientTreatment> inpatientTreatments = new ArrayList<>();
    private ArrayList<OutpatientTreatment> outpatientTreatments = new ArrayList<>();
    private ArrayList<Treatment> allTreatments = new ArrayList<>();


    public Patient(String name , int id,String address ,LocalDate birthDate){
        this.id = id;
        this.name = name;
        this.age = (LocalDate.now().getYear() - birthDate.getYear());
        this.address = address;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    
    public ArrayList<InpatientTreatment> getInpatientTreatments() {
        return inpatientTreatments;
    }

    public ArrayList<OutpatientTreatment> getOutpatientTreatments() {
        return outpatientTreatments;
    }
    
    public ArrayList<Treatment> getAllTreatments() {
        return allTreatments;
    }

    @Override
    public int compareTo(Patient otherPAtient) {
        return Integer.compare(this.id, otherPAtient.id);
    }

    
}
class Inpatient extends Patient{
    private LocalDate dischargeDate ;
    private boolean isDischarged ;

    public Inpatient(String name  ,int id ,String address ,LocalDate birthDate  ){
        super(name,  id, address, birthDate);

    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }
    public void discharge(){
        this.isDischarged = true;
    }

    @Override
    public String toString() {
        return "Inpatient [dischargeDate=" + dischargeDate + "isDischarged = "+ isDischarged() + ", Id=" + getId() + ", Name=" + getName()
                + ", Age=" + getAge() + ", Address=" + getAddress() + ", BirthDate=" + getBirthDate()
                + "]";
    }

    public boolean isDischarged() {
        return isDischarged;
    }

    




}
class Outpatient extends Patient {
    private LocalDate admissionDate;

    public Outpatient( String name , int id,  String address, LocalDate birthDate, LocalDate admissionDate) {
        super( name,   id , address, birthDate);
        this.admissionDate = admissionDate;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    @Override
    public String toString() {
        return "Outpatient [admissionDate=" + admissionDate + ", Name=" + getName() + ", Age=" + getAge()
                + ", Address=" + getAddress() + ", BirthDate=" + getBirthDate() + "]";
    }
    
}
