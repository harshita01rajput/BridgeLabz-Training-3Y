import java.util.*;
interface IC{void gb();void ad(double d);} // checkout abstraction

class P{
    String n,c;double p; // name, category, price
    public P(String n,double p,String c){this.n=n;this.p=p;this.c=c;}
    public void disp(){System.out.println("Product:"+n+" Price:"+p+" Cat:"+c);}
}

class PP extends P{ // Perishable
    public PP(String n,double p){super(n,p,"Perishable");}
}

class NP extends P{ // Non-Perishable
    public NP(String n,double p){super(n,p,"Non-Perishable");}
}

class Cart implements IC{
    private ArrayList<P> pl=new ArrayList<>();private double tp;
    public Cart(){tp=0;}
    public Cart(ArrayList<P> l){pl=l;calcTP();}
    public void add(P p){pl.add(p);tp+=p.p;}
    private void calcTP(){tp=0;for(P p:pl) tp+=p.p;} // total price calc
    public void gb(){System.out.println("Total Bill:"+tp);}
    public void ad(double d){tp-=d;System.out.println("After Discount:"+tp);}
    public void disp(){for(P p:pl) p.disp();}
}

public class SwiftCart{
    public static void main(String[] args){
        P p1=new PP("Milk",50);
        P p2=new NP("Soap",30);
        Cart c=new Cart();
        c.add(p1);c.add(p2);
        c.disp();c.gb();c.ad(10); // add discount
    }
}
