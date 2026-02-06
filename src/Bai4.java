public class Bai4 {
    interface RemoteControl{
        void powerOn();

        default void checkBattery(){
            System.out.println("Pin on dinh");
        }
    }

    static void main(String[] args) {
        RemoteControl smartLight = new RemoteControl() {
            @Override
            public void powerOn() {
                System.out.println("Power on dinh");
            }
        };

        smartLight.powerOn();
        smartLight.checkBattery();
    }
}
