import java.util.*;
interface T{void tf(User r,double a);} // transfer abstraction

class User{
    String n;Wallet w;
    public User(String n,double b){this.n=n;w=new Wallet(b);}
    public void disp(){System.out.println("User:"+n+" Balance:"+w.getB());}
}

class Wallet{
    private double b;
    public Wallet(double b){this.b=b;}
    public double getB(){return b;} // balance access
    public void add(double a){b+=a;} // load money
    public void deduct(double a){b-=a;} // deduct money
}

class PersonalWallet extends Wallet implements T{
    public PersonalWallet(double b){super(b);}
    public void tf(User r,double a){
        if(a>getB()) System.out.println("Insufficient funds!");
        else{deduct(a);r.w.add(a);System.out.println("Transferred:"+a+" to "+r.n);}
    }
}

class BusinessWallet extends Wallet implements T{
    public BusinessWallet(double b){super(b);}
    public void tf(User r,double a){
        if(a>getB()||a>10000) System.out.println("Limit exceeded!");
        else{deduct(a);r.w.add(a);System.out.println("Business Transfer:"+a+" to "+r.n);}
    }
}

public class EwallletApplication{
    public static void main(String[] args){
        User u1=new User("Ravi",5000);
        User u2=new User("Sita",2000);

        PersonalWallet pw=new PersonalWallet(u1.w.getB());
        BusinessWallet bw=new BusinessWallet(u2.w.getB());

        pw.tf(u2,1000);bw.tf(u1,500);pw.tf(u2,6000); // transfers

        u1.disp();u2.disp();
    }
}
