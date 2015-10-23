import java.io.Serializable;

/**
 * POSP 报文
 *
 * @author shenshaomin
 * @version 1.0
 * @date 15/10/23
 */
public class PospMessage implements Serializable {

    @FixedMessageDescAnnotation(seq = 0, len = 2)
    private String type;

    @FixedMessageDescAnnotation(seq = 1, len = 4)
    private String content;

    @FixedMessageDescAnnotation(seq = 2, len = 1)
    private String len;

    @FixedMessageDescAnnotation(seq = 3, len = 5, isIncludeSubset = true)
    private ConsumeMessage consumeMessage;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLen() {
        return len;
    }

    public void setLen(String len) {
        this.len = len;
    }

    public ConsumeMessage getConsumeMessage() {
        return consumeMessage;
    }

    public void setConsumeMessage(ConsumeMessage consumeMessage) {
        this.consumeMessage = consumeMessage;
    }
}
