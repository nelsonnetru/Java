import com.sun.source.tree.CatchTree;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Cat catOne = new Cat("Веня", 2, 12, 50, "male", "Александр");

        Cat catTwo = new Cat();
        catTwo.setName("Мотя");
        catTwo.setAge(7);
        catTwo.setHeight(45);
        catTwo.setSex("male");
        catTwo.setWeight(10);
        catTwo.setOwnerName("Юрий");

        Cat catThree = new Cat();
        catThree.setName("Люся");
        catThree.setWeight(13);
        catThree.setSex("female");
        catThree.setAge(9);
        catThree.setHeight(100);
        catThree.setOwnerName("Ирина");

        Cat catFour = new Cat();
        catFour.setName("КлонВени");
        catFour.setWeight(12);
        catFour.setSex("male");
        catFour.setAge(2);
        catFour.setHeight(60);
        catFour.setOwnerName("Василий");

        System.out.println(catOne);
        System.out.println(catTwo);
        System.out.println(catThree);
        System.out.println(catFour);

        Set<Cat> cats = new HashSet<>();
        cats.add(catOne);
        cats.add(catTwo);
        cats.add(catThree);
        cats.add(catFour);

        System.out.println(cats);
    }
}
