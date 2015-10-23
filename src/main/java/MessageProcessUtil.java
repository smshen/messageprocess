import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/**
 * 报文处理工具类
 *
 * @author shenshaomin
 * @version 1.0
 * @date 15/10/23
 */
public class MessageProcessUtil {

    public static <T> T fixedToObject(byte[] msgs, T obj) {
        try {
            ByteBuffer bb = ByteBuffer.wrap(msgs);

            Class<? extends Object> clazz = obj.getClass();

            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                FixedMessageDescAnnotation fmda = field.getAnnotation(FixedMessageDescAnnotation.class);
                if (fmda != null) {
                    Method method = null;

                    method = clazz.getMethod(getSetMethodName(field.getName()), field.getType());
                    if (fmda.isIncludeSubset()) {
                        Object o = field.getType().newInstance();
                        byte[] tmp = new byte[msgs.length - bb.position()];
                        bb.get(tmp);
                        method.invoke(obj, fixedToObject(tmp, o));
                    } else {
                        byte[] bytes = new byte[fmda.len()];
                        bb.get(bytes);
                        String arg = new String(bytes);
                        method.invoke(obj, arg);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static String getSetMethodName(String fieldName) {
        return "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }


}
