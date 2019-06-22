package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.command.CommandExecutor;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Locale;

/**
 * Итак:
 * 1. Создай класс CashMachine с методом main.
 * 2. Наши операции зададим в энуме Operation: INFO, DEPOSIT, WITHDRAW.
 * Т.к. всё должно быть user friendly, то на выход из приложения надо попрощаться с юзером.
 * Поэтому добавим еще операцию EXIT.
 * 3. Т.к мы будем активно общаться с юзером, то будет много выводимого текста.
 * Чтобы работу с консолью сосредоточить в одном месте, создадим класс ConsoleHelper.
 */
public class CashMachine {

    public static final String RESOURCE_PATH = CashMachine.class.getPackage().getName() + ".resources.";

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        try {
            CommandExecutor.execute(Operation.LOGIN);
            Operation operation;
            do {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            } while (operation != Operation.EXIT);
        } catch (InterruptOperationException e) {
            ConsoleHelper.printExitMessage();
        }
    }
}
