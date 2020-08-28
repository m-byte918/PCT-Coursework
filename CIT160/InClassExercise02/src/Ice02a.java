// Christian Rodriguez
// 9/5/2019
// Exploring the use of arithmetic operators

public class Ice02a {
    public static void main(String[] args) {
        /** Main exercise **/
        int y = 2001;
        int a = y % 19;
        int b = y / 100;
        int c = y % 100;
        int d = b / 4;
        int e = b % 4;
        int g = (8 * b + 13) / 25;
        int h = (19 * a + b - d - g + 15) % 30;
        int j = c / 4;
        int k = c % 4;
        int m = (a + 11 * h) / 319;
        int r = (2 * e + 2 * j - k - h + m + 32) % 7;
        int n = (h - m + r + 90) / 25;
        int p = (h - m + r + n + 19) % 32;
        
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        System.out.println("e = " + e);
        System.out.println("g = " + g);
        System.out.println("h = " + h);
        System.out.println("j = " + j);
        System.out.println("k = " + k);
        System.out.println("m = " + m);
        System.out.println("r = " + r);
        System.out.println("n = " + n);
        System.out.println("p = " + p);
        
        /** Questions **/
        double d1 = 3.1;
        double d2 = 1.0;
        int i1 = 5;
        int i2 = 10;
        int i3 = 7;
        
        System.out.println("------------------");
        System.out.println("a = " + (d2 + d1));
        System.out.println("b = " + (i1 + d1));
        System.out.println("c = " + (i1 + i2 * i3));
        System.out.println("d = " + (i2 % i3));
        System.out.println("e = " + (i3/i2 + i1 * 5));
        System.out.println("f = " + (d1/i2 + d1));
        System.out.println("g = " + (i2 + i3 + 3.0));
        System.out.println("h = " + (i2 * d2 + 4));
        System.out.println("i = " + (i1/i3));
    }
}
