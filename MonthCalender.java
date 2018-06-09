import java.util.*;
class MonthCalender
{
    String day, mon;
    String nd; boolean leap;
    public MonthCalender()
    {
        leap = false;
        day = "";
        mon = "";
        nd = "";
    }
    public MonthCalender(String x, String y, boolean leap)
    {
        this.leap = leap;
        day = x;
        mon = y;
        nd = "";
    }
    public void input()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the First Day of Month: ");
        day = sc.nextLine();
        System.out.print("Enter the Month: ");
        mon = sc.nextLine();
    }
    public void calender()
    {
        int d = 0, m = 0;
        int td = 0;       
        String c[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String h[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        for(int i = 0; i < c.length; i++)
        {
            if(mon.equalsIgnoreCase(c[i]) == true)
            m = i + 1;
        }        
        for(int i = 0; i < h.length; i++)
        {
            if(day.equalsIgnoreCase(h[i]) == true)
            d = i;
        }
        if(m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12)
        td = 31;
        else if(m == 2 && leap == false)
        td = 28;
        else if(m == 2 && leap == true)
        td = 29;
        else
        td = 30;
        int r = 0, co = d, k = 1;
        int a[][] = new int[((td / 7) + 2)][7];
        while(r < ((td / 7) + 2) && k <= td)
        {
            a[r][co % 7] = k++;
            co++;
            r = co / 7;
        }
        nd = h[(co) % 7];
        display(a, td);
    }
    public void display(int a[][], int td)
    {
        System.out.println("\tSun\t" + "Mon\t" + "Tue\t" + "Wed\t" + "Thu\t" + "Fri\t" + "Sat");
        for(int i = 0; i < (td / 7) + 2; i++)
        {
            for(int j = 0; j < 7; j++)
            {
                if(a[i][j] != 0)
                System.out.print("\t" + a[i][j]);
                else
                System.out.print("\t");
            }
            System.out.println();
        }
    }
    public static void main()
    {      
        MonthCalender ob = new MonthCalender();
        ob.input();
        ob.calender();
    }
}
