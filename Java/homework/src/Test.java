public class Test {
    public static void main(String[] args) {
        Car car = new Car("911", "Porche", 1000);
    }
}

class Car {

    public Car() {
        System.out.println("기본 생성자");
    }

    public Car(String carName, String carBrand, int carHp) {
        carName = carName;
        carBrand = carBrand;
        carHp = carHp;

        System.out.println(carName);
        System.out.println(carBrand);
        System.out.println(carHp);
    }
}