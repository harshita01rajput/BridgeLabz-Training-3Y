interface G{void ag(String g);} // grading abstraction

class S{
    private String n;private double gpa; // name, GPA
    public S(String n){this.n=n;gpa=0;} // student create
    public String tr(){return n+" GPA:"+gpa;} // transcript
    public void setG(double g){gpa=g;} // gpa set
    public void disp(){System.out.println("Student:"+tr());}
}

class UG extends S{
    public UG(String n){super(n);}
}

class PG extends S{
    public PG(String n){super(n);}
}

class C{
    String n; // course name
    public C(String n){this.n=n;}
    public void disp(){System.out.println("Course:"+n);}
}

class F implements G{
    String n;
    public F(String n){this.n=n;}
    public void ag(String g){System.out.println("Faculty "+n+" assigned grade:"+g);}
}

class E{
    S s;C c;String grade;
    public E(S s,C c){this.s=s;this.c=c;}
    public void assign(String g){grade=g;((G)new F("Prof")).ag(g);}
    public void disp(){System.out.println(s.tr()+" Course:"+c.n+" Grade:"+grade);}
}

public class UniversitySystem{
    public static void main(String[] args){
        S s1=new UG("Ravi");
        S s2=new PG("Sita");
        C c1=new C("Math");C c2=new C("Physics");

        E e1=new E(s1,c1);E e2=new E(s2,c2);

        e1.assign("A");e2.assign("Pass");

        s1.disp();s2.disp();c1.disp();c2.disp();
        e1.disp();e2.disp();
    }
}
