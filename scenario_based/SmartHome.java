interface C{void on();void off();} // control abstraction

class A{
    protected String n;protected int p; // name, power
    public A(String n,int p){this.n=n;this.p=p;}
    public void disp(){System.out.println("Appliance:"+n+" Power:"+p);}
}

class L extends A implements C{
    public L(String n,int p){super(n,p);}
    public void on(){System.out.println("Light "+n+" ON at "+p+"W");}
    public void off(){System.out.println("Light "+n+" OFF");}
}

class F extends A implements C{
    public F(String n,int p){super(n,p);}
    public void on(){System.out.println("Fan "+n+" ON at "+p+"W");}
    public void off(){System.out.println("Fan "+n+" OFF");}
}

class AC extends A implements C{
    public AC(String n,int p){super(n,p);}
    public void on(){System.out.println("AC "+n+" ON at "+p+"W Cooling");}
    public void off(){System.out.println("AC "+n+" OFF");}
}

class UC{
    public void ctrl(C c,boolean state){if(state)c.on();else c.off();} // user control
}

public class SmartHome{
    public static void main(String[] args){
        L l=new L("LivingRoom",60);
        F f=new F("BedRoom",50);
        AC a=new AC("LivingRoom",150);
        UC u=new UC();

        u.ctrl(l,true);u.ctrl(f,true);u.ctrl(a,true);
        u.ctrl(f,false);u.ctrl(a,false);

        l.disp();f.disp();a.disp();
    }
}
