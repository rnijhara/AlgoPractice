package random;

class Test3 {
    public static void main(String[] args) {
        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Hello");
        }
        System.out.println("World");
    }
}