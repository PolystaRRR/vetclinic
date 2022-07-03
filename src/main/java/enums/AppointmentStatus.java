package enums;

public enum AppointmentStatus {
    NEW("NEW"),
    IN_PROCESS("IN-PROCESS"),
    CANCELLED("CANCELLED"),
    AWAITING_PAYMENT(" AWAITING_PAYMENT"),
    COMPLETED("COMPLETED");

    private final String text;

    AppointmentStatus(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
