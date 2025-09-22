interface R{double rnt(int d);} // rent abstraction

class V{
    protected String n;protected double b; // name, base
    public V(String n,double b){this.n=n;this.b=b;} 
    public void d(){System.out.println("Veh:"+n+" Base:"+b);}
}

class B extends V implements R{
    public B(String n,double b){super(n,b);}
    public double rnt(int d){return b*d;} 
    public void d(){System.out.println("Bike:"+n+" Rent/Day:"+b);}
}

class C extends V implements R{
    public C(String n,double b){super(n,b);}
    public double rnt(int d){return b*d+50;} 
    public void d(){System.out.println("Car:"+n+" Rent/Day:"+b);}
}

class T extends V implements R{
    public T(String n,double b){super(n,b);}
    public double rnt(int d){return b*d+100;} 
    public void d(){System.out.println("Truck:"+n+" Rent/Day:"+b);}
}

class Cust{
    private String n;private V v;private int d;
    public Cust(String n,V v,int d){this.n=n;this.v=v;this.d=d;}
    public void pr(){System.out.println(n+" Rent:"+((R)v).rnt(d));}
}

public class VechicleRental{
    public static void main(String[] args){
        V b=new B("Bullet",500);
        V c=new C("Swift",1000);
        V t=new T("Tata",2000);

        Cust c1=new Cust("Ravi",b,3);
        Cust c2=new Cust("Sita",c,2);
        Cust c3=new Cust("Amit",t,1);

        b.d();c.d();t.d();
        c1.pr();c2.pr();c3.pr();
    }
}
