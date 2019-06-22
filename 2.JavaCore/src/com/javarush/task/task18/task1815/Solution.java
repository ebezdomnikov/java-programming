package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements ATableInterface {
        ATableInterface tableInterface;


        public TableInterfaceWrapper(ATableInterface tableInterface)
        {
            this.tableInterface = tableInterface;
        }

        @Override
        public void setModel(List rows) {
            System.out.print(rows.size());
            this.tableInterface.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return this.tableInterface.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            this.tableInterface.setHeaderText(newHeaderText);
        }
    }

    public interface ATableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}