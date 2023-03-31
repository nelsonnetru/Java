package OS;

public class OperatingSystem {
    private OperatingSystemType osType;

    private String nameSystem;
    private String versionSystem;
    private Integer licenseCoast;

    private LicenseType licenseType;

    public OperatingSystem(OperatingSystemType osType, String nameSystem, String versionSystem, Integer licenseCoast, LicenseType licenseType) {
        this.osType = osType;
        this.nameSystem = nameSystem;
        this.versionSystem = versionSystem;
        this.licenseCoast = licenseCoast;
        this.licenseType = licenseType;
    }

    @Override
    public String toString() {
        return "\nОС {" +
                "тип: " + osType +
                ", наименование: '" + nameSystem + '\'' +
                ", версия: '" + versionSystem + '\'' +
                ", cтоимость лицензии: " + String.format("%.2f", (float)licenseCoast/100) + " руб." +
                ", тип лицензии: " + licenseType +
                "}";
    }

    public OperatingSystemType getOsType() {
        return osType;
    }

    public String getNameSystem() {
        return nameSystem;
    }

    public String getVersionSystem() {
        return versionSystem;
    }

    public LicenseType getLicenseType() {
        return licenseType;
    }

    public Integer getLicenseCoast() {
        return licenseCoast;
    }
}
