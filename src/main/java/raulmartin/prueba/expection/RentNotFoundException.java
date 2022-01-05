package raulmartin.prueba.expection;

public class RentNotFoundException extends Exception{

    private final static String DEFAULT_MESSAGE = "Rent not found";

    public RentNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public RentNotFoundException(String message) {
        super(message);
    }
}
