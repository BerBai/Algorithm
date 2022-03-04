/**
 * @author ber
 * @version 1.0
 * @date 22/3/4 20:49
 */
public class Sort<T> {

//    public <T> T[] BubbleSort(T list[], int len) {
//        for (int i = 1; i < len; i++) {
//            for (int j = len - 1; j >= i; j--) {
//                if(list[j] < list[j-1]) {
//
//                }
//            }
//        }
//    }

    public static class Test{
        public static void main(String[] args) {
            Integer i[] = fun1(1,2,3,4,5,6);//返回泛型数组
            fun2(i);//输出数组内容
        }
        public static <T> T[] fun1(T...arg){//接收可变参数，返回泛型数组，新特性的使用
            return arg;//返回泛型数组
        }
        public static <T> void fun2(T param[]){//接收泛型数组
            System.out.println("接收泛型数组：");
            for(T t: param){//新特性
                System.out.print(t + "、");
            }
            System.out.println();
        }
    }


}
