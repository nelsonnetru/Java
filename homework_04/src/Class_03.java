// В калькулятор добавьте возможность отменить последнюю операцию.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.logging.*;

public class Class_03 {
    private static final boolean loadLogFromFile = true; // загружать из Log-файла операции во временный буфер при запуске
    private static final int maxOperationFromLog = 10; // количество последних операций для загрузки из Log-afqkf во временный буфер
    private static final String logFileName = System.getProperty("user.dir").
            concat(System.getProperty("file.separator")).
            concat("log_calc.txt"); // Log-файл
    private static final String prefixSuccessCalc = "CALC: "; // префикс сообщения в Log с удачным вычислением
    private static final String prefixErrorCalc = "CALC_ERROR: "; // префикс сообщения в Log с ошибкой вычисления
    private static final String prefixUndoCalc = "CALC_UNDO: ";// префикс сообщения в Log с отменой операции
    private static Float memoryResult = 0f; // значение в памяти из истории операций / последнее занчение

    public static void main(String[] args) {
        LinkedList<String> tmpLog = new LinkedList<>();
        System.out.println("Log-файл: " + logFileName);

        if (loadLogFromFile) {
            try {
                tmpLog = loadLogToBuffer();
                updateMemoryResult(tmpLog);
                System.out.printf("В буфер из Log-файла загружены последние %d операций (максимум %d)\n", tmpLog.size(), maxOperationFromLog);
            } catch (IOException ex) {
                System.out.printf("Невозможно загрузить Log-файл %s\n", logFileName);
            }
        }

        while (true) {
            System.out.print("Управляющие команды:\n" +
                    "\texit для выхода\n" +
                    "\tundo для отмены последней операции\n" +
                    "\tmem для использования значения из памяти (mem = " + memoryResult + ")\n" +
                    "\tclear для удаления ответа из памяти\n");

            Float aDigit = 0f;
            Float bDigit = 0f;
            try {
                Scanner aScanner = new Scanner(System.in);
                System.out.print("Введите число A (или mem для использования значения из памяти): ");
                if (aScanner.hasNextFloat()) {
                    aDigit = aScanner.nextFloat();
                } else {
                    String aString = aScanner.next();
                    if (aString.equals("mem")) aDigit = memoryResult;
                    else {
                        if (analyzeDoing(aString, tmpLog)) continue;
                        else {
                            aScanner.close();
                            return;
                        }
                    }
                }

                System.out.print("Введите число B (или mem для использования значения из памяти): ");
                if (aScanner.hasNextFloat()) {
                    bDigit = aScanner.nextFloat();
                } else {
                    if (aScanner.hasNextLine()) {
                        String bString = aScanner.next();
                        if (bString.equals("mem")) bDigit = memoryResult;
                        else {
                            if (analyzeDoing(bString, tmpLog)) continue;
                            else {
                                aScanner.close();
                                return;
                            }
                        }
                    }
                }
                System.out.print("Введите математическую операцию + - / * : ");
                char doing = aScanner.next().charAt(0);

                Object resCalc = calc(doing, aDigit, bDigit);
                if (resCalc instanceof Float) {
                    memoryResult = (float) resCalc;
                    System.out.printf("%.2f %s %.2f = %.2f\n", aDigit, doing, bDigit, (float) resCalc);
                    tmpLog.add(aDigit + ";" + doing + ";" + bDigit + ";" + resCalc);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static boolean analyzeDoing(String doing, LinkedList<String> tmpLog) {
        switch (doing) {
            case "exit" -> {
                return false;
            }
            case "clear" -> {
                memoryResult = 0f;
                System.out.println("Последний ответ удален из памяти");
                return true;
            }
            case "undo" -> {
                String undoOperation = tmpLog.pollLast();
                if (undoOperation != null) {
                    String[] tmp = calcStringArrayParser(undoOperation);
                    try {
                        calc('u', Float.parseFloat(tmp[0]), Float.parseFloat(tmp[2]));
                    } catch (IOException ex) {
                        System.out.println("Ошибка записи в Log-файл");
                    }
                    System.out.printf("Операция отменена: %s %s %s = %s\n", tmp[0], tmp[1], tmp[2], tmp[3]);
                    updateMemoryResult(tmpLog);
                } else {
                    System.out.println("История операций пуста.");
                }
                return true;
            }
        }
        return true;
    }

    public static void updateMemoryResult(LinkedList<String> buf) {
        String lastOperation = buf.peekLast();
        if (lastOperation != null) {
            String[] tmpArr = calcStringArrayParser(lastOperation);
            memoryResult = Float.parseFloat(tmpArr[3]);
        }
    }

    public static LinkedList<String> loadLogToBuffer() throws IOException {
        FileReader fw = new FileReader(logFileName);
        BufferedReader br = new BufferedReader(fw);
        LinkedList<String> buf = new LinkedList<>();
        String str;
        int counter = 0;
        while ((str = br.readLine()) != null) {
            if (str.startsWith("INFO: ")) {
                buf.add(str.replace("INFO: ", "").replace(prefixSuccessCalc, ""));
                counter++;
                if (counter > maxOperationFromLog) buf.remove();
            }
        }
        br.close();
        fw.close();
        return buf;
    }

    public static String[] calcStringArrayParser(String strToParse) {
        return strToParse.replace("INFO: ", "").replace(prefixSuccessCalc, "").split(";");
    }

    public static Object calc(char doing, float aDigit, float bDigit) throws IOException {
        Logger logger = Logger.getLogger(Class_02.class.getName());
        logger.setLevel(Level.INFO);

        FileHandler fHandler = new FileHandler(logFileName, true);
        logger.addHandler(fHandler);

        SimpleFormatter sFormat = new SimpleFormatter();
        fHandler.setFormatter(sFormat);

        Object result;

        if (bDigit == 0 && doing == '/') {
            System.out.print("Ошибка! Делить на ноль нельзя!\n");
            logger.log(Level.WARNING, prefixErrorCalc + aDigit + ";" + doing + ";" + bDigit + " // Division by zero!");
            result = false;
        } else {
            if (doing == '-') result = aDigit - bDigit;
            else if (doing == '+') result = aDigit + bDigit;
            else if (doing == '*') result = aDigit * bDigit;
            else if (doing == '/') result = aDigit / bDigit;
            else if (doing == 'u') {
                logger.log(Level.WARNING, prefixUndoCalc + aDigit + ";" + doing + ";" + bDigit + " // Undo operation.");
                result = true;
            } else {
                System.out.print("Ошибка! Неизвестная операция!\n");
                logger.log(Level.WARNING, prefixErrorCalc + aDigit + ";" + doing + ";" + bDigit + " // Unknown operation!");
                result = false;
            }
            if (result instanceof Float)
                logger.log(Level.INFO, prefixSuccessCalc + aDigit + ";" + doing + ";" + bDigit + ";" + result);
        }
        fHandler.close();
        return result;
    }
}
