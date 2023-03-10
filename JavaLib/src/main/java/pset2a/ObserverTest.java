package pset2a;



public class ObserverTest{

    public static void main(String[] args) {
        System.out.println("Asdfas");
        AirPollutionAlert singaporeAlert = new AirPollutionAlert();
        System.out.println("asdfasd");
        Subscriber man = new Subscriber("man",singaporeAlert);

        Subscriber simon = new Subscriber("simon", singaporeAlert);

        singaporeAlert.setAirPollutionIndex(200);

        singaporeAlert.setAirPollutionIndex(50);

        singaporeAlert.setAirPollutionIndex(120);

        singaporeAlert.unregister(man);

        singaporeAlert.setAirPollutionIndex(300);

    }

}
