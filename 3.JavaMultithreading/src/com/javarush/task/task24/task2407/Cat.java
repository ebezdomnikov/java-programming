package com.javarush.task.task24.task2407;

/*
В работе вам иногда будет нужно закастить класс к какому-нибудь интерфейсу (тут Sayable),
который не реализован в текущем классе
 */
public class Cat implements Pet {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    /**
     * Это - механизм адаптирования к другому интерфейсу - Sayable
     * Внутри метода toSayable создайте class CatPet, реализующий интерфейс Sayable
     * Логика метода say:
     * Если i <= 0, то вывести на экран, что кот спит. Пример, "Васька спит."'
     * Иначе вывести фразу: "имя_кота говорит мяу!". Пример для i=3, "Васька говорит мяяяу!"
     * <p/>
     * <b>Пример вывода:</b>
     * Мурзик спит.
     * Васька говорит мяяу!
     * Кошка говорит мяяяяяу!
     * Мышь пищит.
     * Томас говорит мяу!
     * <p/>
     * @param i количество букв 'я' в слове мяу
     * @return экземпляр класса CatPet
     */
    public Sayable toSayable(final int i) {

        class SaySleep implements Sayable {

            String name;

            public SaySleep(String name) {
                this.name = name;
            }

            @Override
            public String say() {
                return name + " спит.";
            }
        }

        class SayMay implements Sayable {

            String name;
            int c;

            public SayMay(String name, int c) {
                this.name = name;
                this.c = c;
            }

            @Override
            public String say() {

                String ya = "";
                for (int j=0; j<c; j++) {
                    ya += "я";
                }

                return name + " говорит м"+ ya +"у!";
            }
        }

        if (i < 1) {
            //name спит."
            return new SaySleep(this.name);
        }

        return new SayMay(name, i);
    }
}