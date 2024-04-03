public class UpgradedTriangle {

    public String classifyTriangle(Integer a, Integer b, Integer c) {
        /** 这里<=0对于超过缓存的限制的数比如-10000也会正常判断
         *  因为当涉及到 <, <=, >, >= 这样的比较运算符时，Java 自动对 Integer 对象进行拆箱（auto-unboxing）
         *  将它们转换成原始的 int 类型，然后进行比较
        **/
        Integer temp = 0;
//        if (a == null || b == null || c == null || a <= 0 || b <= 0 || c <= 0)
        if (a == null || b == null || c == null || a <= temp || b <= temp || c <= temp)
            return "INVALID";
        if ((a + b > c) && (b + c > a) && (c + a > b)){
            /** 使用 == 来比较两个 Integer 对象时，结果取决于 Java 对 Integer 缓存的实现。
             * 在大多数 Java 实现中，Integer 类型有一个缓存范围，默认是从 -128 到 127。
             * 这意味着，在这个范围内的 Integer 对象，如果它们的数值相同，那么它们实际上指向的是同一个对象。
             * 因此，使用 == 进行比较时会返回 true。
             * 但是，对于超出这个范围的数值，Java 会为每个值创建新的 Integer 对象。
             * 因此，即使两个 Integer 对象代表的数值相同，它们也是不同的对象实例，使用 == 比较时会返回 false，
             * 因为 == 比较的是对象的引用，而不是值。
            **/
            if (a.equals(b) && b.equals(c)) // ==只能用于-128-127，具体范围根据具体的JVM定（缓存导致）
                return "EQUILATERAL";
            else if (a.equals(b) || b.equals(c) || c.equals(a))
                return "ISOSCELES";
            else return "SCALENE";
        }
        else
            return "INVALID";
    }

    public double getArea(Integer a, Integer b, Integer c) {
        if (!classifyTriangle(a, b, c).equals("INVALID")) {
            // 如果是(double) ((a + b + c) / 2)这里是计算完毕之后才会有double作用即double没起作用
            double p = (double) (a + b + c) / 2;
            double in = p * (p - (double) a) * (p - (double) c) * (p - (double) b);
            return Math.sqrt(in);
        } else
            return 0;
    }
}
