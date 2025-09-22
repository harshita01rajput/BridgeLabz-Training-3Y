import java.util.*;
interface ID{void ad(double d);} // discountable

class B{
    String t,a;private double p;private int s; // title,author,price,stock
    public B(String t,String a,double p,int s){this.t=t;this.a=a;this.p=p;this.s=s;}
    public void updStock(int q){s-=q;} // encapsulated stock update
    public double getP(){return p;}
    public void disp(){System.out.println("Book:"+t+" Author:"+a+" Price:"+p+" Stock:"+s);}
}

class EB extends B implements ID{ // EBook
    public EB(String t,String a,double p,int s){super(t,a,p,s);}
    public void ad(double d){System.out.println("EBook discount:"+d);}
}

class PB extends B implements ID{ // PrintedBook
    public PB(String t,String a,double p,int s){super(t,a,p,s);}
    public void ad(double d){System.out.println("PrintedBook discount:"+d);}
}

class O{
    private ArrayList<B> bl=new ArrayList<>();private double total;private String status;
    public O(){total=0;status="Pending";}
    public void add(B b,int qty){bl.add(b);total+=b.getP()*qty;b.updStock(qty);}
    public void applyDiscount(double d){total-=d;}
    public void disp(){System.out.println("Order Total:"+total+" Status:"+status+" Books:"+bl.size());for(B b:bl)b.disp();}
}

public class BookBazaar{
    public static void main(String[] args){
        B b1=new EB("Java","AuthorA",500,10);
        B b2=new PB("Python","AuthorB",700,5);

        O o=new O();
        o.add(b1,2);o.add(b2,1);
        b1.ad(50);b2.ad(100);
        o.applyDiscount(150);
        o.disp();
    }
}
