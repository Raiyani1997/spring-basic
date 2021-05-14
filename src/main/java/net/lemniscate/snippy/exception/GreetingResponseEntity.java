package net.lemniscate.snippy.exception;

public class GreetingResponseEntity {

    protected String message;
    protected Object data;
    protected int errorCode;

    public GreetingResponseEntity(String message, int errorcode) {
        this.message = message;
        this.errorCode = errorcode;
    }

    public GreetingResponseEntity(String message, int errorcode, Object data) {
        this.message = message;
        this.data = data;
        this.errorCode = errorcode;
    }

    GreetingResponseEntity(String message) {
        this.message = message;
        this.errorCode = ResponseCode.ERROR.getResponseCode();
    }

    /**
     * Retrieve message details.
     * @return Returns message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Retrieve data.
     * @return Returns data.
     */
    public Object getData() {
        return data;
    }

    /**
     * Retrieves error code.
     * @return Returns error code.
     */
    public int getErrorCode() {
        return errorCode;
    }

}