package app;

import static app.util.AppConstants.MAX_CAT_RUN_DISTANCE;

class Cat extends Animal {
    private static int catCount = 0;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_CAT_RUN_DISTANCE) {
            super.run(distance);
        } else {
            System.out.println(getName() + " не зміг пробігти " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(getName() + " не вміє плавати.");
    }

    public static int getCatCount() {
        return catCount;
    }
}