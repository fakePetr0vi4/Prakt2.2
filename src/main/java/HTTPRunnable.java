import java.util.HashMap;

public class HTTPRunnable implements Runnable {

    private String address;
    private HashMap<String, String> requestBody;
    private  String responseBody;

    public HTTPRunnable (String address, HashMap<String, String> requestBody){
        this.address = address;
        this.requestBody = requestBody;
    }

    public String getResponseBody() {
        return responseBody;
    }

    @Override
    public void run() {

    }
}
