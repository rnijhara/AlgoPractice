package javatests;

public class StringTest {
    public static void main(String[] args) {
        String s1 = "01234567";
        String s2 = s1.substring(1,1); //both index are inclusive.
        System.out.println(s2);
        
        String s3 = "01234";
        System.out.println(s2==s3);
    }
}
