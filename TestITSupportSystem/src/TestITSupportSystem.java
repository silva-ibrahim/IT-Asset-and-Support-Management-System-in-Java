import java.util.Scanner;

public class TestITSupportSystem {

    public static void main(String[] args)
    {
        EmployeeManagementSystem employeeSystem = new EmployeeManagementSystem();
        ITSpecialistManagementSystem specialistSystem = new ITSpecialistManagementSystem();
        EquipmentManagementSystem equipmentSystem = new EquipmentManagementSystem(employeeSystem, specialistSystem);

        Scanner input = new Scanner(System.in);

        int choice;

        do
        {
            System.out.println("\n--- IT ASSET AND SUPPORT SYSTEM ---");
            System.out.println("1- Employee Management System");
            System.out.println("2- IT Specialist Management System");
            System.out.println("3- Equipment and Inventory Management System");
            System.out.println("4- Exit");

            System.out.print("\nChoose an option: ");
            choice = input.nextInt();

            switch(choice)
            {
                case 1:
                    employeeMenu(employeeSystem);
                    break;

                case 2:
                    specialistMenu(specialistSystem);
                    break;

                case 3:
                    equipmentMenu(equipmentSystem);
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        }while(choice != 4);

        System.out.println("IT Asset and Support System terminated!");
    }

    public static void employeeMenu(EmployeeManagementSystem employeeSystem)
    {
        Scanner input = new Scanner(System.in);

        int choice;

        do
        {
            System.out.println("\n--- Employee Management Menu ---");
            System.out.println("1- Add New Employee");
            System.out.println("2- Update Employee Information");
            System.out.println("3- Delete Employee");
            System.out.println("4- List All Employees");
            System.out.println("5- Return to Main Menu");

            System.out.print("\nChoose an option: ");
            choice = input.nextInt();

            switch(choice)
            {
                case 1:
                    newEmployee(employeeSystem);
                    break;

                case 2:
                    updateEmployee(employeeSystem);
                    break;

                case 3:
                    deleteEmployee(employeeSystem);
                    break;

                case 4:
                    showEmployees(employeeSystem);
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }

        }while(choice != 5);
    }

    public static void newEmployee(EmployeeManagementSystem employeeSystem)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Employee ID: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Name: ");
        String name = input.nextLine();

        System.out.print("E-mail: ");
        String email = input.nextLine();

        System.out.print("Position: ");
        String position = input.nextLine();

        employeeSystem.addRecord(id, name, email, position);

        System.out.println();
    }

    public static void updateEmployee(EmployeeManagementSystem employeeSystem)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Employee ID: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("New name: ");
        String name = input.nextLine();

        System.out.print("New e-mail: ");
        String email = input.nextLine();

        employeeSystem.updateRecord(id, name, email);

        System.out.println();
    }

    public static void deleteEmployee(EmployeeManagementSystem employeeSystem)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Employee ID: ");
        int id = input.nextInt();

        employeeSystem.deleteRecord(id);

        System.out.println();
    }

    public static void showEmployees(EmployeeManagementSystem employeeSystem)
    {
        System.out.println("Employee Records are being listed!");

        employeeSystem.listRecords();

        System.out.println();
    }

    public static void specialistMenu(ITSpecialistManagementSystem specialistSystem)
    {
        Scanner input = new Scanner(System.in);

        int choice;

        do
        {
            System.out.println("\n--- IT Specialist Management Menu ---");
            System.out.println("1- Add New IT Specialist");
            System.out.println("2- Update IT Specialist Information");
            System.out.println("3- Delete IT Specialist");
            System.out.println("4- List All IT Specialists");
            System.out.println("5- Return to Main Menu");

            System.out.print("\nChoose an option: ");
            choice = input.nextInt();

            switch(choice)
            {
                case 1:
                    newSpecialist(specialistSystem);
                    break;

                case 2:
                    updateSpecialist(specialistSystem);
                    break;

                case 3:
                    deleteSpecialist(specialistSystem);
                    break;

                case 4:
                    showSpecialists(specialistSystem);
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }

        }while(choice != 5);
    }

    public static void newSpecialist(ITSpecialistManagementSystem specialistSystem)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("IT Specialist ID: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Name: ");
        String name = input.nextLine();

        System.out.print("E-mail: ");
        String email = input.nextLine();

        System.out.print("Specialization: ");
        String specialization = input.nextLine();

        specialistSystem.addRecord(id, name, email, specialization);

        System.out.println();
    }

    public static void updateSpecialist(ITSpecialistManagementSystem specialistSystem)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("IT Specialist ID: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("New name: ");
        String name = input.nextLine();

        System.out.print("New e-mail: ");
        String email = input.nextLine();

        specialistSystem.updateRecord(id, name, email);

        System.out.println();
    }

    public static void deleteSpecialist(ITSpecialistManagementSystem specialistSystem)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("IT Specialist ID: ");
        int id = input.nextInt();

        specialistSystem.deleteRecord(id);

        System.out.println();
    }

    public static void showSpecialists(ITSpecialistManagementSystem specialistSystem)
    {
        System.out.println("IT Specialist Records are being listed!");

        specialistSystem.listRecords();

        System.out.println();
    }

    public static void equipmentMenu(EquipmentManagementSystem equipmentSystem)
    {
        Scanner input = new Scanner(System.in);

        int choice;

        do
        {
            System.out.println("\n--- Equipment Management Menu ---");
            System.out.println("1- Add New Equipment");
            System.out.println("2- Update Equipment Information");
            System.out.println("3- Delete Equipment");
            System.out.println("4- List All Equipment");
            System.out.println("5- Assign Employee to Equipment");
            System.out.println("6- Remove Employee from Equipment");
            System.out.println("7- Assign IT Specialist to Equipment");
            System.out.println("8- Show Complete Equipment Information");
            System.out.println("9- Return to Main Menu");

            System.out.print("\nChoose an option: ");
            choice = input.nextInt();

            switch(choice)
            {
                case 1:
                    newEquipment(equipmentSystem);
                    break;

                case 2:
                    updateEquipment(equipmentSystem);
                    break;

                case 3:
                    deleteEquipment(equipmentSystem);
                    break;

                case 4:
                    showEquipment(equipmentSystem);
                    break;

                case 5:
                    assignEmployee(equipmentSystem);
                    break;

                case 6:
                    removeEmployee(equipmentSystem);
                    break;

                case 7:
                    assignSpecialist(equipmentSystem);
                    break;

                case 8:
                    showEquipmentDetails(equipmentSystem);
                    break;

                case 9:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }

        }while(choice != 9);
    }

    public static void newEquipment(EquipmentManagementSystem equipmentSystem)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Equipment Code: ");
        int code = input.nextInt();
        input.nextLine();

        System.out.print("Equipment Name: ");
        String name = input.nextLine();

        System.out.print("Serial Number: ");
        String serialNumber = input.nextLine();

        System.out.print("Cost: ");
        double cost = input.nextDouble();

        equipmentSystem.addEquipment(code, name, serialNumber, cost);

        System.out.println();
    }

    public static void updateEquipment(EquipmentManagementSystem equipmentSystem)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Equipment Code: ");
        int code = input.nextInt();
        input.nextLine();

        System.out.print("New equipment name: ");
        String name = input.nextLine();

        System.out.print("New cost: ");
        double cost = input.nextDouble();

        equipmentSystem.updateEquipment(code, name, cost);

        System.out.println();
    }

    public static void deleteEquipment(EquipmentManagementSystem equipmentSystem)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Equipment Code: ");
        int code = input.nextInt();

        equipmentSystem.deleteEquipment(code);

        System.out.println();
    }

    public static void showEquipment(EquipmentManagementSystem equipmentSystem)
    {
        System.out.println("Equipment Records are being listed!");

        equipmentSystem.listEquipment();

        System.out.println();
    }

    public static void assignEmployee(EquipmentManagementSystem equipmentSystem)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Equipment Code: ");
        int code = input.nextInt();

        System.out.print("Employee ID: ");
        int employeeId = input.nextInt();

        equipmentSystem.assignEmployee(code, employeeId);

        System.out.println();
    }

    public static void removeEmployee(EquipmentManagementSystem equipmentSystem)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Equipment Code: ");
        int code = input.nextInt();

        System.out.print("Employee ID: ");
        int employeeId = input.nextInt();

        equipmentSystem.removeEmployee(code, employeeId);

        System.out.println();
    }

    public static void assignSpecialist(EquipmentManagementSystem equipmentSystem)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Equipment Code: ");
        int code = input.nextInt();

        System.out.print("IT Specialist ID: ");
        int specialistId = input.nextInt();

        equipmentSystem.assignSpecialist(code, specialistId);

        System.out.println();
    }

    public static void showEquipmentDetails(EquipmentManagementSystem equipmentSystem)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Equipment Code: ");
        int code = input.nextInt();

        equipmentSystem.showEquipmentDetails(code);

        System.out.println();
    }
}
