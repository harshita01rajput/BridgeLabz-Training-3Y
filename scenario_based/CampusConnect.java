import java.util.*;
interface CA{void ec(C c);void dc(C c);} // course actions

class P{
    protected String n,e,id; // person name,email,id
    public P(String n,String e,String id){this.n=n;this.e=e;this.id=id;}
    public void disp(){System.out.println("Person:"+n+" Email:"+e+" ID:"+id);}
}

class S extends P{
    private double gpa;
    public S(String n,String e,String id){super(n,e,id);gpa=0;}
    public void ec(C c){c.addS(this);System.out.println(n+" enrolled in "+c.n);}
    public void dc(C c){c.rmS(this);System.out.println(n+" dropped "+c.n);}
    public void setGPA(double g){gpa=g;}
    public void printDetails(){System.out.println("Student:"+n+" GPA:"+gpa);}
}

class F extends P{
    public F(String n,String e,String id){super(n,e,id);}
    public void printDetails(){System.out.println("Faculty:"+n);}
}

class C{
    String n;F f;ArrayList<S> sl=new ArrayList<>();
    public C(String n,F f){this.n=n;this.f=f;}
    public void addS(S s){sl.add(s);}
    public void rmS(S s){sl.remove(s);}
    public void disp(){System.out.println("Course:"+n+" Faculty:"+f.n+" Students:"+sl.size());}
}

public class CampusConnect{
    public static void main(String[] args){
        F f1=new F("Dr.Amit","amit@uni.com","F001");
        S s1=new S("Ravi","ravi@uni.com","S001");
        S s2=new S("Sita","sita@uni.com","S002");
        C c1=new C("Math",f1);

        s1.ec(c1);s2.ec(c1);
        s1.setGPA(9.0);s2.setGPA(8.5);

        s1.printDetails();s2.printDetails();
        f1.printDetails();
        c1.disp();

        s2.dc(c1);
        c1.disp();
    }
}
