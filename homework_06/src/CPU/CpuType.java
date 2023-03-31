package CPU;

public class CpuType {
    private ManufacturerCPU manufacturerCPU;
    private String modelName;
    private String socketType;

    private Integer coresCount;
    private Integer cpuFrequencyHz;
    private Integer cacheValueKBytes;

    private float coastRate; // коэффициент увеличения стоимости

    public CpuType(ManufacturerCPU manufacturerCPU, String modelName, String socketType, Integer coresCount, Integer cpuFrequencyHz, Integer cacheValueKBytes) {
        this.manufacturerCPU = manufacturerCPU;
        this.modelName = modelName;
        this.socketType = socketType;
        this.coresCount = coresCount;
        this.cpuFrequencyHz = cpuFrequencyHz;
        this.cacheValueKBytes = cacheValueKBytes;
        this.coastRate = 1 + (float)(coresCount)/10/100;
    }

    public float getCoastRate() {
        return coastRate;
    }

    public ManufacturerCPU getManufacturerCPU() {
        return manufacturerCPU;
    }

    @Override
    public String toString() {
        return manufacturerCPU.name() + " " + modelName + " ("+cpuFrequencyHz/1000+" MHz, cache: " + cacheValueKBytes + " kb)";
    }
}
