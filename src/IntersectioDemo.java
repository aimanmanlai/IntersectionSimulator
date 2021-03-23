import java.util.Random;
public class IntersectioDemo {

    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        intersection.start();
        Random random = new Random();
        Car car1 = new Car(random.nextInt(1000)*random.nextInt(1000),intersection);
        Car car2 = new Car(random.nextInt(1000)*random.nextInt(1000),intersection);
        Car car3 = new Car(random.nextInt(1000)*random.nextInt(1000),intersection);
        Car car4 = new Car(random.nextInt(1000)*random.nextInt(1000),intersection);
        Car car5 = new Car(random.nextInt(1000)*random.nextInt(1000),intersection);
        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
    }
}