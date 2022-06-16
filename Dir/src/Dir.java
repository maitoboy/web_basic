import org.json.JSONException;
import org.json.JSONObject;

public class Dir {

    public static void main(String[] args) throws JSONException {

        JSONObject jo = new JSONObject();
        jo.put("name", "Jone");
        jo.put("city", "Seoul");

        System.out.println(jo.toString());
    }
}