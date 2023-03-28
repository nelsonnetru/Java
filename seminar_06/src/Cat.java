import java.util.Objects;

/**
 * Это класс Cat
 */
public class Cat {
    private String name;
    private Integer age;
    private Integer weight;
    private Integer height;
    private String sex;
    private String ownerName;

    public Cat() {
    }
    /**
     *
     * @param name кличка кота
     * @param age возраст кота
     * @param weight вес
     * @param height высота в холке
     * @param sex пол
     * @param ownerName имя хозяина
     */
    public Cat(String name, Integer age, Integer weight, Integer height, String sex, String ownerName) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.sex = sex;
        this.ownerName = ownerName;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(age, cat.age) && Objects.equals(weight, cat.weight) && Objects.equals(height, cat.height) && Objects.equals(sex, cat.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, weight, height, sex);
    }

    @Override
    public String toString() {
        String start;
        if (sex == "male") start = "Кот ";
        else start = "Кошка ";
        return start + name + ": возраст " + age + " лет. Владелец: " + ownerName;
    }
}
