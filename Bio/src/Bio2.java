import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FrequentWords(Text, k)
 FrequentPatterns ← an empty set
 for i ← 0 to |Text| − k
    Pattern ← the k-mer Text(i, k)
    Count(i) ← PatternCount(Text, Pattern)
 maxCount ← maximum value in array Count
 for i ← 0 to |Text| − k
 if Count(i) = maxCount
 add Text(i, k) to FrequentPatterns
 remove duplicates from FrequentPatterns
 return FrequentPatterns
 */

public class Bio2 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(
                new FileReader(
                        "/Users/bezdomnikov-ev/Dropbox/JavaLearn/JavaRushTasks/Bio/src/dataset2.txt"
                )
        );

        String text = reader.readLine();
        int k = Integer.parseInt(reader.readLine());

        reader.close();

        List<String> frequentPatterns = new ArrayList<>();
        List<Integer> count = new ArrayList<>();

        for(int i=0; i<text.length()-k; i++) {
            String pattern = text.substring(i, i+k);
            count.add(patternCount(text, pattern));
        }

        int maxCount = maxCount(count);

        for(int i=0; i<text.length()-k; i++) {
            //if Count(i) = maxCount
            if (count.get(i) == maxCount) {
                if ( ! frequentPatterns.contains(text.substring(i, i+k))) {
                    frequentPatterns.add(text.substring(i, k+i));
                }
            }
        }

        for (int i=0; i<frequentPatterns.size(); i++) {
            System.out.println(frequentPatterns.get(i));
        }

    }

    public static int maxCount(List<Integer> count)
    {
        int max = Integer.MIN_VALUE;

        for(int i=0; i<count.size(); i++) {
            if (count.get(i) > max) {
                max = count.get(i);
            }
        }

        return max;
    }

    public static int patternCount(String text, String pattern)
    {
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

        return c;
    }

}
