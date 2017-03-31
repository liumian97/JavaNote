package examination.school;

/**
 * 消息头
 * Created by liumian on 2017/3/28.
 */
public class CmppConnectHeader {

    private int totalLength;

    private int commandId;

    private int sequenceId;

    public int getTotalLength() {
        return totalLength;
    }

    public void setTotalLength(int totalLength) {
        this.totalLength = totalLength;
    }

    public int getCommandId() {
        return commandId;
    }

    public void setCommandId(int commandId) {
        this.commandId = commandId;
    }

    public int getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(int sequenceId) {
        this.sequenceId = sequenceId;
    }
}
