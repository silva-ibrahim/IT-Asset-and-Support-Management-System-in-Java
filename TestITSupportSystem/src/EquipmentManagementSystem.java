import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EquipmentManagementSystem {
    private ArrayList<Equipment> equipmentList;
    private File file;
    private EmployeeManagementSystem employeeSystem;
    private ITSpecialistManagementSystem specialistSystem;

    EquipmentManagementSystem(EmployeeManagementSystem employeeSystem, ITSpecialistManagementSystem specialistSystem)
    {
        equipmentList = new ArrayList<>();
        file = new File("Equipment_Data.txt");
        this.employeeSystem = employeeSystem;
        this.specialistSystem = specialistSystem;

        if(file.exists())
        {
            try
            {
                Scanner fileReader = new Scanner(file);

                while(fileReader.hasNext())
                {
                    int code = Integer.parseInt(fileReader.nextLine());
                    String name = fileReader.nextLine();
                    String serialNumber = fileReader.nextLine();
                    double cost = Double.parseDouble(fileReader.nextLine());

                    int specialistId = Integer.parseInt(fileReader.nextLine());
                    int employeeCount = Integer.parseInt(fileReader.nextLine());

                    Equipment equipment = new Equipment(code, name, serialNumber, cost);

                    if(specialistId != -1)
                    {
                        ITSpecialist specialist = specialistSystem.getITSpecialist(specialistId);

                        if(specialist != null)
                            equipment.setResponsibleSpecialist(specialist);
                    }

                    for(int i = 0; i < employeeCount; i++)
                    {
                        int employeeId = Integer.parseInt(fileReader.nextLine());
                        Employee employee = employeeSystem.getEmployee(employeeId);

                        if(employee != null)
                            equipment.addEmployee(employee);
                    }

                    equipmentList.add(equipment);
                }

                fileReader.close();

                System.out.println("Equipment data loaded successfully!");
            }
            catch(IOException ioe)
            {
                System.out.println("An error occurred while reading the equipment file!");
                System.exit(1);
            }
        }
    }

    public void addEquipment(int code, String name, String serialNumber, double cost)
    {
        int index = this.equipmentExists(code);

        if(index != -1)
        {
            System.out.println("An equipment with this code already exists!");
        }
        else
        {
            equipmentList.add(new Equipment(code, name, serialNumber, cost));
            saveToFile();

            System.out.println("Equipment added successfully!");
        }
    }

    public void listEquipment()
    {
        if(!equipmentList.isEmpty())
        {
            System.out.println("\n--- Equipment Inventory ---");

            for(int i = 0; i < equipmentList.size(); i++)
                System.out.println(equipmentList.get(i).toString());
        }
        else
        {
            System.out.println("No equipment is registered!");
        }
    }

    public void updateEquipment(int code, String name, double cost)
    {
        int index = this.equipmentExists(code);

        if(index != -1)
        {
            equipmentList.get(index).setEquipmentName(name);
            equipmentList.get(index).setCost(cost);

            saveToFile();

            System.out.println("Equipment updated successfully!");
        }
        else
        {
            System.out.println("Equipment not found!");
        }
    }

    public void deleteEquipment(int code)
    {
        int index = this.equipmentExists(code);

        if(index != -1)
        {
            equipmentList.remove(equipmentList.get(index));
            saveToFile();

            System.out.println("Equipment deleted successfully!");
        }
        else
        {
            System.out.println("Equipment not found!");
        }
    }

    public void assignEmployee(int equipmentCode, int employeeId)
    {
        Equipment equipment = getEquipment(equipmentCode);
        Employee employee = employeeSystem.getEmployee(employeeId);

        if(equipment == null || employee == null)
        {
            System.out.println("Equipment or employee not found!");
            return;
        }

        int result = equipment.addEmployee(employee);

        if(result == -1)
        {
            System.out.println("This employee is already assigned to this equipment!");
        }
        else
        {
            saveToFile();
            System.out.println("Employee assigned to the equipment successfully!");
        }
    }

    public void removeEmployee(int equipmentCode, int employeeId)
    {
        Equipment equipment = getEquipment(equipmentCode);
        Employee employee = employeeSystem.getEmployee(employeeId);

        if(equipment == null || employee == null)
        {
            System.out.println("Equipment or employee not found!");
            return;
        }

        int result = equipment.removeEmployee(employee);

        if(result == -1)
        {
            System.out.println("This employee is not assigned to this equipment!");
        }
        else
        {
            saveToFile();
            System.out.println("Employee assignment removed successfully!");
        }
    }

    public void assignSpecialist(int equipmentCode, int specialistId)
    {
        Equipment equipment = getEquipment(equipmentCode);
        ITSpecialist specialist = specialistSystem.getITSpecialist(specialistId);

        if(equipment == null || specialist == null)
        {
            System.out.println("Equipment or IT specialist not found!");
            return;
        }

        if(equipment.getResponsibleSpecialist() != null)
        {
            if(equipment.getResponsibleSpecialist().getId() == specialistId)
            {
                System.out.println("This IT specialist is already assigned to this equipment!");
                return;
            }
        }

        equipment.setResponsibleSpecialist(specialist);
        saveToFile();

        System.out.println("Responsible IT specialist assigned successfully!");
    }

    public void showEquipmentDetails(int code)
    {
        Equipment equipment = getEquipment(code);

        if(equipment != null)
            equipment.showAllInformation();
        else
            System.out.println("Equipment not found!");
    }

    public Equipment getEquipment(int code)
    {
        int index = this.equipmentExists(code);

        if(index != -1)
            return equipmentList.get(index);

        return null;
    }

    private int equipmentExists(int code)
    {
        int i;

        for(i = 0; i < equipmentList.size(); i++)
        {
            if(equipmentList.get(i).getEquipmentCode() == code)
                return i;
        }

        return -1;
    }

    private void saveToFile()
    {
        try
        {
            PrintWriter fileWriter = new PrintWriter(file);

            for(int i = 0; i < equipmentList.size(); i++)
            {
                Equipment equipment = equipmentList.get(i);

                fileWriter.println(equipment.getEquipmentCode());
                fileWriter.println(equipment.getEquipmentName());
                fileWriter.println(equipment.getSerialNumber());
                fileWriter.println(equipment.getCost());

                if(equipment.getResponsibleSpecialist() != null)
                    fileWriter.println(equipment.getResponsibleSpecialist().getId());
                else
                    fileWriter.println(-1);

                fileWriter.println(equipment.getEmployeeList().size());

                for(int j = 0; j < equipment.getEmployeeList().size(); j++)
                    fileWriter.println(equipment.getEmployeeList().get(j).getId());
            }

            fileWriter.close();
        }
        catch(IOException ioe)
        {
            System.out.println("An error occurred while saving the equipment data!");
        }
    }
}

