package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * 1. Создай в ConsoleHelper два статических метода:
 * 1.1 writeMessage(String message), который будет писать в консоль наше сообщение.
 * 1.2 String readString(), который будет считывать с консоли строку и возвращать ее.
 * Если возникнет какое-то исключение при работе с консолью, то перехватим его и не будем обрабатывать.
 * Кстати, создадим только один экземпляр BufferedReader-а, в статическом поле bis.
 *
 * 2. Создай пакет exception, в который поместим два checked исключения:
 * 2.1 InterruptOperationException будем кидать, когда нужно прервать текущую операцию и выйти из приложения.
 * 2.2 NotEnoughMoneyException будем кидать, когда не сможем выдать запрашиваемую сумму.
 */
public class ConsoleHelper {
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + ".common_en");
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String input = "";
        try {
            input = bis.readLine();
            if (input.equalsIgnoreCase("exit")) {
                throw new InterruptOperationException();
            }
        } catch (IOException ignored) {}

        return input;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        System.out.println("Please, input currency: ");
        String code = readString();
        while (code.length() != 3) {
            System.out.println("The code should contains 3 letters, please try again.");
            System.out.println("Please, input currency: ");
            code = readString();
        }

        return code.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        writeMessage("Input nominal and total:");

        String[] input;
        while (true) {
            input = readString().split(" ");

            int nominal = 0;
            int total = 0;
            try {
                nominal = Integer.parseInt(input[0]);
                total = Integer.parseInt(input[1]);
            } catch (Exception e) {
                writeMessage("Error, Repeat again:");
                continue;
            }
            if (nominal <= 0 || total <= 0) {
                writeMessage("Error, Repeat again:");
                continue;
            }
            break;
        }
        return input;
    }

    public static Operation askOperation() throws InterruptOperationException {
        Operation operation;
        while (true) {
            try {
                System.out.println("Please, input type of operation: ");
                String str = readString();
                operation = Operation.getAllowableOperationByOrdinal(Integer.parseInt(str));
                break;
            } catch (IllegalArgumentException e) { }
        }

        return operation;
    }

    public static void printExitMessage() {
        writeMessage(res.getString("the.end"));
    }
}
