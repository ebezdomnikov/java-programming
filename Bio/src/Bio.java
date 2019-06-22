import java.io.*;

public class Bio {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(
                new FileReader(
                        "/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/Bio/src/dataset.txt"
                )
        );

        String text = reader.readLine();
        String pattern = reader.readLine();

        reader.close();

        int step = pattern.length();
        int count = text.length();
        int counter = 0;
        int c = 0;

        while (counter + step <= count) {
            if (text.substring(counter, counter + step).equals(pattern)) {
                c++;
            }
            counter += 1;
        }
        System.out.println(c);
    }

}
