package Main.clazz;

import Main.enumator.TypeMessageEnum;
import static Main.enumator.TypeMessageEnum.LOGIN;
import static Main.enumator.TypeMessageEnum.LOGOUT;
import static Main.enumator.TypeMessageEnum.PRIVATE;
import static Main.enumator.TypeMessageEnum.PUBLIC;

import java.io.Serializable;

public class Message implements Serializable {

    private String sender, receiver, textMessage;
    private TypeMessageEnum typeMessageEnum;

    public TypeMessageEnum getTypeMessageEnum() {
        return typeMessageEnum;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public Message(String sender, String receiver, String textMessage, TypeMessageEnum typeMessageEnum) {
        String msg = "";
        this.sender = sender;
        this.receiver = receiver;
        this.typeMessageEnum = typeMessageEnum;

        switch (this.typeMessageEnum) {
            case LOGIN:
                msg = "(" + sender + ") entrou no chat!";
                break;
            case LOGOUT:
                msg = "(" + sender + ") saiu do chat!";
                break;
            case PUBLIC:
                msg = "(" + sender + "): " + textMessage;
                break;
            case PRIVATE:
                msg = "(" + sender + ") para (" + receiver + "): " + textMessage;
                break;
        }
        this.textMessage = msg;
    }

    @Override
    public String toString() {
        return "Message{"
                + "sender='" + sender + '\''
                + ", receiver='" + receiver + '\''
                + ", textMessage='" + textMessage + '\''
                + ", typeMessageEnum=" + typeMessageEnum
                + '}';
    }
}
