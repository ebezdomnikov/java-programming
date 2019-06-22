package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 *  В классе DepositCommand в методе execute() запроси код валюты,
 *  потом запроси номинал и количество банкнот, а потом добавь их в манипулятор.
 *  Если номинал и количество банкнот пользователь ввел не правильно(не числа)
 * - повторять попытку по введению номинала и количества банкнот.
 */
class DepositCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + ".deposit_en");
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String curCode = ConsoleHelper.askCurrencyCode();
        String[] moneyAndAmount = ConsoleHelper.getValidTwoDigits(curCode);
        CurrencyManipulator temp = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(curCode);
        try {
            int k = Integer.parseInt(moneyAndAmount[0]);
            int l = Integer.parseInt(moneyAndAmount[1]);
            temp.addAmount(k, l);
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), k * l, curCode));
        } catch (NumberFormatException ex) {
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
    }
}
