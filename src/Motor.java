public class Motor {

    private boolean encendido = false;
    private boolean apagado = true;


    public void engegar() {
        apagado = false;
        encendido = true;
    }

    public void apagar() {
        encendido = false;
        apagado = true;
    }

    public String status() {

        if (encendido) {

            return "On";

        } else {

            return "Off";

        }

    }
}