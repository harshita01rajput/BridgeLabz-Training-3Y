 
class Animal1 {
    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog1 extends Animal1 {
    void bark() {
        System.out.println("Dog is barking");
    }
}

class SingleLevelDemo {
    public static void main(String[] args) {
        Dog1 dog = new Dog1();
        dog.eat();
        dog.bark();
    }
}


// Multi Level Inheritance Example
class Animal2 {
    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog2 extends Animal2 {
    void bark() {
        System.out.println("Dog is barking");
    }
}

class Puppy extends Dog2 {
    void play() {
        System.out.println("Puppy is playing");
    }
}

class MultiLevelDemo {
    public static void main(String[] args) {
        Puppy puppy = new Puppy();
        puppy.eat();
        puppy.bark();
        puppy.play();
    }
}


// Hierarchical Inheritance Example
class Animal3 {
    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog3 extends Animal3 {
    void bark() {
        System.out.println("Dog is barking");
    }
}

class Cat extends Animal3 {
    void meow() {
        System.out.println("Cat is meowing");
    }
}

public class level1 {  
    public static void main(String[] args) {
        Dog3 dog = new Dog3();
        dog.eat();
        dog.bark();

        Cat cat = new Cat();
        cat.eat();
        cat.meow();
    }
}
