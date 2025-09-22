import java.util.*;
interface IC{void gc();} // certificate abstraction

class U{
    protected String n,e,id; // name,email,userId
    public U(String n,String e,String id){this.n=n;this.e=e;this.id=id;}
    public void disp(){System.out.println("User:"+n+" Email:"+e+" ID:"+id);}
}

class L extends U{
    public L(String n,String e,String id){super(n,e,id);}
}

class I extends U implements IC{
    public I(String n,String e,String id){super(n,e,id);}
    public void gc(){System.out.println("Instructor "+n+" generated certificate");}
}

class Q{
    private String[] qs,ans;private int sc;
    public Q(String[] qs,String[] ans){this.qs=qs;this.ans=ans;sc=0;} // quiz init
    public void take(String[] ua){for(int i=0;i<ua.length;i++) if(ua[i].equals(ans[i])) sc++;} // score
    public double getPerc(){return (double)sc/qs.length*100;}
    public void disp(){System.out.println("Score:"+sc+" Percent:"+getPerc());}
}

public class Edumentor{
    public static void main(String[] args){
        L l=new L("Ravi","ravi@edu.com","L001");
        I i=new I("Dr.Amit","amit@edu.com","I001");

        String[] qs={"Q1","Q2"};String[] ans={"A","B"};
        Q q=new Q(qs,ans);

        String[] ua={"A","B"};q.take(ua);
        q.disp();
        i.gc();
        l.disp();
    }
}
