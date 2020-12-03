package Java继承的向上向下转型;

/**
 * @ClassName Apple
 * @Description
 * @Author Bruce
 * @Date 2020/11/14 11:48 下午
 */
class Apple extends Fruit{
    @Override
    public void show() {
        System.out.println("this is a apple");
    }
    public void test() {
        System.out.println("i am a apple");
    }
}
