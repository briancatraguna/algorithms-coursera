public class HelloGoodbye {

    public static void main (String[] args) {
        try {
            System.out.println("Hello "+args[0]+" and "+args[1]);
            System.out.println("Goodbye "+args[0]+" and "+args[1]);
        } catch (Exception e) {
            System.out.println("Not enough arguments are supplied!");
        }
    }

}
