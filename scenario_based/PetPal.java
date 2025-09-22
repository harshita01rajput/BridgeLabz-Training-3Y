interface I{void f();void p();void s();} // interactable

class Pet{
    protected String n,t;protected int a;private int h,m; // name,type,age,hunger,mood
    public Pet(String n,String t,int a){this.n=n;this.t=t;this.a=a;h=50;m=50;} // default
    public void setMood(int m){this.m=m;} // encapsulated
    public int getMood(){return m;}
    public void setHunger(int h){this.h=h;}
    public int getHunger(){return h;}
    public void disp(){System.out.println(t+" "+n+" Age:"+a+" Hunger:"+h+" Mood:"+m);}
}

class Dog extends Pet implements I{
    public Dog(String n,int a){super(n,"Dog",a);}
    public void f(){setHunger(getHunger()-10);System.out.println(n+" fed");}
    public void p(){setMood(getMood()+10);System.out.println(n+" played");}
    public void s(){setMood(getMood()+5);System.out.println(n+" slept");}
    public void makeSound(){System.out.println(n+" says Woof!");}
}

class Cat extends Pet implements I{
    public Cat(String n,int a){super(n,"Cat",a);}
    public void f(){setHunger(getHunger()-8);System.out.println(n+" fed");}
    public void p(){setMood(getMood()+8);System.out.println(n+" played");}
    public void s(){setMood(getMood()+4);System.out.println(n+" slept");}
    public void makeSound(){System.out.println(n+" says Meow!");}
}

class Bird extends Pet implements I{
    public Bird(String n,int a){super(n,"Bird",a);}
    public void f(){setHunger(getHunger()-5);System.out.println(n+" fed");}
    public void p(){setMood(getMood()+6);System.out.println(n+" played");}
    public void s(){setMood(getMood()+3);System.out.println(n+" slept");}
    public void makeSound(){System.out.println(n+" says Chirp!");}
}

public class PetPal{
    public static void main(String[] args){
        Dog d=new Dog("Buddy",3);
        Cat c=new Cat("Kitty",2);
        Bird b=new Bird("Tweety",1);

        d.f();d.p();d.s();d.makeSound();
        c.f();c.p();c.s();c.makeSound();
        b.f();b.p();b.s();b.makeSound();

        d.disp();c.disp();b.disp();
    }
}
