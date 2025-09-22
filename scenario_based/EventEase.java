import java.util.*;
interface IS{void sch();void resch();void cncl();} // schedulable

class U{
    String n,e; // name,email
    public U(String n,String e){this.n=n;this.e=e;}
    public void disp(){System.out.println("User:"+n+" Email:"+e);}
}

class E{
    protected String n,l,d;private double cost;private ArrayList<U> att=new ArrayList<>();
    public E(String n,String l,String d){this.n=n;this.l=l;this.d=d;cost=0;}
    public void addAtt(U u){att.add(u);}
    public void setCost(double c){cost=c;}
    public double getCost(){return cost;}
    public void disp(){System.out.println("Event:"+n+" Loc:"+l+" Date:"+d+" Cost:"+cost+" Attendees:"+att.size());}
}

class BE extends E implements IS{ // Birthday Event
    public BE(String n,String l,String d){super(n,l,d);}
    public void sch(){setCost(1000);System.out.println("Birthday scheduled, cost:"+getCost());}
    public void resch(){System.out.println("Birthday rescheduled");}
    public void cncl(){System.out.println("Birthday cancelled");}
}

class CE extends E implements IS{ // Conference Event
    public CE(String n,String l,String d){super(n,l,d);}
    public void sch(){setCost(5000);System.out.println("Conference scheduled, cost:"+getCost());}
    public void resch(){System.out.println("Conference rescheduled");}
    public void cncl(){System.out.println("Conference cancelled");}
}

public class EventEase{
    public static void main(String[] args){
        U u1=new U("Ravi","ravi@mail.com");
        U u2=new U("Sita","sita@mail.com");

        BE b=new BE("RaviBirthday","Mumbai","2025-10-01");
        b.addAtt(u1);b.addAtt(u2);
        b.sch();b.disp();

        CE c=new CE("TechConf","Delhi","2025-12-10");
        c.addAtt(u1);c.sch();c.disp();
        c.cncl();
    }
}
