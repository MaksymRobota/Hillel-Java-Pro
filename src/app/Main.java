package app;

public class Main {

    public static void main(String[] args) {
        Dog dogBobik = new Dog("Бобік");
        Cat catMurzik = new Cat("Мурзик");

        dogBobik.run(150);
        dogBobik.swim(10);

        catMurzik.run(200);
        catMurzik.swim(5);

        System.out.println("Кількість створених тварин: " + Animal.getAnimalCount());
        System.out.println("Кількість створених собак: " + Dog.getDogCount());
        System.out.println("Кількість створених котів: " + Cat.getCatCount());
    }
}