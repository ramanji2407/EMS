class PartTimeemploy extends Employee
{
    private double noofhours;
    private double costperhr;

    PartTimeemploy(int id,String name,int employtype,double noofhours, double costperhr)
    {
        super(id,name,employtype);
        this.costperhr=costperhr;
        this.noofhours=noofhours;


    }
    @Override
    double Calculatesalary() {
        return noofhours*costperhr;
    }

    @Override
    void displaydetails() {
        super.displaydetails();
        System.out.println("Employ Type Part Time");
        System.out.println(" Per Hour Salary"+" "+costperhr);
        System.out.println("No Of Hours Worked"+" "+noofhours);
        System.out.println("Salary Of Employ  "+Calculatesalary());
    }
}