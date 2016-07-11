package javatests;

/*
See type promotion in Java CR 8th edition Page 48-49
*/

public class TypeCaste {
    public static void main(String[] args) {
        byte b = 1;
        b = (byte)(b*2); // expression is promoted to int, so it needs to be casted to byte.
        System.out.println(b);
    }
}
