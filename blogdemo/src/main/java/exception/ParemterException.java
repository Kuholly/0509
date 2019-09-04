package exception;

import jdk.nashorn.internal.objects.annotations.Getter;


public class ParemterException extends RuntimeException {

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ParemterException(){

    }
    public ParemterException(String message){
        super("客户端错误:"+message);
        code = "400";
    }

    public ParemterException(String message,Throwable cause){
        super("客户端错误："+message,cause);
        code = "400";
    }


}
