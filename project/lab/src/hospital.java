import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;


class hospital {
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static ArrayList<Patient> patients = new ArrayList<>();

    

    public static ArrayList<Doctor> getDoctors() {
        return doctors;
    }
    public static ArrayList<Patient> getPatients() {
        return patients;
    }

    public void addDoctors(Doctor newDoctor) {
        doctors.add(newDoctor);
        Collections.sort(doctors);
    }
    public static void removeDoctors(int id) {
        doctors.removeIf(doctor -> doctor.getId() == id);
        
    }
    // retreaving a doctor based on his id
    public Doctor getDoctor(int id){
        for(Doctor d : doctors){
            if(d.getId() == id){
                return d;
            }
        }
        return null ;
    }

    public void addPatient(Patient newPatient){
        patients.add(newPatient);
        Collections.sort(patients);
    }
     public static void removePatient(Patient patient){
        if(patient instanceof Inpatient){
            ((Inpatient)patient).setDischargeDate(LocalDate.now());
        }
        patients.remove(patient);
    }

// discharginge Patients
    public void dischargePatient(int id){
         for(Patient patient : patients){
             if(patient.getId() == id && patient instanceof Inpatient ){
                    ((Inpatient) patient).setDischargeDate(LocalDate.now());
                    ((Inpatient) patient).discharge();
                     break;
             }
         }
    }

    public int countContractedDoctors() {
        int i = 0;
        for(Doctor d : doctors){
            if(d instanceof ContractedDoctor){
                i++ ;
            }
        }
        return i ;
    }

     //employ a training doctor
    public void employDoctor(TrainingDoctor trainingDoctor , int departmantId){
        PermanamtDoctor newDoctor = new PermanamtDoctor(trainingDoctor.getName(), trainingDoctor.getId()  , trainingDoctor.getAddress() , trainingDoctor.getBirthDate() , LocalDate.now() , departmantId);
        removeDoctors(trainingDoctor.getId());
        addDoctors(newDoctor);

    }

    // records of doctors between a period of time
    public ArrayList<Doctor> DoctorsPeriod(LocalDate start , LocalDate end){
        ArrayList<Doctor> allDoctors = new ArrayList<>();
        for (Doctor doctor : doctors) {
            if(doctor instanceof PermanamtDoctor){
                LocalDate date = ((PermanamtDoctor) doctor).getDateOfEmployment();
                if(date.isAfter(start) && date.isBefore(end)) allDoctors.add(doctor);
                continue ;
            }
            else if( doctor instanceof ContractedDoctor){
                LocalDate date = ((ContractedDoctor) doctor).getContractDate();
                if(date.isAfter(start) && date.isBefore(end)) allDoctors.add(doctor);
                continue ;
            }
            else{
                LocalDate date = ((TrainingDoctor) doctor).getStartingDate();
                if(date.isAfter(end) && date.isBefore(end)) allDoctors.add(doctor);
                
            }
        }



        return allDoctors;
    } 

    public void addTreatmentToPatient(int id, Treatment treatment) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                patient.getAllTreatments().add(treatment);
                if (treatment instanceof InpatientTreatment) {
                    patient.getInpatientTreatments().add((InpatientTreatment) treatment);
                } else if (treatment instanceof OutpatientTreatment) {
                    patient.getOutpatientTreatments().add((OutpatientTreatment) treatment);
                    Doctor doctor = ((OutpatientTreatment) treatment).getTreatingDoctor();
                    if (doctor instanceof ContractedDoctor) {
                        ((ContractedDoctor) doctor).setWage(treatment.getCost() * 0.5) ;
                    }
                }
                break;
            }
        }
    }


    // count all patients in a department within a period of time
    public int PatientsInDepartment(  int departmantId , LocalDate starDate , LocalDate enDate ){
        int i =0 ;
        for(Patient patient : patients){
                for(Treatment t : patient.getAllTreatments()){
                    if(t instanceof OutpatientTreatment){
                        if(((OutpatientTreatment) t).getClinicId() == departmantId){
                            if(t.getDate().isAfter(starDate) && t.getDate().isBefore(enDate)){
                                i++;
                                continue;
                            }

                        }
                        
                    }
                    else{
                        if(((InpatientTreatment) t).getDepartmentId() == departmantId){
                            if(t.getDate().isAfter(starDate) && t.getDate().isBefore(enDate)){
                                i++;
                                
                            }
                        }
                    }
                }

        }

        return i;
    }
    // return all patients wtithin a period of time
    public ArrayList<Patient> PatientsInHospital(LocalDate starDate , LocalDate enDate ){
        ArrayList<Patient> arr = new ArrayList<>();
        for (Patient patient : patients) {
            for(Treatment t : patient.getAllTreatments()){
                if(t.getDate().isAfter(starDate) && t.getDate().isBefore(enDate)){
                    arr.add(patient);
                }
            }
            
        }

        return arr;
    }
    

    
}


