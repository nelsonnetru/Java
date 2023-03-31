package OS;

public enum LicenseType {
    EULA ("End-User License Agreement"),
    OEM ("Original Equipment Manufacturer"),
    GPL ("General Public License"),
    BSD ("Berkeley Software Design");

    private String title;

    LicenseType(String title) {
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
