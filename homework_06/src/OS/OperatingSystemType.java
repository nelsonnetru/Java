package OS;

public enum OperatingSystemType {
    LINUX ("Linux"),
    UNIX ("UNIX"),
    WIN ("Windows"),
    DOS ("OS DOS");

    private String title;

    OperatingSystemType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
