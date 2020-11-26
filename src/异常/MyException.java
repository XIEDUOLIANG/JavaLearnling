package 异常;

public class MyException extends Exception {

    private static final String DEFAULT_CODE = "0";

    private String code;
    private String msg;

    public MyException(){

    }

    public MyException(String msg){
        this.code = DEFAULT_CODE;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }
}
