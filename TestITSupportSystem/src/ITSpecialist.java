public class ITSpecialist extends Person {
    private String specialization;

    ITSpecialist(int id, String name, String email, String specialization)
    {
        super(id, name, email);
        this.specialization = specialization;
    }

    public String getSpecialization()
    {
        return specialization;
    }

    public void setSpecialization(String newSpecialization)
    {
        specialization = newSpecialization;
    }

    @Override
    public String toString()
    {
        return "IT Specialist ID: " + getId() + " - " + super.toString() + " - Specialization: " + specialization;
    }
}

