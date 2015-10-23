/**
 * 测试定长报文注解
 *
 * @author shenshaomin
 * @version 1.0
 * @date 15/10/23
 */
public class Test {

    public static void main(String[] args) {

        byte[] msgs = "123456789ABCDEF".getBytes();
        PospMessage pospMessage = new PospMessage();
        MessageProcessUtil.fixedToObject(msgs, pospMessage);

        System.out.println("content:" + pospMessage.getContent());
        System.out.println("consumeMessage body:" + pospMessage.getConsumeMessage().getBody());
    }


}
