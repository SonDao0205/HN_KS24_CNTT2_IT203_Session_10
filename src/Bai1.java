public class Bai1 {
    public interface Shape{
        double getArea();
        double getPerimeter();
    }

    public static class Circle implements Shape{
        double radius;
        public Circle(double radius){
            this.radius = radius;
        }
        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }

        @Override
        public double getPerimeter() {
            return Math.PI * 2 * radius;
        }
    }

    public static class Rectangle implements Shape{
        double width;
        double height;
        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }
        @Override
        public double getArea() {
            return width * height;
        }

        @Override
        public double getPerimeter() {
            return (width * height) / 2;
        }
    }

    public static void main(String[] args) {
        Shape retangle = new Rectangle(20, 10);
        Shape circle = new Circle(10);

        System.out.println("Retangle :");
        System.out.println("Area : "+retangle.getArea());
        System.out.println("Perimeter : " + retangle.getPerimeter());
        System.out.println("Circle :");
        System.out.println("Area : "+circle.getArea());
        System.out.println("Perimeter : " + circle.getPerimeter());
    }
}
