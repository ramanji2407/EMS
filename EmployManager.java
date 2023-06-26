import java.util.Scanner;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
class EmployManager {
    Comparator<Employee> E=new Comparator<Employee>()
    {
        @Override
        public int compare(Employee o1, Employee o2) {
            if(o1.getId()> o2.getId())
            {
                return 1;
            }
            else
            {
                return -1;
            }
        }
    }   ;
    ArrayList<Employee> LIST = new ArrayList<>();




    void addEmploy(Employee employ)
    {
        LIST.add(employ);
    }


    void displayDetail()
    {
        Scanner scanner=new Scanner(System.in);
        int select=0;
        boolean selectemploy=false;
        while(!selectemploy)
        {
            try
            {
                System.out.println("1)Press 1 to display details of only Permanent employ\n2) Press 2 to display details of only part time\n3) Press 3 to display only contract type \n4) Press 4 to display all employs present in the list");

                select=scanner.nextInt();
                 if(select>0&&select<4)
                 {
                     selectemploy=true;
                 }
            }
            catch (Exception e)
            {
                System.out.println("Invalid input parameter");
                scanner.nextLine();
            }

                switch (select) {
                    case 1:
                        int select1=0;
                        for (int i = 0; i < LIST.size(); i++) {

                            if (LIST.get(i).getemploytype() == select)
                            {
                                LIST.get(i).displaydetails();
                                select1++;
                            }

                            System.out.println();
                        }
                        if(select1==1)
                        {
                            System.out.println("No employs were their to display");
                        }
                        break;
                    case 2:
                        int select2=0;
                        for (int i = 0; i < LIST.size(); i++) {

                            if (LIST.get(i).getemploytype() == select) {
                                LIST.get(i).displaydetails();
                                select2++;
                            }

                            System.out.println();
                        }
                        if(select2==0)
                        {
                            System.out.println("No employs were their to display");
                        }
                        break;
                    case 3:
                        int select3=0;
                        for (int i = 0; i < LIST.size(); i++) {

                            if (LIST.get(i).getemploytype() == select) {
                                LIST.get(i).displaydetails();
                                select3++;
                            }

                            System.out.println();
                        }
                        if(select3==0)
                        {
                            System.out.println("No employs were their to display");
                        }
                        break;
                    case 4:
                        for (int i = 0; i < LIST.size(); i++) {

                            LIST.get(i).displaydetails();

                            System.out.println();
                        }
                    default:
                        System.out.println("entered wrong no choose between 1 to 4");

                }

            }
        }


    Double calculatetotalsalary() {

        double Totalsalary = 0.0;
                for (int i = 0; i < LIST.size(); i++)
                {

                    Totalsalary += LIST.get(i).Calculatesalary();

                    System.out.println();
                }

        return Totalsalary;
    }
    void shiftingemployfromcontracttopermanent()
    {
        Scanner scanner=new Scanner(System.in);
        int IDEMPLOY=0;
        boolean IDEMPLOY1=false;
        while (!IDEMPLOY1)
        {
            try {
                System.out.println("Enter id you want to shift from contract to full-time");
                IDEMPLOY= scanner.nextInt();
                IDEMPLOY1=true;

            }
            catch (Exception E)
            {
                System.out.println(E);
            }
        }

        int addcountofemploy=0;

        for(int i=0;i< LIST.size();i++) {

            if(LIST.get(i).getId()==IDEMPLOY&&LIST.get(i).getemploytype()==3)
            {
                System.out.println("Enter the salary amount");
                double salary=scanner.nextDouble();
                LIST.add(new FullTimeEmploy(LIST.get(i).getId(), LIST.get(i).getName(), 1,salary));
                addcountofemploy++;
                System.out.println("Added Successfully");
                LIST.remove(i);
                System.out.println("Removed Successfully");
            }

        }
        if(addcountofemploy==0)
        {
            System.out.println("No employ were there in that id to shift or already that id present in permanant employ list");
        }
    }
    void shiftingemployfromparttopermanent()
    {
        Scanner scanner=new Scanner(System.in);
        int IDEMPLOY=0;
        boolean IDEMPLOY1=false;
        while (!IDEMPLOY1)
        {
            try {
                System.out.println("Enter id you want to shift from part time to full-time");

                IDEMPLOY= scanner.nextInt();
                IDEMPLOY1=true;

            }
            catch (Exception E)
            {
                System.out.println(E);
            }
        }
        int addcountofemploy=0;
        for(int i=0;i< LIST.size();i++) {

            if(LIST.get(i).getId()==IDEMPLOY&&LIST.get(i).getemploytype()==2)
            {
                System.out.println("Enter the salary amount");
                double salary=scanner.nextDouble();
                LIST.set(i,new FullTimeEmploy(LIST.get(i).getId(), LIST.get(i).getName(), 1,salary));
                System.out.println("Added Successfully");
                addcountofemploy++;


            }


        }
        if(addcountofemploy==0)
        {
            System.out.println("No employ were there in that id to shift or already that id present in permanent employ list");

        }
    }
double calculatesalarysbyemploymenttype()
{
    Scanner scanner=new Scanner(System.in);

    int select1 =0;
    boolean selectionofemploy=false;
    while (!selectionofemploy)
    {
        try
        {
            System.out.println("1)Press 1 to  calculate salary of only Permanent employ\n2) Press 2 to to  calculate salary of only part time employ \n3) Press 3 to to  calculate salary of only contract type");

        select1=scanner.nextInt();
        if(select1>0&&select1<4)
        {
            selectionofemploy=true;
        }
        else
        {
            System.out.println("Select between 1 to 3 0nly");
        }
        }
        catch (Exception E)
        {
            System.out.println("Enter only integer values");
            scanner.nextLine();
        }
    }
    double Totalsalary = 0.0;
    int employid=0;
    boolean employselect=false;
    while(!employselect)
    {
        try
        {
            System.out.println("Enter the id of Employ to get salary");
            employid= scanner.nextInt();
            employselect=true;
        }
        catch (Exception e)
        {
            System.out.println(e);
            scanner.nextLine();
        }
    }
    switch (select1)
    {
        case 1:
            int fUlltimeemployid= employid;
            for (int i = 0; i < LIST.size(); i++)
            {
                if(LIST.get(i).getemploytype()==select1&&LIST.get(i).getId()==fUlltimeemployid) {
                    int leaves=0;
                    boolean leaves1=false;
                    while (!leaves1)
                    {
                        try
                        {
                            System.out.println("Enter No of holidays did he taken");
                            leaves = scanner.nextInt();
                            if(leaves>=0&&leaves<=30)
                            {
                                leaves1=true;
                            }
                        }
                        catch (Exception E)
                        {
                            System.out.println(E);
                            scanner.nextLine();
                        }
                    }
                    Totalsalary += (double) LIST.get(i).Calculatesalary()-LIST.get(i).Calculatesalary()/30*leaves;
                    System.out.println(Totalsalary);
                }

                else
                {
                    System.out.println("No id were present in permanent employ list ");
                }

                System.out.println();
            }
            break;
        case 2:
            int parttimeemployid= employid;

            for (int i = 0; i < LIST.size(); i++)
            {

                if(LIST.get(i).getemploytype()==select1&&LIST.get(i).getId()==parttimeemployid)
                {
                    Totalsalary += LIST.get(i).Calculatesalary();
                }
                else
                {
                    System.out.println("No id were present in permanent employ list ");
                }

                System.out.println();
            }
            break;
            case 3:
            int contracttimeemployid= employid;
            for (int i = 0; i < LIST.size(); i++)
            {

                if(LIST.get(i).getemploytype()==select1&&LIST.get(i).getId()==contracttimeemployid)
                {
                    Totalsalary += LIST.get(i).Calculatesalary();
                }
                else
                {
                    System.out.println("No id were present in permanent employ list ");
                }
                System.out.println();
            }
            break;
        default:
            System.out.println("entered wrong no choose between 1 to 3");
    }

    return Totalsalary;
}
void sortbysalary()
    {
        Collections.sort(LIST);
        for (int i = 0; i < LIST.size(); i++)
        {

            LIST.get(i).displaydetails();

            System.out.println();
        }
    }
    void sortbyid()
    {
        Collections.sort(LIST,E);
        for (int i = 0; i < LIST.size(); i++)
        {

            LIST.get(i).displaydetails();

            System.out.println();
        }
    }
    void sortbyname()
    {
        for (int i=0;i< LIST.size();i++)
        {
            for(int j=0;j< LIST.size()-i-1;j++)
            {

                int comparename=LIST.get(j).getName().compareTo(LIST.get(j+1).getName());
                if(comparename>0)
                {
                    Employee temporaryemploydetails =LIST.get(j);
                    LIST.set(j,LIST.get(j+1));
                    LIST.set(j+1, temporaryemploydetails);
                }
            }
        }
        for (int i = 0; i < LIST.size(); i++)
        {

            LIST.get(i).displaydetails();

            System.out.println();
        }

    }
        public static void main(String[] args)
        {
            EmployManager employManagerobject
                    = new EmployManager();
            Scanner sc = new Scanner(System.in);
            String employeemailid="pasupuleti";
            String Employpassword="Gtm@1234";
            System.out.println("Enter emailid");
            String Employemailid=sc.next();
            System.out.println("Enter password");
            String employpassword=sc.next();
if((employeemailid.equals(Employemailid)&&(Employpassword.equals(employpassword))))
{
    ArrayList<Integer> idlist =new ArrayList<>();
    ArrayList<String> nameslist =new ArrayList<>();

    while (true) {
        System.out.println("====WELCOME TO LOGISOFT EMPLOYEE MANAGEMENT SYSTEM====");
        System.out.println("1)  Press 1 To add Employ\n2)  Press 2 to display all Employs\n3)  Press 3 to Calculate the salary of all employs\n4)  Press 4 to sort by salary of employ details\n5)  Press 5 to sort by id of employ details\n6)  Press 6 to sort by name of employ details\n7)  Press 7 Calculate the salary by employment type\n8)  Press 8 to shift employee from contract to permanent employee\n9)  Press 9 to shift employee from part-time to permanent employee\n10) Press 10 to Logout");

        try {
            int select = sc.nextInt();

            switch (select) {
                case 1:

                    int n1 = 0;
                    boolean input = false;
                    while (!input) {
                        try {
                            System.out.println("select what type of employ to add\n1)Permanent Employ\n2)PartTime Employ\n3)Contract Employ");

                            n1 = sc.nextInt();
                            if (n1 >= 1 && n1 <= 3) {
                                input = true;
                            } else {
                                System.out.println("Choose correct Option");
                            }
                            //input = true;
                        } catch (Exception E) {
                            System.out.println("Invalid input Parameter");
                            sc.nextLine();
                        }
                    }
                    //int n1 = sc.nextInt();


                    int id = 0;
                    boolean input1 = false;


                    while (!input1) {
                        System.out.print("Enter employee ID ");
                        try {
                            id = sc.nextInt();
                            if (id > 0) {

                                idlist.add(id);
                                int countid = 0;

                                for (int i = 0; i < idlist.size(); i++) {
                                    if (idlist.get(i) == id) {
                                        countid++;
                                    }
                                }
                                if (countid >= 2) {
                                    System.out.println("Already there is a employ with this id they are");

                                    for (int i = 0; i < idlist.size()-1; i++)
                                    {
                                        System.out.println( "Id of employee is:"+"   "+idlist.get(i)+"    "+"Name of the employ:"+"   "+nameslist.get(i));
                                    }
                                } else {
                                    input1 = true;
                                }
                            } else {
                                System.out.println("Id must be greater than 0");
                            }
                        } catch (Exception E) {
                            System.out.println("Invalid input Parameter");
                            sc.nextLine();
                        }
                    }

                    String name = "";
                    boolean input2 = false;
                    while (!input2) {

                        System.out.print("Enter employee name ");
                        sc.nextLine();
                        name = sc.nextLine();
                         nameslist.add(name);
                        int c = 0;
                        for (int i = 0; i < name.length(); i++) {
                            if ((name.charAt(i) >= 'a' && name.charAt(i) <= 'z') || (name.charAt(i) >= 'A' && name.charAt(i) <= 'z') || (name.charAt(i) == ' ')) {

                            } else {
                                c++;
                            }
                        }

                        if (c == 0) {
                            input2 = true;

                        } else {
                            System.out.println("Invalid input Parameter");

                        }
                    }
                    switch (n1) {
                        case 1:


                            boolean input3 = false;
                            double salary = 0.0;
                            while (!input3) {
                                try {
                                    System.out.println("Enter monthly salary");
                                    salary = sc.nextDouble();
                                    if (salary > 0) {
                                        input3 = true;
                                    } else {
                                        System.out.println(" salary must be greater than 0");
                                    }

                                } catch (Exception E) {
                                    System.out.println("Invalid input Parameter");
                                    sc.nextLine();
                                }
                            }
                            employManagerobject.addEmploy(new FullTimeEmploy(id, name, 1, salary));
                            break;
                        case 2:
                            double hourly = 0.0;
                            boolean input4 = false;
                            while (!input4) {
                                try {
                                    System.out.println("Enter hourly Salary");
                                    hourly = sc.nextDouble();
                                    if (hourly > 0) {
                                        input4 = true;
                                    } else {
                                        System.out.println("Hourly salary must be greater than");
                                    }

                                } catch (Exception E) {
                                    System.out.println("Invalid input Parameter");
                                    sc.nextLine();
                                }


                            }


                            //        double hour = sc.nextDouble();
                            double hour = 0.0;
                            boolean input5 = false;
                            while (!input5) {
                                try {
                                    System.out.println("Enter no of hours worked");
                                    hour = sc.nextDouble();
                                    if (hour > 0) {
                                        input5 = true;
                                    } else {
                                        System.out.println("No of working hours greater than 0");
                                    }
                                } catch (Exception E) {
                                    System.out.println("Invalid input Parameter");
                                    sc.nextLine();
                                }

                            }

                            PartTimeemploy parttimeemployeobject = new PartTimeemploy(id, name, 2, hourly, hour);
                            employManagerobject.addEmploy(parttimeemployeobject);
                            break;
                        case 3:
                            System.out.println("Enter contract Salary");
                            boolean input6 = false;
                            double contractsalary = 0.0;
                            while (!input6) {
                                try {
                                    System.out.println("Enter contract Salary");
                                    contractsalary = sc.nextDouble();
                                    if (contractsalary > 0) {
                                        input6 = true;
                                    } else {
                                        System.out.println("Contract salary must be greater than 0");
                                    }
                                } catch (Exception E) {
                                    System.out.println("Invalid input Parameter");
                                    sc.nextLine();
                                }

                            }
                            employManagerobject.addEmploy(new ContractTypeemploy(id, name, 3, contractsalary));
                            break;
                        default:
                            System.out.println("your requested invalid employ type");
                            break;
                    }
                    break;

                case 2:
                    if (employManagerobject.calculatetotalsalary() == 0.0) {
                        System.out.println("NO EMPLOYEE WERE IN RECORD");
                    }
                    else

                    {
                        employManagerobject.displayDetail();
                    }
                    break;
                case 3:
                    if (employManagerobject.calculatetotalsalary() > 0.0)
                        System.out.println("sum of the salary all employs is  " + employManagerobject.calculatetotalsalary());
                    else {
                        System.out.println("No Employees were there to get salary");
                    }
                    break;
                case 4:
                    if (employManagerobject.calculatetotalsalary() == 0.0) {
                        System.out.println("No data available to sort");
                    } else {
                        employManagerobject.sortbysalary();
                        System.out.println("Sorted by salary successfully");
                    }
                    break;
                case 5:
                    if (employManagerobject.calculatetotalsalary() == 0.0) {
                        System.out.println("No data available to sort");
                    } else {
                        employManagerobject.sortbyid();
                        System.out.println("Sorted by Id successfully");
                    }
                    break;
                case 6:
                    if (employManagerobject.calculatetotalsalary() == 0.0) {
                        System.out.println("No data available to sort");
                    } else {
                        employManagerobject.sortbyname();
                        System.out.println("Sorted by name successfully");
                    }
                    break;
                case 7:
                    if (employManagerobject.calculatetotalsalary() > 0.0)
                    {
                        System.out.println("The salary of employee is  " + employManagerobject.calculatesalarysbyemploymenttype ());
                    }
                    else
                    {
                    System.out.println("No Employees were there to get salary");
                    }
                break;

                case 8:

                    if (employManagerobject.calculatetotalsalary() > 0.0)
                    {
                        employManagerobject.shiftingemployfromcontracttopermanent();
                    }
                    else
                    {
                        System.out.println("No employees were present to shift employee");
                    }
                    break;
                case 9:

                    if (employManagerobject.calculatetotalsalary() > 0.0)
                    {
                        employManagerobject.shiftingemployfromparttopermanent();
                    }
                    else
                    {
                        System.out.println("No employees were present to shift employee");
                    }
                    break;
                case 10:
                    System.out.println("Logout Successfully");
                    System.exit(1);

                default:
                    System.out.println("entered wrong no choose between 1 to 10");
            }

        }
        catch (Exception E) {
            // E.printStackTrace();
            System.out.println("Enter correct data type");
        }
        sc.nextLine();

    }
         }
            else
            {
                System.out.println("Wrong details to acess portal");
            }

        }

    }


