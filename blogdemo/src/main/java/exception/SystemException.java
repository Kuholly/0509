package exception;

public class SystemException extends RuntimeException{
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public SystemException(String message) {
        super("系统异常"+message);
        code = "501";
    }

    public SystemException(String message, Throwable cause) {
        super("系统给异常"+message, cause);
        code = "501";
    }
}
