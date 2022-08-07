import edu.princeton.cs.algs4.StdIn;

public class Permutation {

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> myRandomizedQueue = new RandomizedQueue<>();
        for (int i = 0; i < k; i++) {
            String inputString = StdIn.readString();
            myRandomizedQueue.enqueue(inputString);
        }

        for (int i = 0; i < k; i++) {
            System.out.println(myRandomizedQueue.dequeue());
        }
    }
}
