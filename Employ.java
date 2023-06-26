import java.util.Scanner;

class Employee implements Comparable<Employee>
{
    private int id;
    private String name;

    private int employtype;
    Employee(int id,String name,int employtype)
    {
        this.id=id;
        this.name=name;
        this.employtype=employtype;
    }
    String getName()
    {
        return name;
    }
    int getId()
    {
        return id;
    }
    int getemploytype()
    {
        return employtype;
    }

    double Calculatesalary( )
    {
        return 0.0;
    }

    void displaydetails()
    {
        System.out.println("Id Of An Employ   "+id);
        System.out.println("Name Of An Employ   "+name);
    }
    Scanner sc=new Scanner(System.in);



    public int compareTo(Employee employ)
    {
        Scanner sc=new Scanner(System.in);
        double k = this.Calculatesalary() - employ.Calculatesalary();
        return (int) k;


    }

}
