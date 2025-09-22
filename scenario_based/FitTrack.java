import java.util.*;
interface IT{void sw();void ew();} // workout abstraction

class UP{
    protected String n;private int a,w;private String g; // name,age,weight,goal
    public UP(String n,int a,int w,String g){this.n=n;this.a=a;this.w=w;this.g=g;}
    public void disp(){System.out.println("User:"+n+" Age:"+a+" Weight:"+w+" Goal:"+g);}
    public int getW(){return w;} // encapsulated weight
    public void setW(int w){this.w=w;}
}

class W{
    protected String t;protected int d;protected double c; // type,duration,calories
    public W(String t,int d){this.t=t;this.d=d;c=0;}
    public void disp(){System.out.println("Workout:"+t+" Duration:"+d+" Calories:"+c);}
}

class CW extends W implements IT{ // Cardio
    public CW(String t,int d){super(t,d);}
    public void sw(){c=d*10;System.out.println("Cardio started");}
    public void ew(){System.out.println("Cardio ended, calories:"+c);}
}

class SW extends W implements IT{ // Strength
    public SW(String t,int d){super(t,d);}
    public void sw(){c=d*8;System.out.println("Strength started");}
    public void ew(){System.out.println("Strength ended, calories:"+c);}
}

public class FitTrack{
    public static void main(String[] args){
        UP u=new UP("Ravi",25,70,"Lose Weight");
        CW cw=new CW("Running",30);
        SW sw=new SW("Weights",45);

        cw.sw();cw.ew();sw.sw();sw.ew();
        u.disp();cw.disp();sw.disp();
    }
}
