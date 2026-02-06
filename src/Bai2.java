public class Bai2 {
    public abstract static class Vehicle{
        protected String brand;

        public Vehicle(String brand) {
            this.brand = brand;
        }

        abstract void move();
    }

    public static class Car extends Vehicle{
        public Car(String brand) {
            super(brand);
        }
        @Override
        void move() {
            System.out.println("Di chuyen bang dong co");
        }
    }

    public static class Bicycle extends Vehicle{
        public Bicycle(String brand) {
            super(brand);
        }
        @Override
        void move() {
            System.out.println("Di chuyển bằng sức người");
        }
    }

    public static void main(String[] args) {
        Vehicle car = new Car("Car");
        Vehicle bicycle = new Bicycle("Bicycle");
        System.out.printf("[%s] - ", car.brand);
        car.move();
        System.out.printf("[%s] - ", bicycle.brand);
        bicycle.move();
    }
}
