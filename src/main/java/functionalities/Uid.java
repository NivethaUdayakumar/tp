package functionalities;

import exception.SniffException;

import java.util.Random;

public class Uid {
    private static final int DIGIT_LENGTH = 8;
    private static final int ZERO_CHAR_IN_INT = 48;
    private static final int NINE_CHAR_IN_INT = 57;
    private static final int A_CHAR_IN_INT = 65;
    private static final int Z_CHAR_IN_INT = 90;


    /**
     * Generates a 10-character long unique appointment ID with the leading character denoting the
     * appointment type. Appointment ID generated is of the format [A]XXXXXXXX[L], where
     * [A] represents the corresponding appointment type,
     * [L] denotes a random letter from A-Z,
     * and XXXXXXXX denotes a random 8-digit number generated.
     *
     * @param appointmentType The type of appointment
     * @return a string representing a unique appointment ID
     */
    public static String uidGenerator(String appointmentType) throws SniffException {
        if (!appointmentType.equals("C") && !appointmentType.equals("V") && !appointmentType.equals("S")) {
            throw new SniffException("Invalid appointment type for uid generation.");
        }
        StringBuilder uidBuilder = new StringBuilder("");
        StringBuilder eightDigitNumber = new StringBuilder("");
        Random random = new Random();
        uidBuilder.append(appointmentType);
        for (int i = 0; i < DIGIT_LENGTH; i++) {
            char digit = (char) (random.nextInt(NINE_CHAR_IN_INT - ZERO_CHAR_IN_INT) + ZERO_CHAR_IN_INT);
            eightDigitNumber.append(digit);
        }
        uidBuilder.append(eightDigitNumber.toString());
        char letter = (char) (random.nextInt(Z_CHAR_IN_INT - A_CHAR_IN_INT) + A_CHAR_IN_INT);
        uidBuilder.append(letter);
        String uidString = uidBuilder.toString();
        return uidString;
    }
}
