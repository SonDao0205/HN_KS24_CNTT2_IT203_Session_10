public class Bai5 {
    abstract static class Employee{
        String name;
        double baseSalary;

        Employee(String name, double baseSalary){
            this.name = name;
            this.baseSalary = baseSalary;
        }

        abstract double calculateSalary();
    }

    interface BonusCalculator{
        double getBonus();
    }

    static class OfficeStaff extends Employee implements BonusCalculator{
        public OfficeStaff(String name, double baseSalary) {
            super(name, baseSalary);
        }

        @Override
        public double getBonus() {
            return 100000;
        }

        @Override
        double calculateSalary() {
            return baseSalary;
        }

        double salary = calculateSalary() + getBonus();
    }

    static class Manager extends Employee implements BonusCalculator{
        public Manager(String name, double baseSalary) {
            super(name, baseSalary);
        }

        @Override
        public double getBonus() {
            return 50000;
        }

        @Override
        double calculateSalary() {
            return baseSalary;
        }

        double salary = calculateSalary() + getBonus();
    }
}
