import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Class_01 {
    private static final String phoneBookFile = System.getProperty("user.dir").
            concat(System.getProperty("file.separator")).concat("phoneDB.txt"); // Файл с данными
    private static SortedMap<Integer, Map<String, Object>> phoneBook = new TreeMap<>(); // Содержимое телефонной книги

    public static void main(String[] args) {
        try {
            loadPhoneBookToBuffer();
            printPhoneBook();
        }
        catch (IOException ex) {
            System.out.println("Телефонная книга не содержит записей");
        }
        addContact();
        printPhoneBook();

    }

    public static void printPhoneBook() {
        for (Map.Entry<Integer, Map<String, Object>> entry: phoneBook.entrySet()) {
            StringBuilder outStr = new StringBuilder();
            outStr.append("["+entry.getKey()+"]");
            for (Map.Entry<String, Object> entryData: entry.getValue().entrySet()) {
                if (entryData.getValue() instanceof String) {
                    outStr.append(" ").append((String)entryData.getValue());
                }
                else if (entryData.getValue() instanceof ArrayList) {
                    outStr.append("\nТелефоны:\n");
                    for (String phone : (ArrayList<String>)entryData.getValue()) {
                        outStr.append("\t").append(phone).append("\n");
                    }
                }
            }
            System.out.println(outStr);
        }
    }

    public static void writeToFile (String str) throws IOException {
        FileWriter fw = new FileWriter(phoneBookFile, true);
        fw.write(str + "\n");
        fw.flush();
        fw.close();
    }

    public static void loadPhoneBookToBuffer() throws IOException {
        FileReader fw = new FileReader(phoneBookFile);
        BufferedReader br = new BufferedReader(fw);
        String str;

        while ((str = br.readLine()) != null) {
            parseRowAndPutToDB(str);
        }
        br.close();
        fw.close();
    }

    public static void parseRowAndPutToDB (String dbRow) {
        Map<String, Object> itemData = new HashMap<>();

        String[] data = dbRow.split("=", 2);
        int id = Integer.parseInt(data[0].replace("{", ""));
        String[] itemDataStr = data[1].split(",", 3);

        for (int i = 0; i < itemDataStr.length; i++) {
            String[] keyValue = itemDataStr[i].
                                replace("{", "").
                                replace("}", "").
                                replace(" ", "").
                                split("=");
            if (keyValue[1].startsWith("[")) {
                String[] phonesArray = keyValue[1].
                                replace("[", "").
                                replace("]", "").
                                replace(" ", "").
                                split(",");
                List<String> phonesArrayList = new ArrayList<>(phonesArray.length);
                phonesArrayList.addAll(Arrays.asList(phonesArray));
                itemData.put(keyValue[0], phonesArrayList);
            }
            else itemData.put(keyValue[0], keyValue[1]);
        }
        phoneBook.put(id, itemData);
    }

    public static void addContact () {
        System.out.println("Добавление контакта: ");
        Map<String, Object> itemData = new HashMap<>();
        Scanner iScanner = new Scanner(System.in);
        String[] labels = new String[]{"Имя", "Фамилия", "Количество номеров телефонов"};

        for (int i = 0; i < labels.length; i++) {
            System.out.printf("Введите %s : ", labels[i]);
            switch (i) {
                case 0 -> itemData.put("name", iScanner.nextLine().
                        replace("=", "").
                        replace("[", "").
                        replace("]", "").
                        replace("{", "").
                        replace("}", "").
                        replace(",", ""));
                case 1 -> itemData.put("surname", iScanner.nextLine().
                        replace("=", "").
                        replace("[", "").
                        replace("]", "").
                        replace("{", "").
                        replace("}", "").
                        replace(",", ""));
                case 2 -> {
                    int phones = 1;
                    if (iScanner.hasNextInt()) {
                        phones = iScanner.nextInt();
                    }
                    List<String> phonesArrayList = new ArrayList<>(phones);
                    for (int j = 1; j <= phones; j++) {
                        System.out.printf("\tВведите (%d) номер телефона: ", j);
                        phonesArrayList.add(iScanner.next().
                                replace(" ", "").
                                replaceAll("[^0-9]", ""));
                    }
                    itemData.put("phones", phonesArrayList);
                }
            }
        }
        iScanner.close();

        int id;
        if (phoneBook.size() == 0) id = 0;
        else id = phoneBook.lastKey() + 1;

        phoneBook.put(id, itemData);
        try {
            writeToFile(id + "=" + itemData);
            System.out.printf("Запись сохранена с id = %d\n", id);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Запись не была добавлена в БД. Ошибка записи в файл.");
        }
    }
}
