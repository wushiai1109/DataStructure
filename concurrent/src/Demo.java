import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

/**
 * @ClassName Demo
 * @Description
 * @Author Bruce
 * @Date 2020/8/20 8:00 下午
 */
public class Demo {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d);

        Instant instant = Instant.now();
        System.out.println(instant);

        System.out.println(instant.atZone(ZoneId.systemDefault()));

        System.out.println(instant.atZone(ZoneId.systemDefault()));

        System.out.println();

    }
}
