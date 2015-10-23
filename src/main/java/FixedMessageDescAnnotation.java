import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * FixedMessageDescAnnotation
 *
 * @author shenshaomin
 * @version 1.0
 * @date 15/10/23
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FixedMessageDescAnnotation {

    int seq();
    int len();
    boolean isIncludeSubset() default false;

}
