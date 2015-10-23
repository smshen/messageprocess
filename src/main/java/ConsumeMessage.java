import java.io.Serializable;

/**
 * 消费报文
 *
 * @author shenshaomin
 * @version 1.0
 * @date 15/10/23
 */
public class ConsumeMessage implements Serializable {

    @FixedMessageDescAnnotation(seq = 0, len = 2)
    private String head;

    @FixedMessageDescAnnotation(seq = 1, len = 3)
    private String body;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
