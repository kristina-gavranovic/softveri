package util;

import domain.Radnik;
import domain.StatusRadnika;

public abstract class AbstractValidation {

    protected static void notEmpty(String msg, String txt) throws Exception {
        if (txt.isEmpty()) {
            throw new Exception(msg);
        }
    }

    protected static void notNull(String msg, Object obj) throws Exception {
        if (obj == null) {
            throw new Exception(msg);
        }
    }

    protected static void notEquals(String msg, String expected, String actual) throws Exception {
        if (!expected.equals(actual)) {
            throw new Exception(msg);
        }
    }

    protected static void isActive(String msg, Object obj) throws Exception {
        if (((Radnik) obj).getStatus() == StatusRadnika.neaktivan) {
            throw new Exception(msg);
        }

    }

    protected static void isGoodLength(String msg, String txt, int length) throws Exception {
        System.out.println(txt.length() + "Duzina");
        if (txt.length() != length) {
            System.out.println(txt.length() + "Duzinaiz ifa");

            throw new Exception(msg);
        }

    }

    protected static void isNumeric(String msg, String txt) throws Exception {
        for (int i = 0; i < txt.length(); i++) {
            if (!Character.isDigit(txt.charAt(i))) {
                throw new Exception(msg);

            }
        }
    }

}
