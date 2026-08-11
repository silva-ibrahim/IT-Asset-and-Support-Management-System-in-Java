public class Person {
    private int id;
    private String name;
    private String email;

    Person(int id, String name, String email)
    {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setName(String newName)
    {
        name = newName;
    }

    public void setEmail(String newEmail)
    {
        email = newEmail;
    }

    @Override
    public String toString()
    {
        return "ID: " + id + " - Name: " + name + " - E-mail: " + email;
    }
}

