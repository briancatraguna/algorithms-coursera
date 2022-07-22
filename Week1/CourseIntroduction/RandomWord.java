import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {

    public static void main(String[] args) {
        double count = 1.0;
        String champion = "";
        while (true) {
            String inputtedString = StdIn.readString().trim();
            double probability = 1/count;
            if (StdRandom.bernoulli(probability)){
                champion = inputtedString;
            }
            if (StdIn.isEmpty()) {
                StdOut.println(champion);
                break;
            } else {
                count += 1;
            }
        }
    }

}
