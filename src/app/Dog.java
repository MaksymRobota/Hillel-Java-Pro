package app;

import static app.util.AppConstants.MAX_DOG_RUN_DISTANCE;
import static app.util.AppConstants.MAX_DOG_SWIM_DISTANCE;

public class Dog extends Animal {
    private static int dogCount = 0;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_DOG_RUN_DISTANCE) {
            super.run(distance);
        } else {
            System.out.println(getName() + " не зміг пробігти " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= MAX_DOG_SWIM_DISTANCE) {
            super.swim(distance);
        } else {
            System.out.println(getName() + " не зміг проплисти " + distance + " м.");
        }
    }

    public static int getDogCount() {
        return dogCount;
    }
}
