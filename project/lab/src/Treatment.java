import java.time.LocalDate;
import java.util.ArrayList;
class Treatment {
    private int id;
    private LocalDate date;
    private double cost;

    public Treatment(int id, LocalDate date, double cost) {
        this.id = id;
        this.date = date;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getCost() {
        return cost;
    }
}

class InpatientTreatment extends Treatment {
    private int departmentId;
    private ArrayList<Doctor> supervisingDoctors;

    public InpatientTreatment(int id, LocalDate date, double cost, int departmentId, ArrayList<Doctor> supervisingDoctors) {
        super(id, date, cost);
        this.departmentId = departmentId;
        this.supervisingDoctors = supervisingDoctors;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public ArrayList<Doctor> getSupervisingDoctors() {
        return supervisingDoctors;
    }
}

class OutpatientTreatment extends Treatment {
    private int clinicId;
    private Doctor treatingDoctor;

    public OutpatientTreatment(int id, LocalDate date, double cost, int clinicId, Doctor treatingDoctor) {
        super(id, date, cost);
        this.clinicId = clinicId;
        this.treatingDoctor = treatingDoctor;
        
    }

    public int getClinicId() {
        return clinicId;
    }

    public Doctor getTreatingDoctor() {
        return treatingDoctor;
    }
}
