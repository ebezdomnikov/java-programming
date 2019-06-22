import java.io.FileInputStream;

/**
 * Created by bezdomnikov-ev on 15/04/17.
 */
public class test {
    public static void main(String[] args) throws Exception
    {
        //создаем объект FileInputStream, привязанный к файлу «c:/data.txt».
        FileInputStream inputStream = new FileInputStream("/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/1.JavaSyntax/src/data.txt");
        long sum = 0;
        //System.out.println(inputStream.available());
        while (inputStream.available() > 0) //пока остались непрочитанные байты
        {
            int data = inputStream.read(); //прочитать очередной байт
            System.out.println(data);
            sum += data; //добавить его к общей сумме
        }
        inputStream.close(); // закрываем поток

        System.out.println(sum); //выводим сумму на экран.
    }
}
