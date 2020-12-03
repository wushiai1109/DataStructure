package Java继承的向上向下转型;

/**
 * @ClassName Orange
 * @Description
 * @Author Bruce
 * @Date 2020/11/14 11:52 下午
 */
class Orange extends Fruit{
    @Override
    public void show() {
        System.out.println("this is a Orange");
    }
    public void test() {
        System.out.println("i am a Orange");
    }
}