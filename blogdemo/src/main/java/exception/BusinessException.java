package exception;

public class BusinessException extends RuntimeException{
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BusinessException(String message) {
        super("客户端异常"+message);
        code = "401";
    }

    public BusinessException(String message, Throwable cause) {
        super("客户端异常"+message, cause);
        code = "401";
    }
}
