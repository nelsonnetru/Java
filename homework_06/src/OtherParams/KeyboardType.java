package OtherParams;

public enum KeyboardType {
    COMPACT ("Компактная. Без цифровой клавиатуры", 1.03f),
    FULLSIZE ("Стандартная. Полноразмерная", 1.1f);

    private String title;
    private float coastRate; // коэффициент увеличения стоимости

    KeyboardType(String title, float coastRate) {
        this.title = title;
        this.coastRate = coastRate;
    }

    public float getCoastRate() {
        return coastRate;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return name();
    }
}
