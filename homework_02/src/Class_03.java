/*
3.** Дана json строка (можно сохранить в файл и читать из файла)
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: 
Студент [фамилия] получил [оценка] по предмету [предмет].

Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Class_03
{
    public static void main(String[] args) {
        String str = null;
        try {
            str = readFromFile("data.txt"); 
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
            str = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
        }
        finally {
            ArrayList<String> arrList = parseJsonString(str);
            System.out.print(strBuillderResult(arrList));
        }
    }

    public static ArrayList<String> parseJsonString (String strJson) {
        ArrayList<String> resultList = new ArrayList<String>();
        StringBuilder workingString = new StringBuilder(strJson.trim());
        int startItemIndex = workingString.indexOf("{");
        int endItemIndex = workingString.indexOf("}");

        while (startItemIndex > 0 && endItemIndex > 0) {
            String[] oneItem = workingString.substring(startItemIndex+1, endItemIndex).replace("\"", "").split(",");
            for (String record : oneItem) {
                String[] parts = record.split(":");
                resultList.add(parts[1]);
            }
            workingString.delete(startItemIndex, endItemIndex + 1);
            startItemIndex = workingString.indexOf("{");
            endItemIndex = workingString.indexOf("}");
        }
        return resultList;
    }

    public static StringBuilder strBuillderResult (ArrayList<String> dataStr) {
        StringBuilder resultStr = new StringBuilder();
        for (int i = 0; i < dataStr.size(); i += 3) {
           resultStr.append("Студент ").append(dataStr.get(i)).append(" получил ").append(dataStr.get(i+1)).append(" по предмету ").append(dataStr.get(i+2)).append(".\n");
        }
        return resultStr;
    }

    public static String readFromFile (String fileName) throws IOException {
            FileReader fw = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fw);
            StringBuilder outStr = new StringBuilder();
            String str = null;

            while ((str = br.readLine()) != null) {
                outStr.append(str);
            }

            br.close();
            fw.close();

            return outStr.toString();
     }    
}
