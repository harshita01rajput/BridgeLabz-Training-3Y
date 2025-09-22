import java.util.*;
interface RS{void br(int d);void er();} // ride service abstraction

class V{
    protected String no,type;protected int cap;private double fare; // vehicle
    public V(String no,String t,int c){this.no=no;type=t;cap=c;fare=0;}
    public void setFare(double f){fare=f;} 
    public double getFare(){return fare;}
    public void disp(){System.out.println("Vehicle:"+no+" Type:"+type+" Cap:"+cap+" Fare:"+fare);}
}

class Mini extends V implements RS{
    public Mini(String n,int c){super(n,"Mini",c);}
    public void br(int d){setFare(50+d*10);System.out.println("Mini booked, fare:"+getFare());}
    public void er(){System.out.println("Mini ride ended, fare:"+getFare());}
}

class Sedan extends V implements RS{
    public Sedan(String n,int c){super(n,"Sedan",c);}
    public void br(int d){setFare(100+d*15);System.out.println("Sedan booked, fare:"+getFare());}
    public void er(){System.out.println("Sedan ride ended, fare:"+getFare());}
}

class SUV extends V implements RS{
    public SUV(String n,int c){super(n,"SUV",c);}
    public void br(int d){setFare(150+d*20);System.out.println("SUV booked, fare:"+getFare());}
    public void er(){System.out.println("SUV ride ended, fare:"+getFare());}
}

class D{
    private String n,lic;private double r; // driver
    public D(String n,String l,double r){this.n=n;lic=l;this.r=r;}
    public void disp(){System.out.println("Driver:"+n+" License:"+lic+" Rating:"+r);}
}

public class CAbbyGo{
    public static void main(String[] args){
        V v1=new Mini("MH01AB1234",4);
        V v2=new Sedan("MH02CD5678",4);
        V v3=new SUV("MH03EF9012",6);

        D d1=new D("Ravi","LIC123",4.5);
        D d2=new D("Sita","LIC456",4.8);

        v1.br(10);
        
        v2.br(5);
        v3.br(8);
        v1.er();
        v2.er();
        v3.er();

        v1.disp();v2.disp();v3.disp();
        d1.disp();d2.disp();
    }
}
