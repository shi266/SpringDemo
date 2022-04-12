package sanqi.com.util;

public class ReturnJSON {
    private Boolean success;
    private Object data;


    @Override
    public String toString() {
        return "ReturnJSON{" +
                "success=" + success +
                ", data=" + data +
                '}';
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
