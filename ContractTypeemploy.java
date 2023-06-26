class ContractTypeemploy extends Employee
{
    private Double contractamount;
    ContractTypeemploy(int id,String name,int employtype,double contractamount)
    {
        super(id,name,employtype);
        this.contractamount=contractamount;
    }

    @Override
    double Calculatesalary() {
        return contractamount;
    }

    @Override
    void displaydetails() {

        super.displaydetails();
        System.out.println("Employ Type Contract");

        System.out.println("Contract Amount  "+contractamount);
    }


}