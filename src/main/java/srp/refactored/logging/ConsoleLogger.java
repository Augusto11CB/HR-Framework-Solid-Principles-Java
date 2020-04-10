package srp.refactored.logging;

public class ConsoleLogger {

    // Responsibility Refactored: Logging
    public void writeInfo(String msg) {

        System.out.println("Info: " + msg);
    }

    public void writeError(String msg, Exception e) {

        System.err.println("Error: " + msg + ";" + e);
    }
}
