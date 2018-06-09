import java.util.*;
class YearCalender
{
    int year; String day;
    public YearCalender()
    {
        year = 0;
        day = "";
    }
    public void input()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Year: ");
        year = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the First Day of the Year: ");
        day = sc.nextLine();
    }
    public boolean checkLeap()
    {
        if(year % 4 == 0)
        return true;
        else
        return false;
    }
    public void generate()
    {
        String month[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        for(int i = 0; i < month.length; i++)
        {
            MonthCalender ob;
            if(i + 1 == 2 && checkLeap() == true)
            ob = new MonthCalender(day, month[i], true);
            else
            ob = new MonthCalender(day, month[i], false);
            System.out.println("\n" + "\t\t\t" + month[i] + "\t" + year);
            System.out.println("\t\t\t" + "____________" + "\n");
            ob.calender();            
            day = ob.nd;
        }
    }
    public static void main()
    {        
        YearCalender ob = new YearCalender();        
        ob.input();
        System.out.println("\t  --------------------------------------------------");
        System.out.println("\t\t\t" + "Year" + "\t" + ob.year);
        System.out.println("\t  --------------------------------------------------");
        ob.generate();
    }
}
