import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ITSpecialistManagementSystem extends ManagementSystem {
    private ArrayList<ITSpecialist> specialistList;
    private File file;

    ITSpecialistManagementSystem()
    {
        specialistList = new ArrayList<>();
        file = new File("IT_Specialist_Data.txt");

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
                    String specialization = fileReader.nextLine();

                    specialistList.add(new ITSpecialist(id, name, email, specialization));
                }

                fileReader.close();

                System.out.println("IT specialist data loaded successfully!");
            }
            catch(IOException ioe)
            {
                System.out.println("An error occurred while reading the IT specialist file!");
                System.exit(1);
            }
        }
    }

    @Override
    public void addRecord(int id, String name, String email, String specialization)
    {
        int index = this.specialistExists(id);

        if(index != -1)
        {
            System.out.println("An IT specialist with this ID already exists!");
        }
        else
        {
            specialistList.add(new ITSpecialist(id, name, email, specialization));

            try
            {
                FileWriter fw = new FileWriter(file, true);
                PrintWriter fileWriter = new PrintWriter(fw);

                fileWriter.println(id);
                fileWriter.println(name);
                fileWriter.println(email);
                fileWriter.println(specialization);

                fileWriter.close();

                System.out.println("IT specialist record added successfully!");
            }
            catch(IOException ioe)
            {
                System.out.println("An error occurred while saving the IT specialist!");
            }
        }
    }

    @Override
    public void listRecords()
    {
        if(!specialistList.isEmpty())
        {
            for(int i = 0; i < specialistList.size(); i++)
                System.out.println(specialistList.get(i).toString());
        }
        else
        {
            System.out.println("No registered IT specialists!");
        }
    }

    @Override
    public void updateRecord(int id, String name, String email)
    {
        int index = this.specialistExists(id);

        if(index != -1)
        {
            specialistList.get(index).setName(name);
            specialistList.get(index).setEmail(email);

            try
            {
                PrintWriter fileWriter = new PrintWriter(file);

                for(int i = 0; i < specialistList.size(); i++)
                {
                    fileWriter.println(specialistList.get(i).getId());
                    fileWriter.println(specialistList.get(i).getName());
                    fileWriter.println(specialistList.get(i).getEmail());
                    fileWriter.println(specialistList.get(i).getSpecialization());
                }

                fileWriter.close();

                System.out.println("IT specialist updated successfully!");
            }
            catch(IOException ioe)
            {
                System.out.println("An error occurred while updating the IT specialist!");
            }
        }
        else
        {
            System.out.println("No IT specialist with this ID exists!");
        }
    }

    @Override
    public void deleteRecord(int id)
    {
        int index = this.specialistExists(id);

        if(index != -1)
        {
            specialistList.remove(specialistList.get(index));

            try
            {
                PrintWriter fileWriter = new PrintWriter(file);

                for(int i = 0; i < specialistList.size(); i++)
                {
                    fileWriter.println(specialistList.get(i).getId());
                    fileWriter.println(specialistList.get(i).getName());
                    fileWriter.println(specialistList.get(i).getEmail());
                    fileWriter.println(specialistList.get(i).getSpecialization());
                }

                fileWriter.close();

                System.out.println("IT specialist deleted successfully!");
            }
            catch(IOException ioe)
            {
                System.out.println("An error occurred while deleting the IT specialist!");
            }
        }
        else
        {
            System.out.println("No IT specialist with this ID exists!");
        }
    }

    private int specialistExists(int id)
    {
        int i;

        for(i = 0; i < specialistList.size(); i++)
        {
            if(specialistList.get(i).getId() == id)
                return i;
        }

        return -1;
    }

    public ITSpecialist getITSpecialist(int id)
    {
        int index = this.specialistExists(id);

        if(index != -1)
            return specialistList.get(index);

        return null;
    }
}

