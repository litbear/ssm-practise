import org.junit.Test;
import org.litbear.ssm.pojo.Gender;

import java.math.RoundingMode;

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
//        System.out.println(Gender.valueOf("MALE"));
        Gender[] enumConstants = Gender.class.getEnumConstants();
        for (Gender gender: enumConstants) {
            System.out.println(gender);
        }
        switch (Gender.FEMALE.ordinal()) {
        }
        System.out.println("--------------------");
        String name = Gender.MALE.name();
        System.out.println(name);
    }

    @Test
    public void testRoundingMode(){
        RoundingMode[] enumConstants = RoundingMode.class.getEnumConstants();
        for (RoundingMode mode:enumConstants) {
            System.out.println(mode);
        }
    }
}
