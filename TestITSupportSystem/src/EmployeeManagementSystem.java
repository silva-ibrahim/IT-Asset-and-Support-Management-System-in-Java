import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EmployeeManagementSystem extends ManagementSystem {
    private ArrayList<Employee> employeeList;
    private File file;

    EmployeeManagementSystem()
    {
        employeeList = new ArrayList<>();
        file = new File("Employee_Data.txt");

        if(file.exists())
        {
            try
            {
                Scanner fileReader = new Scanner(file);

                while(fileReader.hasNext())
                {
                    int id = Integer.parseInt(fileReader.nextLine());
                    String name = fileReader.nextLine();
                    String email = fileReader.nextLine();
                    String position = fileReader.nextLine();

                    employeeList.add(new Employee(id, name, email, position));
                }

                fileReader.close();

                System.out.println("Employee data loaded successfully!");
            }
            catch(IOException ioe)
            {
                System.out.println("An error occurred while reading the employee file!");
                System.exit(1);
            }
        }
    }

    @Override
    public void addRecord(int id, String name, String email, String position)
    {
        int index = this.employeeExists(id);

        if(index != -1)
        {
            System.out.println("An employee with this ID already exists!");
        }
        else
        {
            employeeList.add(new Employee(id, name, email, position));

            try
            {
                FileWriter fw = new FileWriter(file, true);
                PrintWriter fileWriter = new PrintWriter(fw);

                fileWriter.println(id);
                fileWriter.println(name);
                fileWriter.println(email);
                fileWriter.println(position);

                fileWriter.close();

                System.out.println("Employee record added successfully!");
            }
            catch(IOException ioe)
            {
                System.out.println("An error occurred while saving the employee!");
            }
        }
    }

    @Override
    public void listRecords()
    {
        if(!employeeList.isEmpty())
        {
            for(int i = 0; i < employeeList.size(); i++)
                System.out.println(employeeList.get(i).toString());
        }
        else
        {
            System.out.println("No registered employees!");
        }
    }

    @Override
    public void updateRecord(int id, String name, String email)
    {
        int index = this.employeeExists(id);

        if(index != -1)
        {
            employeeList.get(index).setName(name);
            employeeList.get(index).setEmail(email);

            try
            {
                PrintWriter fileWriter = new PrintWriter(file);

                for(int i = 0; i < employeeList.size(); i++)
                {
                    fileWriter.println(employeeList.get(i).getId());
                    fileWriter.println(employeeList.get(i).getName());
                    fileWriter.println(employeeList.get(i).getEmail());
                    fileWriter.println(employeeList.get(i).getPosition());
                }

                fileWriter.close();

                System.out.println("Employee updated successfully!");
            }
            catch(IOException ioe)
            {
                System.out.println("An error occurred while updating the employee!");
            }
        }
        else
        {
            System.out.println("No employee with this ID exists!");
        }
    }

    @Override
    public void deleteRecord(int id)
    {
        int index = this.employeeExists(id);

        if(index != -1)
        {
            employeeList.remove(employeeList.get(index));

            try
            {
                PrintWriter fileWriter = new PrintWriter(file);

                for(int i = 0; i < employeeList.size(); i++)
                {
                    fileWriter.println(employeeList.get(i).getId());
                    fileWriter.println(employeeList.get(i).getName());
                    fileWriter.println(employeeList.get(i).getEmail());
                    fileWriter.println(employeeList.get(i).getPosition());
                }

                fileWriter.close();

                System.out.println("Employee deleted successfully!");
            }
            catch(IOException ioe)
            {
                System.out.println("An error occurred while deleting the employee!");
            }
        }
        else
        {
            System.out.println("No employee with this ID exists!");
        }
    }

    private int employeeExists(int id)
    {
        int i;

        for(i = 0; i < employeeList.size(); i++)
        {
            if(employeeList.get(i).getId() == id)
                return i;
        }

        return -1;
    }

    public Employee getEmployee(int id)
    {
        int index = this.employeeExists(id);

        if(index != -1)
            return employeeList.get(index);

        return null;
    }
}
