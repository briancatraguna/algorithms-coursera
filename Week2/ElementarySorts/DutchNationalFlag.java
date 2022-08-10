import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Question 3
 * Dutch national flag. Given an array of n buckets, each containing a red, white, or blue pebble, sort them by color.
 * The allowed operations are:
 * swap(i,j):  swap the pebble in bucket i with the pebble in bucket j.
 * color(i): determine the color of the pebble in bucket i.
 * The performance requirements are as follows:
 * At most n calls to color().
 * At most n calls to swap().
 * Constant extra space.
 */
class Bucket implements Comparable<Bucket> {

    Pebble color;

    private Bucket(Pebble color) {
        this.color = color;
    }

    enum Pebble {
        RED,
        WHITE,
        BLUE
    }

    public static final Bucket RED = new Bucket(Pebble.RED);
    public static final Bucket WHITE = new Bucket(Pebble.WHITE);
    public static final Bucket BLUE = new Bucket(Pebble.BLUE);

    @Override
    public int compareTo(Bucket that) {
        if (that.color == Pebble.BLUE && this.color != Pebble.BLUE) {
            return -1;
        }
        if (that.color == Pebble.WHITE && this.color == Pebble.RED) {
            return -1;
        }
        if (that.color == Pebble.WHITE && this.color == Pebble.BLUE) {
            return 1;
        }
        if (that.color == Pebble.RED && this.color != Pebble.RED) {
            return 1;
        }
        return 0;
    }

    public static void sortBuckets(Bucket[] buckets) {
        for (int i = 0; i < buckets.length; i++) {
            for (int j = i; j > 0; j--) {
                if (buckets[j].compareTo(buckets[j - 1]) < 0) {
                    Bucket prevBucket = buckets[j - 1];
                    buckets[j - 1] = buckets[j];
                    buckets[j] = prevBucket;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert size: ");
        int size = scanner.nextInt();
        Bucket[] bucket = new Bucket[size];
        for (int i = 0; i < size; i++) {
            int randomIndex = random.nextInt(0, 3);
            if (randomIndex == 0) {
                bucket[i] = Bucket.RED;
            } else if (randomIndex == 1) {
                bucket[i] = Bucket.WHITE;
            } else {
                bucket[i] = Bucket.BLUE;
            }
        }
        Bucket.sortBuckets(bucket);

        for (Bucket color : bucket) {
            System.out.println(color.color.name());
        }
    }
}


