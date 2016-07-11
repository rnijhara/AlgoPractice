package mathematicalalgos;

/**
 *
 * @author rex
 */
public class GCD {
    public static void main(String[] args) {
        System.out.println(gcdIterative(5, 10));
        System.out.println(gcdRecursive(5, 10));
    }
    
    static int gcdRecursive(int a, int b) {
        if(a == 0)
            return b;
        return gcdRecursive(b%a, a);
    }
    
    static int gcdIterative(int a, int b) {
        int t;
        while(a != 0) {
            t = a;
            a = b%a;
            b = t;
        }
        return b;
    }
}
