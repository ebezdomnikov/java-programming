package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        Solution.countries.put("UA", "Ukraine");
        Solution.countries.put("RU", "Russia");
        Solution.countries.put("CA", "Canada");
    }
    public static void main(String[] args) {
        //+38(050)123-45-67
        //501234567
//        String sss = String.format("%010d",);
//        System.out.println(sss);
//        String code = sss.substring(0,3);
//        String part1 = sss.substring(3,6);
//        String part2 = sss.substring(6,8);
//        String part3 = sss.substring(8,10);
//        System.out.println(String.format("(%s)%s-%s-%s", code, part1, part2, part3));
    }

    public static class IncomeDataAdapter implements Customer,Contact {
        private IncomeData data;
        public IncomeDataAdapter(IncomeData incomeData) {
            this.data = incomeData;
        }

        @Override
        public String getCompanyName() {
            return this.data.getCompany();
        }

        @Override
        public String getCountryName() {
            return Solution.countries.get(this.data.getCountryCode());
        }

        @Override
        public String getName() {
            return this.data.getContactLastName() + ", " + this.data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String sss = String.format("%010d",this.data.getPhoneNumber());
            String code = sss.substring(0,3);
            String part1 = sss.substring(3,6);
            String part2 = sss.substring(6,8);
            String part3 = sss.substring(8,10);
            return "+" + this.data.getCountryPhoneCode() + String.format("(%s)%s-%s-%s", code, part1, part2, part3) ;
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}