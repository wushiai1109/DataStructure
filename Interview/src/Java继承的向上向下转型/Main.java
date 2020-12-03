package Java继承的向上向下转型;

/**
 * @ClassName Main
 * @Description
 * @Author Bruce
 * @Date 2020/11/14 11:49 下午
 */
public class Main {
    public static void main(String[] args) {
        Fruit fruit = new Apple();
        fruit.show();
        //这里用到了向上转型，换言之，就是用父类的引用变量去引用子类的实例，这是允许的。
        // 当向上转型之后，父类引用变量可以访问子类中属于父类的属性和方法，但是不能访问子类独有的属性和方法。
        // 例子中由于子类重写了父类的show（）方法，所以调用的show（）方法是子类的show（）方法，
        // 输出结果为：“this is a apple”,而调用子类的test（）方法则会报错。
//        fruit.test();//报错


        //向下转型
        //并不是所有的对象都可以向下转型，只有当这个对象原本就是子类对象通过向上转型得到的时候才能够成功转型。
        //实例化Apple类，并新建一个Fruit类的引用变量“fruit”引用该实例，然后新建一个Apple类的引用变量，引用向下转型的“fruit”变量
        Fruit fruit1 = new Apple();
        Apple apple = (Apple) fruit1;
        apple.show();
        apple.test();


//        实例化Apple类，并新建一个Fruit类的引用变量“fruit”引用该实例，然后新建一个Orange类的引用变量，引用向下转型的“fruit”变量
//        代码虽然能够编译成功，但是在运行的时候会报错，因为fruit对象是由Apple对象向上转型得到的，只能够向下转型成Apple对象，不能够向下转型成Orange对象
        Fruit fruit2 = new Apple();
        Orange orange = (Orange) fruit2;
    }
}
