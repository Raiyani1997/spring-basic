package net.lemniscate.snippy.exception;

public class GreetingException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    GreetingResponseEntity agdRes;

    public GreetingException(String message, Exception exception) {
        super(message, exception);
        this.agdRes = new GreetingResponseEntity(message);
    }

    public GreetingException(String message, int errorCode) {
        super(message);
        this.agdRes = new GreetingResponseEntity(message, errorCode);
    }

    public GreetingException(String message, int errorCode, Object data) {
        super(message);
        this.agdRes = new GreetingResponseEntity(message, errorCode, data);
    }

    public GreetingResponseEntity getResponse() {
        return agdRes;
    }

}