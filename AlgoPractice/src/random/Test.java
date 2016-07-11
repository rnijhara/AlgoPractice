package random;

class Box {
    int a, b;
    final int c;
    static int d;

    public Box(int a, int b, int c, int d) {
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
    }
    
    void red(int a, int b) {
        
    }
    
    <T, V> void red(int a, int b, int c) {
        
    }
    
}

class Test extends Box {
    public static void main(String... args) {
        System.out.println(Test.d);
        
    }

    public Test(int a, int b, int c, int d) {
        super(a, b, c, d);
    }
}
