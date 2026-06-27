public class MyException extends RuntimeException{
    int errorCode=0;
    public MyException(int err){
        this.errorCode=err;
    }

    public int getErrorCode(){
        return errorCode;
    }

    @Override
    public String toString() {
        return "MyException{" +
                "errorCode=" + errorCode +
                '}';
    }
}
