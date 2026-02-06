public class Bai3 {

    interface Swimmable{
        void swim();
    }

    interface Flyable{
        void fly();
    }

    public static abstract class Animal{
        String name;

        public Animal(String name) {
            this.name = name;
        }
    }

    static class Duck extends Animal implements Swimmable,Flyable{
        public Duck(String name) {
            super(name);
        }

        @Override
        public void fly() {
            System.out.println("Duck fly");
        }

        @Override
        public void swim() {
            System.out.println("Duck swim");
        }
    }

    static class Fish extends Animal implements Swimmable{
        public Fish(String name) {
            super(name);
        }

        @Override
        public void swim() {
            System.out.println("Fish swim");
        }
    }

    static void main(String[] args) {
        Duck duck = new Duck("Duck");
        Fish fish = new Fish("Fish");
        duck.swim();
        duck.fly();
        fish.swim();
    }
}
