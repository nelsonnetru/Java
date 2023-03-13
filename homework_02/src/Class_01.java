/*
Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
Данные для фильтрации приведены ниже в виде json строки.
Если значение null, то параметр не должен попадать в запрос.

Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 */

public class Class_01 {
    public static void main(String[] args) {
        String querySQL = "  select * from students where    ";
        String jsonParams = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        System.out.println(parseJsonAndAppendToQuery(querySQL, jsonParams));
    }

    public static StringBuilder parseJsonAndAppendToQuery(String query, String strJson) {
        String[] arrStr = strJson.trim().replace("{", "").replace("}", "").split(",");
        StringBuilder finalQuery = new StringBuilder(query.trim());
        for (String param : arrStr) {
            String[] item = param.trim().replace("\"", "").split(":");
            if (!item[1].equals("null"))
                finalQuery.append(" ").append(item[0]).append("=\"").append(item[1]).append("\",");
        }
        return finalQuery.deleteCharAt(finalQuery.length() - 1).append(";");
    }
}
