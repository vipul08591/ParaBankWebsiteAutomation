package utils;

import java.util.List;

public class TestData {
    public static List<String> accountNumbers;

    public static void setAccountNumbers(List<String> accounts) {
        accountNumbers = accounts;
    }

    public static String getFirstAccount() {
        return accountNumbers != null && accountNumbers.size() > 0 ? accountNumbers.get(0) : "";
    }

    public static String getSecondAccount() {
        return accountNumbers != null && accountNumbers.size() > 1 ? accountNumbers.get(1) : "";
    }
}
