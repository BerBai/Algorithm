import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Java8 方法引用的三种语法格式
 * 1. 对象::实例方法名
 * 2. 类::静态方法名
 * 3. 类::实例方法名
 * lambda表达式是函数式接口的一个实例
 */
public class MethodReference {
    /**
     * 方法一：对象::实例方法名
     * 被调用的方法的参数列表和返回值类型需要与函数式接口中抽象方法的参数列表和返回值类型要一致。
     */
    // 1. lambda表达式
    Consumer<String> con1 = x -> System.out.println(x);

    // 2. 方法引用
    Consumer<String> con2 = System.out::println;

/*    // consumer接口
    @FunctionalInterface
    public interface Consumer<T> {
       void accept(T t);
    }*/


    /**
     * 方法二  类::静态方法名
     * 被调用的方法的参数列表和返回值类型需要与函数式接口中抽象方法的参数列表和返回值类型要一致。
     */
    // 1. lambda表达式
    Comparator<Integer> com1 = (x, y) -> Integer.compare(x, y);

    // 2. 方法引用
    Comparator<Integer> com2 = Integer::compare;

/*    // Comparator接口
    public interface Comparator<T> {
        int compare(T o1, T o2);
    }*/

/*    // Integer类部分内容:
    @FunctionalInterface
    public final class Integer extends Number implements Comparable<Integer> {
        public static int compare(int x, int y) {
            return (x < y) ? -1 : ((x == y) ? 0 : 1);
        }
    }*/

    /**
     * 方法三：类::实例方法名
     * 第一个参数是这个实例方法的调用者，第二个参数是这个实例方法的参数时，就可以使用这种语法。
     */
    // 1. lambda表达式
    BiPredicate<String, String> bp1 = (x, y) -> x.equals(y);

    // 2. 方法引用
    BiPredicate<String, String> bp2 = String::equals;

/*    //BiPredicate接口：
    @FunctionalInterface
    public interface BiPredicate<T, U> {
        boolean test(T t, U u);
    }*/

}

/**
 * 构造器引用
 * 1. 类::new
 */
class ConstructorReference {
    /**
     * person类中有两个构造器，要调用哪个构造器是函数式接口决定的
     * 也就是Supplier接口中的get()方法是无参的，那么就调用的是person中的无参构造器。
     */
    // Person类
    public class Person implements Serializable {
        private static final long serialVersionUID = -7008474395345458049L;

        private String name;
        private int age;

        public Person() {
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    // 1.lambda表达式
    Supplier<Person> supplier1 = () -> new Person();

    // 2.构造器引用
    Supplier<Person> supplier2 = Person::new;

/*    // Supplier接口 还有BooleanSupplier、DoubleSupplier、IntSupplier、LongSupplier
         Supplier是用来提供一个对象,至于提供的对象的构造则由其来定义
            方法：T get() 获取提供对象实例
    @FunctionalInterface
    public interface Supplier<T> {
        T get();
    }*/
}

/**
 * 数组引用
 * 1. Type::new
 */
class ArrayRerference {
    // lambda表达式
    Function<Integer, String[]> fun1 = x -> new String[x];

    // 数组引用
    Function<Integer, String[]> fun2 = String[]::new;

/*    // Function接口部分内容
    @FunctionalInterface
    public interface Function<T, R> {
        R apply(T t);
    }*/
}

class ReferenceMainTest {

    static int count = 0;

    public static class TestA {

        private String name;
        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public TestA() {
            count++;
            System.out.println("无参构造，第" + count + "次");
        }

    }

    // 获取最大值
    public static int getMax(Supplier<Integer> sup) {
        return sup.get();
    }

    public static void main(String[] args) {
        List<String> strList = Arrays.asList(new String[]{"a", "c", "b", "A"});
        // lambda表达式
        strList.stream()
                .sorted((s1, s2) -> s1.compareToIgnoreCase(s2)) // 忽略大小写排序
                .forEach(s -> System.out.println(s));

        // ::方法引用
        strList.stream()
                .sorted(String::compareToIgnoreCase)
                .forEach(System.out::println);


        // 对比不同方式创建TestA对象
        System.out.println("不同方式创建TestA对象");
        TestA a = new TestA();

        Supplier<TestA> supplier = TestA::new; // 定义无参构造方法的入口
        TestA b = supplier.get(); // 真正创建对象
        supplier.get(); // 每一次创建一个新对象

        // 实验Supplier应用
        System.out.println("Supplier应用--int[]数组获取最大值");
        int[] nums = {0, 2, 21, 67};
        // 1
        Supplier<Integer> supplier1 = () -> Arrays.stream(nums).max().getAsInt();
        System.out.println("maxNum: " + supplier1.get());
        // 2
        int maxNum = getMax(() -> Arrays.stream(nums).max().getAsInt()); // 对interesting操作会转换成OptionalInt对象，通过getAsInt()获得int
        System.out.println("maxNum: " + maxNum);
        // 3
        Arrays.stream(nums).max().ifPresent(s -> System.out.println("maxNum: " + s)); // Optional.ifPresent(Consumer<?super T> consumer) 若存在值则执行consumer接口的实现方法

    }
}

/*总结
方法应用及构造器引用其实可以理解为lamdba的另一种表现形式
方法引用被调用的方法的参数列表和返回值类型需要与函数式接口中抽象方法的参数列表和返回值类型要一致
方法引用中使用类::实例方法的条件是第一个参数是这个实例方法的调用者，第二个参数是这个实例方法的参数
构造器引用需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表一致
*/