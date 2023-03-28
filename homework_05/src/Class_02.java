/*
Пусть дан список сотрудников:
Иван Иванов
Светлана Петрова
Кристина Белова
Анна Мусина
Анна Крутова
Иван Юрин
Петр Лыков
Павел Чернов
Петр Чернышов
Мария Федорова
Марина Светлова
Мария Савина
Мария Рыкова
Марина Лугова
Анна Владимирова
Иван Мечников
Петр Петин
Иван Ежов
Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
 */
import java.util.*;

public class Class_02 {
    public static void main(String[] args) {
        ArrayList<String> workersList = new ArrayList<>(Arrays.
                asList("Иван Иванов","Светлана Петрова",
                "Кристина Белова","Анна Мусина","Анна Крутова",
                "Иван Юрин","Петр Лыков","Павел Чернов","Петр Чернышов",
                "Мария Федорова","Марина Светлова","Мария Савина",
                "Мария Рыкова","Марина угова","Анна Владимирова",
                "Иван Мечников","Петр Петин","Иван Ежов"));

        ArrayList<String> names = new ArrayList<>();
        for (String item: workersList)
            names.add(item.split(" ")[0]);
        Set<String> uniqueNames = new HashSet<>(names);
        NavigableMap<Integer, List<String>> resultMap = new TreeMap<>();

        for (String uName: uniqueNames) {
            List<String> tmpList = new ArrayList<>();
            int colRepeats = Collections.frequency(names, uName); // кол-во повторений имени в коллекции
            if (colRepeats > 1) {
                if (resultMap.containsKey(colRepeats))
                    tmpList.addAll(resultMap.get(colRepeats));
                tmpList.add(uName);
                resultMap.put(colRepeats, tmpList);
            }
        }
        System.out.println(resultMap.descendingMap());
    }
}
