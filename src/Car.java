public class Car extends Thread {
    private int ID;
    private Intersection intersection;

    Car(int id, Intersection intersection_input) {
        this.ID = id;
        this.intersection = intersection_input;
    }

    @Override
    public void run() {
        try {
            System.out.println("Car " + this.ID + " is approaching the intersection.");
            //take 3 seconds to drive up to the intersection
            Thread.sleep(3000);

            System.out.println("Car " + this.ID + " arrived at the intersection.");

            this.intersection.Crossing(this.ID);

            System.out.println("Car " + ID + " exited the intersection.");
            //drives for more 3s after exiting the intersection
            Thread.sleep(3000);

            System.out.println("Car " + ID + " exits.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

