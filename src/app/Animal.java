package app;

public class Animal {
    private static int animalCount = 0;
    private final String name;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public void run(int distance) {
        System.out.println(name + " пробіг " + distance + " м.");
    }

    public void swim(int distance) {
        System.out.println(name + " проплив " + distance + " м.");
    }

    public String getName() {
        return name;
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}
