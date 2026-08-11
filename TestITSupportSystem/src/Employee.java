public class Employee extends Person {
    private String position;

    Employee(int id, String name, String email, String position)
    {
        super(id, name, email);
        this.position = position;
    }

    public String getPosition()
    {
        return position;
    }

    public void setPosition(String newPosition)
    {
        position = newPosition;
    }

    @Override
    public String toString()
    {
        return "Employee ID: " + getId() + " - " + super.toString() + " - Position: " + position;
    }
}
