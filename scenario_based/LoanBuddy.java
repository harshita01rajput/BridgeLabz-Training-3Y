import java.util.*;
interface IA{void ap();void emi();} // approvable

class App{
    String n;private int cs;private double inc,la; // name, creditScore, income, loanAmount
    public App(String n,int cs,double inc,double la){this.n=n;this.cs=cs;this.inc=inc;this.la=la;}
    public int getCS(){return cs;} // encapsulated
    public double getInc(){return inc;}
    public double getLA(){return la;}
}

class Loan{
    protected String t;protected int term;protected double ir;private String status;
    public Loan(String t,int term,double ir){this.t=t;this.term=term;this.ir=ir;status="Pending";}
    protected void setStatus(String s){status=s;}
    public String getStatus(){return status;}
}

class PL extends Loan implements IA{ // Personal Loan
    App a;
    public PL(App a,int term,double ir){super("Personal",term,ir);this.a=a;}
    public void ap(){if(a.getCS()>600 && a.getLA()<a.getInc()*5){setStatus("Approved");}else{setStatus("Rejected");}System.out.println("Status:"+getStatus());}
    public void emi(){double R=ir/12/100;int N=term*12;double P=a.getLA();double e=P*R*Math.pow(1+R,N)/(Math.pow(1+R,N)-1);System.out.println("EMI:"+e);}
}

class HL extends Loan implements IA{ // Home Loan
    App a;
    public HL(App a,int term,double ir){super("Home",term,ir);this.a=a;}
    public void ap(){if(a.getCS()>650){setStatus("Approved");}else{setStatus("Rejected");}System.out.println("Status:"+getStatus());}
    public void emi(){double R=ir/12/100;int N=term*12;double P=a.getLA();double e=P*R*Math.pow(1+R,N)/(Math.pow(1+R,N)-1);System.out.println("Home EMI:"+e);}
}

class AL extends Loan implements IA{ // Auto Loan
    App a;
    public AL(App a,int term,double ir){super("Auto",term,ir);this.a=a;}
    public void ap(){if(a.getCS()>620 && a.getLA()<a.getInc()*3){setStatus("Approved");}else{setStatus("Rejected");}System.out.println("Status:"+getStatus());}
    public void emi(){double R=ir/12/100;int N=term*12;double P=a.getLA();double e=P*R*Math.pow(1+R,N)/(Math.pow(1+R,N)-1);System.out.println("Auto EMI:"+e);}
}

public class LoanBuddy{
    public static void main(String[] args){
        App a1=new App("Ravi",700,50000,200000);
        PL pl=new PL(a1,2,12);
        HL hl=new HL(a1,15,8);
        AL al=new AL(a1,3,10);

        pl.ap();pl.emi();
        hl.ap();hl.emi();
        al.ap();al.emi();
    }
}
