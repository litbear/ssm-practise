import org.junit.Test;
import org.litbear.ssm.Gender;

/**
 * Created by litbear on 2017/7/15.
 */
public class EnumTest {

    @Test
    public void enumApiTest() {
        System.out.println(Week.Wednesday instanceof Enum);
    }

    @Test
    public void testEnum() {
        System.out.println(Gender.valueOf("MALE"));
    }
}
