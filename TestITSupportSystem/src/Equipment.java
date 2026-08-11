import java.util.ArrayList;

public class Equipment {
    private int equipmentCode;
    private String equipmentName;
    private String serialNumber;
    private double cost;
    private ITSpecialist responsibleSpecialist;
    private ArrayList<Employee> employeeList;

    Equipment(int equipmentCode, String equipmentName, String serialNumber, double cost)
    {
        this.equipmentCode = equipmentCode;
        this.equipmentName = equipmentName;
        this.serialNumber = serialNumber;
        this.cost = cost;
        employeeList = new ArrayList<>();
    }

    public int getEquipmentCode()
    {
        return equipmentCode;
    }

    public String getEquipmentName()
    {
        return equipmentName;
    }

    public String getSerialNumber()
    {
        return serialNumber;
    }

    public double getCost()
    {
        return cost;
    }

    public void setEquipmentName(String newName)
    {
        equipmentName = newName;
    }

    public void setCost(double newCost)
    {
        cost = newCost;
    }

    public ITSpecialist getResponsibleSpecialist()
    {
        return responsibleSpecialist;
    }

    public void setResponsibleSpecialist(ITSpecialist specialist)
    {
        responsibleSpecialist = specialist;
    }

    public int addEmployee(Employee employee)
    {
        if(employeeList.contains(employee))
            return -1;

        employeeList.add(employee);

        return 0;
    }

    public int removeEmployee(Employee employee)
    {
        int index = employeeList.indexOf(employee);

        if(index != -1)
        {
            employeeList.remove(employee);
            return 0;
        }

        return -1;
    }

    public ArrayList<Employee> getEmployeeList()
    {
        return employeeList;
    }

    public void showAllInformation()
    {
        System.out.println("Equipment Code: " + equipmentCode + " - Equipment: " + equipmentName + " - Serial No: " + serialNumber + " - Cost: " + cost + " $");

        if(responsibleSpecialist != null)
            System.out.println("-> Responsible IT Specialist: " + responsibleSpecialist.getName() + " (" + responsibleSpecialist.getSpecialization() + ")");
        else
            System.out.println("-> No IT specialist has been assigned to this equipment.");

        System.out.println("-> Employees Using This Equipment:");

        if(employeeList.size() > 0)
        {
            for(int i = 0; i < employeeList.size(); i++)
                System.out.println("- " + employeeList.get(i).getName() + " (" + employeeList.get(i).getPosition() + ")");
        }
        else
            System.out.println("No employee is assigned to this equipment.");
    }

    @Override
    public String toString()
    {
        return "Equipment Code: " + equipmentCode + " - Equipment: " + equipmentName + " - Serial No: " + serialNumber + " - Cost: " + cost + " $";
    }
}
