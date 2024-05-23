import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        hospital Hospital = new hospital();
        
        // initializing doctors
        PermanamtDoctor d1 = new PermanamtDoctor("mhmad" , 101 , "damascus " , LocalDate.of(1990 , 2, 21) , LocalDate.of(2010, 2, 2) , 1);
        TrainingDoctor d2 = new TrainingDoctor("ali", 110,  "alhamra", LocalDate.of(1960, 1, 20), 2 , LocalDate.of(1990, 1, 21), LocalDate.of(1992, 1, 21));
        ContractedDoctor d3 = new ContractedDoctor("ammar", 102,  "dahya", LocalDate.of(1990, 2, 19), LocalDate.of(2000, 2, 20));
        ContractedDoctor d4 = new ContractedDoctor("loay", 105,  "homs", LocalDate.of(1950, 7, 3), LocalDate.of(2012, 3, 1));
        
        // adding doctors
        Hospital.addDoctors(d2);
        Hospital.addDoctors(d1);
        Hospital.addDoctors(d3);
        Hospital.addDoctors(d4);
        
        
        
        // intializing patients
        Outpatient p1 = new Outpatient("Ali",  1, "adra", LocalDate.of(2005, 1, 21), null);
        Outpatient p2 = new Outpatient("ousama", 2, "india", LocalDate.of(2004, 1, 21), null);
        Inpatient p3 = new Inpatient("yamen", 3, "jiba", LocalDate.of(2003, 1, 21));

        // adding patients to the hospital
        Hospital.addPatient(p1);
        Hospital.addPatient(p2);
        Hospital.addPatient(p3);

        // initializing treatments
        OutpatientTreatment t1 = new OutpatientTreatment(1, LocalDate.of(2010, 1, 2), 1000, 3, d4);
        OutpatientTreatment t2 = new OutpatientTreatment(2, LocalDate.of(2014, 2, 3), 1000, 3, d4);
        InpatientTreatment t3 = new InpatientTreatment(3, LocalDate.of(2023, 2, 3), 1200, 101, new ArrayList<Doctor>()) ;
        
        // adding treatment to patients
        Hospital.addTreatmentToPatient(1, t1);
        Hospital.addTreatmentToPatient(2, t2);
        Hospital.addTreatmentToPatient(3, t3);
        
        // examples of operations

        // counting contracted doctors
        System.out.println("there are " +Hospital.countContractedDoctors() + " contracted doctors in the hospital");
        System.out.println();
        // showing records of doctors between a time period
        for(Doctor d : Hospital.DoctorsPeriod(LocalDate.of(2009, 1, 1), LocalDate.of(2013, 1, 1))){
            System.out.println(d);
            
        }

        System.out.println();

        // counting patients within a time period
        System.out.println(Hospital.PatientsInDepartment(3, LocalDate.of(2000, 1, 1), LocalDate.of(2015, 1, 2)));
        System.out.println();
        // show all patients in the Hospital within a period of time
        for(Patient p : Hospital.PatientsInHospital(LocalDate.of(2014, 1, 2), LocalDate.of(2024, 1, 2))){
            System.out.println(p);
            
        }
        System.out.println();
        //discharging patients 
        System.out.println("before dicharing:");
        System.out.println(p3);
        System.out.println("after dicharing:");
        Hospital.dischargePatient(p3.getId());
        System.out.println(p3);
        System.out.println();
 
        // employing a doctor
        System.out.println("before employment");
        System.out.println(d2);
        System.out.println("after employment");
        Hospital.employDoctor(d2, 101);
        System.out.println(Hospital.getDoctor(d2.getId()));



    
            
        
        
       
    
        

    }

}

