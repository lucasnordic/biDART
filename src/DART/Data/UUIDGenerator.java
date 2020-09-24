package DART.Data;

public class UUIDGenerator {
    private static int maxGameId = 0;
    private static int maxEmployeeId = 0;
    private static int maxCustomerId = 0;

    public static String getNewGameId() {
        return "G" + maxGameId++;
    }

    public static String getNewEmployeeId() {
        return "E" + maxEmployeeId++;
    }

    public static String getNewCustomerId() {
        return "C" + maxCustomerId++;
    }
}
