public abstract class ManagementSystem {
    public abstract void addRecord(int id, String name, String email, String extraInfo);

    public abstract void listRecords();

    public abstract void updateRecord(int id, String name, String email);

    public abstract void deleteRecord(int id);
}

