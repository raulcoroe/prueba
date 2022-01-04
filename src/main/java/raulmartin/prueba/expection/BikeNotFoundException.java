package raulmartin.prueba.expection;

public class BikeNotFoundException extends Exception{

    private final static String DEFAULT_MESSAGE = "Bike not found";

    public BikeNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public BikeNotFoundException(String message) {
        super(message);
    }
}
