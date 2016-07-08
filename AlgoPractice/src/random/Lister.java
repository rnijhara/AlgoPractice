package random;

/**
 *
 * @author rex
 */
class Lister<T extends Integer> {

    private T[] a;
    
    Lister(T[] arr) {
        a = arr;
    }

    Lister(int n) {
        a = (T[])new Integer[n];
    }
    
    
    public T addInt(T x, int i) {
        if(i>a.length) {
            T[] temp = (T[]) new Integer[2*i];
            System.arraycopy(a, 0, temp, 0, a.length);
            a = temp;
        }
        T t = a[i];
        a[i] = x;
        return t;
    }
    
    public void printInt() {
        long sum = 0;
        for (T x : a) {
            if (x != null) {
                System.out.print(x + " ");
                sum += x;
            }
        }
        System.out.println();
        System.out.println("Sum: "+sum);
    }
}

class ListerDemo {
    public static void main(String[] args) {
        Integer arr[] = new Integer[5];
        Lister<Integer> lister = new Lister<>(arr);
        lister.addInt(1, 0);
        lister.addInt(2, 10);
        lister.printInt();
        Lister<Integer> lister1 = new Lister<>(10);
    }
}