package OtherParams;

public enum Colors {
    BLACK ("Черный"),
    BW ("Черно-белый"),
    SILVER ("Серебристый"),
    WHITE ("Белый");

    private String title;

    Colors(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    @Override
    public String toString() {
        return name();
    }
}
