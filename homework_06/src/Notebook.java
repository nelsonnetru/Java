import CPU.CpuType;
import OS.OperatingSystem;
import OtherParams.Colors;
import OtherParams.KeyboardType;
import java.text.DecimalFormat;

public class Notebook {
    private String manufacturer;
    private String serialNumber;
    private String modelName;
    private Integer ddrValue;
    private Integer hddValue;
    private OperatingSystem operatingSystem;
    private CpuType cpuType;
    private Colors color;
    private KeyboardType keyboardType;
    private Integer coast;

    public Colors getColor() {
        return color;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Integer getCoast() {
        return coast;
    }

    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }

    public void setCoast(Integer coast) {
        this.coast = coast;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setDdrValue(Integer ddrValue) {
        this.ddrValue = ddrValue;
    }

    public void setHddValue(Integer hddValue) {
        this.hddValue = hddValue;
    }

    public void setOperatingSystem(OperatingSystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public void setCpuType(CpuType cpuType) {
        this.cpuType = cpuType;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public void setKeyboardType(KeyboardType keyboardType) {
        this.keyboardType = keyboardType;
    }

    public Integer getDdrValue() {
        return ddrValue;
    }

    public Integer getHddValue() {
        return hddValue;
    }

    public CpuType getCpuType() {
        return cpuType;
    }

    public KeyboardType getKeyboardType() {
        return keyboardType;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("###,###,###.00");
        StringBuilder result = new StringBuilder();
        result.append("Производитель: ").append(manufacturer).append("\n");
        result.append("Модель: ").append(modelName).append("\n");
        result.append("Цвет: ").append(color.getTitle()).append("\n");
        result.append("Клавиатура: ").append(keyboardType.getTitle()).append("\n");
        result.append("Серийный номер: ").append(serialNumber).append("\n");
        result.append("Оперативная память: ").append(ddrValue).append(" Gb\n");
        result.append("Жесткий диск (HDD): ").append(hddValue).append(" Gb\n");
        result.append("ОС: ").append(operatingSystem.getNameSystem()).append(" ").append(operatingSystem.getVersionSystem())
                .append(" (лицензия: ").append(operatingSystem.getLicenseType());
        if (operatingSystem.getLicenseCoast() > 0)
            result.append(", стоимость: ")
                    .append(df.format((float)operatingSystem.getLicenseCoast()/100)).append(" руб.")
                    .append(" включена в стоимость ноутбука");
        result.append(")").append("\n");
        result.append("Процессор: ").append(cpuType).append("\n");
        result.append("-----------").append("\n");
        result.append("Стоимость: ").append(df.format((float)coast/100)).append(" руб.").append("\n");
        return result.toString();
    }
}
