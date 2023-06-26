class FullTimeEmploy extends Employee
{

    private double salary;
    FullTimeEmploy(int id,String name,int employtype,double salary)
    {
        super(id,name,employtype);
        this.salary=salary;

    }

    @Override
    double Calculatesalary() {

        return salary ;
    }

    @Override
    void displaydetails() {
        super.displaydetails();
        System.out.println("Employ Type Permanent");

        System.out.println("Monthly Salary "+" "+Calculatesalary());
    }


}
