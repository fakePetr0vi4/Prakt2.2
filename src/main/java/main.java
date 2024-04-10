import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class main {
    public static void main(String[] args){
        System.out.println("Старт программы");
        String server = "https://android-for-students.ru";
        String serverPath = "/materials/practical/hello.php";
        HashMap<String,String> map = new HashMap();
        map.put("name", "Maximov");
        map.put("group", "RIBO-05-22");
        HTTPRunnable httpRunnable = new HTTPRunnable(server + serverPath, map);

        Thread th = new Thread(httpRunnable);
        th.start();
        try{
            th.join();
        }catch (InterruptedException ex){

    }finally {
            JSONObject jSONObject = new JSONObject(httpRunnable.getResponseBody());
            int result = jSONObject.getInt("result_code");
            System.out.println("result: " + result);
            System.out.println("Type: " + jSONObject.getString("message_type"));
            System.out.println("Text: " + jSONObject.getString("message_text"));
            switch (result){
                case 1:
                    JSONArray jSONArray = jSONObject.getJSONArray("task_list");
                    System.out.println("Task list: ");
                    for(int i =0; i < jSONArray.length();i++){
                        System.out.println((i+1)+ ")"+jSONArray.get(i));

                    }
                    break;
                case 0: //если сервер вернул ошибку

                    break;
                default: //остальные случаи
                    break;
            }

        }
        }
}
