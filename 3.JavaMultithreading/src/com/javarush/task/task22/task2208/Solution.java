package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {

    public static void main(String[] args)
    {
        //{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
        HashMap<String, String> params = new HashMap<>();
        params.put("name", "Ivanov");
        params.put("country", "Ukraine");
        params.put("city", "Kiev");
        params.put("age", null);
        System.out.println(getQuery(params));
    }


    public static String getQuery(Map<String, String> params)
    {
        //"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
        StringBuilder where = new StringBuilder();
        Boolean first = true;
        for(Map.Entry<String, String> entry : params.entrySet()) {
           if (entry.getValue() == null || entry.getKey() == null) continue;
           if ( ! first) {
               where.append(" and ");
           }
           where.append(entry.getKey());
           where.append(" = ");
           where.append("'" + entry.getValue() + "'");
           first = false;
        }

        return where.toString();
    }
}
