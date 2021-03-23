public class Intersection extends Thread {
    private Boolean trafficLight;
    private Object Pass = new Object();

    Intersection(){
        this.trafficLight = new Boolean(true);
        if (this.trafficLight == true) {
            System.out.println("The color is black.");
        }
        else {
            System.out.println("The color is white.");
        }    }

    public void run(){
        while(true){
            try { Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.trafficLight = !this.trafficLight;
            if (this.trafficLight == true) {
                System.out.println("The color is black.");
            }
            else {
                System.out.println("The color is white.");
            }

            new Thread(new Runnable() {
                public void run() {
                    synchronized (Pass){
                        if(trafficLight){
                            Pass.notify();
                        }
                    }
                }
            }).start();
        }
    }

    public void Crossing(int id){
        synchronized (Pass){
            while (!this.trafficLight){
                try {
                    System.out.println("Car " + id + " cant cross the intersection.");
                    Pass.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Car " + id + " enters intersection.");
            try {
                //exit 1s after entering the intersection
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Car " + id + " exits intersection.");
            this.Pass.notify();
        }
    }
}