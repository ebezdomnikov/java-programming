package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
//        File fTest = new File("/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1904/test.txt");
//        Scanner scanner = new Scanner(fTest);
//        String sCurrent;
//        Person person;
//        PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(scanner);
//        while(scanner.hasNextLine()) {
//            person = personScannerAdapter.read();
//            System.out.println(person);
//            //treatment
//        }
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner)
        {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {

            String sCurrent = this.fileScanner.nextLine();

            String[] parts =  sCurrent.split(" ");

            //Иванов Иван Иванович 31 12 1950

            Date date= (new GregorianCalendar(Integer.parseInt(parts[5]),Integer.parseInt(parts[4])-1,Integer.parseInt(parts[3]))).getTime();

            Person person = new Person(parts[1],parts[2],parts[0],date);

            return person;
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
