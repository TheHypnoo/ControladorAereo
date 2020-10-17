public class Motor {

    private boolean ences = false;
    private boolean apagat = true;


    public void engegar() {
        apagat = false;
        ences = true;
    }

    public void apagar() {
        ences = false;
        apagat = true;
    }

    public String status() {

        if (ences) {

            return "On";

        } else {

            return "Off";

        }

    }
}