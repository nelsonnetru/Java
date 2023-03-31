import CPU.CpuType;
import CPU.ManufacturerCPU;
import OS.LicenseType;
import OS.OperatingSystem;
import OS.OperatingSystemType;
import OtherParams.Colors;
import OtherParams.KeyboardType;
import java.text.DecimalFormat;
import java.util.*;

/* Урок 6. Хранение и обработка данных ч3: множество коллекций Set
Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
“Введите цифру, соответствующую необходимому критерию:

1 - ОЗУ
2 - Объём ЖД
3 - Операционная система
4 - Цвет …

Далее нужно запросить минимальные значения для указанных критериев — сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<CpuType> cpu = new ArrayList<>();
        cpu.add(new CpuType(ManufacturerCPU.INTEL, "Pentium II Xeon", "Socket LS (LGA1567)", 72, 400000, 16));
        cpu.add(new CpuType(ManufacturerCPU.INTEL, "Xeon E5", "Socket LS (LGA1567)", 72, 1600000, 64));
        cpu.add(new CpuType(ManufacturerCPU.INTEL, "Core i5", "Socket H (LGA1165)", 10, 1200000, 4000));
        cpu.add(new CpuType(ManufacturerCPU.INTEL, "Core i5", "Socket H (LGA1165)", 10, 2600000, 6000));
        cpu.add(new CpuType(ManufacturerCPU.INTEL, "Core i7", "Socket H (LGA1165)", 10, 3200000, 8000));
        cpu.add(new CpuType(ManufacturerCPU.AMD, "Ryzen 5 7600X", "АМ5 (LGA 1718)", 6, 4700000, 384));
        cpu.add(new CpuType(ManufacturerCPU.AMD, "Ryzen 9 7900X", "АМ5 (LGA 1718)", 12, 5600000, 768));

        ArrayList<OperatingSystem> operSys = new ArrayList<>();
        operSys.add(new OperatingSystem(OperatingSystemType.DOS, OperatingSystemType.DOS.getTitle(), "6.22", 0, LicenseType.GPL));
        operSys.add(new OperatingSystem(OperatingSystemType.WIN, OperatingSystemType.WIN.getTitle(), "8.1", 300000, LicenseType.EULA));
        operSys.add(new OperatingSystem(OperatingSystemType.WIN, OperatingSystemType.WIN.getTitle(), "10", 350050, LicenseType.EULA));
        operSys.add(new OperatingSystem(OperatingSystemType.WIN, OperatingSystemType.WIN.getTitle(), "10 Ultimate", 1200000, LicenseType.EULA));
        operSys.add(new OperatingSystem(OperatingSystemType.LINUX, OperatingSystemType.LINUX.getTitle(), "UBUNTU 22.04", 0, LicenseType.GPL));
        operSys.add(new OperatingSystem(OperatingSystemType.LINUX, OperatingSystemType.LINUX.getTitle(), "Lubuntu 20.04", 0, LicenseType.OEM));
        operSys.add(new OperatingSystem(OperatingSystemType.UNIX, OperatingSystemType.UNIX.getTitle(), "FreeBSD", 680000, LicenseType.BSD));
        operSys.add(new OperatingSystem(OperatingSystemType.LINUX, OperatingSystemType.LINUX.getTitle(), "RedOS", 280000, LicenseType.OEM));

        ArrayList<String> manufacturer = new ArrayList<>(Arrays.asList("LENOVO", "ACER", "TOSHIBA", "ASUS", "XIAOMI", "HP"));
        ArrayList<Integer> hdd = new ArrayList<>(Arrays.asList(250, 500, 750, 1000, 2000)); // при генерации будем брать К удорожания базовой стоимости как (hdd/100) (%)
        ArrayList<Integer> ddr = new ArrayList<>(Arrays.asList(4, 6, 8, 12, 16)); // при генерации будем брать К удорожания базовой стоимости как ddr (%)

        HashSet<Notebook> nbkStore = new HashSet<>();
        generateStore(nbkStore, cpu, operSys, hdd, ddr, manufacturer, 5000);
        System.out.println("В базе " + nbkStore.size() + " ноутбуков.\n");
        Map<String, Object> criteries = new HashMap<>();
        Scanner iScan = new Scanner(System.in);
        int com = -1;
        while (com != 0) {
            System.out.println("""
                    Выберите действие:
                    1. Отфильтровать
                    2. Просмотреть все ноутбуки
                    ================================
                    0. Выход
                    """);
            if (iScan.hasNextInt()) {
                com = iScan.nextInt();
                switch (com) {
                    case 0 -> System.out.println("Завершение работы.");
                    case 1 -> {
                        HashMap<String, String> checkCrit;
                        com = -1;
                        while (com != 20 && com != 0) {
                            checkCrit = checkCriteries(criteries);
                            StringBuilder strOut = new StringBuilder("Введите критерии фильтра:\n");
                            strOut.append("11. Цвет ").append(checkCrit.get("color")).append("\n");
                            strOut.append("12. Производитель процессора ").append(checkCrit.get("cpu")).append("\n");
                            strOut.append("13. Стоимость ").append(checkCrit.get("coast")).append("\n");
                            strOut.append("14. Объем HDD ").append(checkCrit.get("hdd")).append("\n");
                            strOut.append("15. Объем оперативной памяти ").append(checkCrit.get("ddr")).append("\n");
                            strOut.append("16. Тип клавиатуры ").append(checkCrit.get("keyboard")).append("\n");
                            strOut.append("17. Операционная система ").append(checkCrit.get("os")).append("\n");
                            strOut.append("--------------------------------").append("\n");
                            strOut.append("18. Применить фильтр").append("\n");
                            strOut.append("19. Сбросить фильтр").append("\n");
                            strOut.append("20. Выйти из фильтра").append("\n");
                            strOut.append("================================").append("\n");
                            strOut.append("0. Выход").append("\n");
                            System.out.println(strOut);
                            if (iScan.hasNextInt()) {
                                com = iScan.nextInt();
                                switch (com) {
                                    case 11 -> setCriteries(criteries, "color", iScan);
                                    case 12 -> setCriteries(criteries, "cpu", iScan);
                                    case 13 -> setCriteries(criteries, "coast", iScan);
                                    case 14 -> setCriteries(criteries, "hdd", iScan);
                                    case 15 -> setCriteries(criteries, "ddr", iScan);
                                    case 16 -> setCriteries(criteries, "keyboard", iScan);
                                    case 17 -> setCriteries(criteries, "os", iScan);
                                    case 18 -> searchNbk(criteries, nbkStore);
                                    case 19 -> criteries.clear();

                                }
                            } else {
                                System.out.println("Необходимо выбрать цифру!");
                                iScan.next();
                            }
                        }
                    }
                    case 2 -> printNbkStore(nbkStore);
                }
            } else {
                System.out.println("Необходимо выбрать цифру!");
                iScan.next();
            }
        }
        iScan.close();
    }

    public static void generateStore(HashSet<Notebook> nbkStore, ArrayList<CpuType> cpu,
                                     ArrayList<OperatingSystem> os, ArrayList<Integer> hdd,
                                     ArrayList<Integer> ddr, ArrayList<String> manufacturer, Integer col) {
        Random rnd = new Random();
        for (int i = 0; i < col; i++) {
            float baseCoast = 2000000f + rnd.nextFloat() * 100000; // "базовая" стоимость ноутбука для генерации стоимостей в копейках
            Notebook nbk = new Notebook();

            nbk.setManufacturer(manufacturer.get(rnd.nextInt(manufacturer.size())));

            int rndIndex = rnd.nextInt(cpu.size());
            nbk.setCpuType(cpu.get(rndIndex));
            baseCoast *= cpu.get(rndIndex).getCoastRate();

            rndIndex = rnd.nextInt(os.size());
            nbk.setOperatingSystem(os.get(rndIndex));
            baseCoast += os.get(rndIndex).getLicenseCoast();

            rndIndex = rnd.nextInt(hdd.size());
            nbk.setHddValue(hdd.get(rndIndex));
            baseCoast = baseCoast * (1 + (hdd.get(rndIndex) / 100) / 100);

            rndIndex = rnd.nextInt(ddr.size());
            nbk.setDdrValue(ddr.get(rndIndex));
            baseCoast = baseCoast * (1 + ddr.get(rndIndex) / 100);

            nbk.setSerialNumber(nbk.getManufacturer().substring(0, 2) + "-" +
                    rnd.nextInt(1000) + "/" + rnd.nextInt(10000) +
                    "-" + i + rnd.nextInt(1000));
            nbk.setModelName(nbk.getManufacturer() + "-" + i + rnd.nextInt(1000));
            nbk.setColor(Colors.values()[rnd.nextInt(Colors.values().length)]);

            KeyboardType keyboard = KeyboardType.values()[rnd.nextInt(KeyboardType.values().length)];
            nbk.setKeyboardType(keyboard);
            baseCoast *= keyboard.getCoastRate();

            nbk.setCoast((int) baseCoast);
            nbkStore.add(nbk);
        }
    }

    public static void searchNbk(Map<String, Object> findCriteries, HashSet<Notebook> nbkSet) {
        int counter = 0;
        System.out.println("Результаты поиска: \n");
        for (Notebook nbk : nbkSet) {
            boolean flag = true;
            if (findCriteries.containsKey("color"))
                if (nbk.getColor() != findCriteries.get("color")) continue;

            if (findCriteries.containsKey("cpu"))
                if (nbk.getCpuType().getManufacturerCPU() != findCriteries.get("cpu")) continue;

            if (findCriteries.containsKey("minCoast"))
                if (nbk.getCoast() < (Integer) findCriteries.get("minCoast")) continue;

            if (findCriteries.containsKey("maxCoast"))
                if (nbk.getCoast() > (Integer) findCriteries.get("maxCoast")) continue;

            if (findCriteries.containsKey("minHDD"))
                if (nbk.getHddValue() < (Integer) findCriteries.get("minHDD")) continue;

            if (findCriteries.containsKey("maxHDD"))
                if (nbk.getHddValue() > (Integer) findCriteries.get("maxHDD")) continue;

            if (findCriteries.containsKey("minDDR"))
                if (nbk.getDdrValue() < (Integer) findCriteries.get("minDDR")) continue;

            if (findCriteries.containsKey("maxDDR"))
                if (nbk.getDdrValue() > (Integer) findCriteries.get("maxDDR")) continue;

            if (findCriteries.containsKey("keyboard"))
                if (nbk.getKeyboardType() != findCriteries.get("keyboard")) continue;

            if (findCriteries.containsKey("os"))
                if (nbk.getOperatingSystem().getOsType() != findCriteries.get("os")) flag = false;

            if (flag) {
                counter++;
                System.out.println(nbk);
            }
        }
        System.out.println("Найдено: " + counter + " шт.\n");
    }

    public static void printNbkStore(HashSet<Notebook> nbkStore) {
        int count = 0;
        for (Notebook nbk : nbkStore) {
            count++;
            System.out.println(count + ": " + nbk);
        }
    }

    public static void setCriteries(Map<String, Object> criteries, String typeCriteria, Scanner iScan) {
        switch (typeCriteria) {
            case "coast" -> {
                System.out.print("Введите минимальную стоимость в рублях: ");
                if (iScan.hasNextInt()) criteries.put("minCoast", iScan.nextInt() * 100);
                else {
                    System.out.println("Необходимо ввести целое число!");
                    iScan.next();
                }
                System.out.print("Введите максимальную стоимость в рублях: ");
                if (iScan.hasNextInt()) criteries.put("maxCoast", iScan.nextInt() * 100);
                else {
                    System.out.println("Необходимо ввести целое число!");
                    iScan.next();
                }
            }
            case "hdd" -> {
                System.out.print("Введите минимальный объем HDD в Гб: ");
                if (iScan.hasNextInt()) criteries.put("minHDD", iScan.nextInt());
                else {
                    System.out.println("Необходимо ввести целое число!");
                    iScan.next();
                }
                System.out.print("Введите максимальный объем HDD в Гб: ");
                if (iScan.hasNextInt()) criteries.put("maxHDD", iScan.nextInt());
                else {
                    System.out.println("Необходимо ввести целое число!");
                    iScan.next();
                }
            }
            case "ddr" -> {
                System.out.print("Введите минимальный объем ОЗУ в Гб: ");
                if (iScan.hasNextInt()) criteries.put("minDDR", iScan.nextInt());
                else {
                    System.out.println("Необходимо ввести целое число!");
                    iScan.next();
                }
                System.out.print("Введите максимальный объем ОЗУ в Гб: ");
                if (iScan.hasNextInt()) criteries.put("maxDDR", iScan.nextInt());
                else {
                    System.out.println("Необходимо ввести целое число!");
                    iScan.next();
                }
            }
            case "color" -> {
                StringBuilder strOut = new StringBuilder("Выберите цвет:\n");
                for (Colors color : Colors.values())
                    strOut.append(color.ordinal()).append(". ").append(color.getTitle()).append("\n");
                System.out.println(strOut);
                if (iScan.hasNextInt()) {
                    int x = iScan.nextInt();
                    if (0 <= x && x < Colors.values().length)
                        criteries.put("color", Colors.values()[x]);
                    else {
                        System.out.println("Недопустимое значение!");
                        iScan.next();
                    }
                } else {
                    System.out.println("Необходимо ввести целое число!");
                    iScan.next();
                }
            }
            case "os" -> {
                StringBuilder strOut = new StringBuilder("Выберите операционную систему:\n");
                for (OperatingSystemType osSystem : OperatingSystemType.values())
                    strOut.append(osSystem.ordinal()).append(". ").append(osSystem.getTitle()).append("\n");
                System.out.println(strOut);
                if (iScan.hasNextInt()) {
                    int x = iScan.nextInt();
                    if (0 <= x && x < OperatingSystemType.values().length)
                        criteries.put("os", OperatingSystemType.values()[x]);
                    else {
                        System.out.println("Недопустимое значение!");
                        iScan.next();
                    }
                } else {
                    System.out.println("Необходимо ввести целое число!");
                    iScan.next();
                }
            }
            case "cpu" -> {
                StringBuilder strOut = new StringBuilder("Выберите процессор:\n");
                for (ManufacturerCPU cpu : ManufacturerCPU.values())
                    strOut.append(cpu.ordinal()).append(". ").append(cpu).append("\n");
                System.out.println(strOut);
                if (iScan.hasNextInt()) {
                    int x = iScan.nextInt();
                    if (0 <= x && x < ManufacturerCPU.values().length)
                        criteries.put("cpu", ManufacturerCPU.values()[x]);
                    else {
                        System.out.println("Недопустимое значение!");
                        iScan.next();
                    }
                } else {
                    System.out.println("Необходимо ввести целое число!");
                    iScan.next();
                }
            }
            case "keyboard" -> {
                StringBuilder strOut = new StringBuilder("Выберите процессор:\n");
                for (KeyboardType kb : KeyboardType.values())
                    strOut.append(kb.ordinal()).append(". ").append(kb.getTitle()).append("\n");
                System.out.println(strOut);
                if (iScan.hasNextInt()) {
                    int x = iScan.nextInt();
                    if (0 <= x && x < KeyboardType.values().length)
                        criteries.put("keyboard", KeyboardType.values()[x]);
                    else {
                        System.out.println("Недопустимое значение!");
                        iScan.next();
                    }
                } else {
                    System.out.println("Необходимо ввести целое число!");
                    iScan.next();
                }
            }
        }
    }

    public static HashMap<String, String> checkCriteries(Map<String, Object> criteries) {
        HashMap<String, String> result = new HashMap<>();
        if (criteries.containsKey("color")) result.put("color", "(" + criteries.get("color").toString() + ")");
        else result.put("color", "");

        if (criteries.containsKey("cpu")) result.put("cpu", "(" + criteries.get("cpu").toString() + ")");
        else result.put("cpu", "");

        if (criteries.containsKey("minCoast") || criteries.containsKey("maxCoast")) {
            DecimalFormat df = new DecimalFormat("###,###,##0.00");
            result.put("coast", "(" + df.format((int) criteries.get("minCoast") / 100) + " < СТОИМОСТЬ < " + df.format((int) criteries.get("maxCoast") / 100) + ")");
        } else result.put("coast", "");

        if (criteries.containsKey("minHDD") || criteries.containsKey("maxHDD"))
            result.put("hdd", "(" + criteries.get("minHDD") + " < HDD < " + criteries.get("maxHDD") + ")");
        else result.put("hdd", "");

        if (criteries.containsKey("minDDR") || criteries.containsKey("maxDDR"))
            result.put("ddr", "(" + criteries.get("minDDR") + " < ОЗУ < " + criteries.get("maxDDR") + ")");
        else result.put("ddr", "");

        if (criteries.containsKey("keyboard")) result.put("keyboard", "(" + criteries.get("keyboard").toString() + ")");
        else result.put("keyboard", "");

        if (criteries.containsKey("os")) result.put("os", "(" + criteries.get("os").toString() + ")");
        else result.put("os", "");

        return result;

    }
}
