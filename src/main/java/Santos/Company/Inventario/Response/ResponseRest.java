package Santos.Company.Inventario.Response;

import java.util.ArrayList;
import java.util.HashMap;

public class ResponseRest {

    private final ArrayList<HashMap<String, String>> metadata = new ArrayList<>();

    public ArrayList<HashMap<String, String>> getMetadata() {
        return metadata;
    }

    public void setMetadata(String type, String code, String date) {
        HashMap<String, String> map = new HashMap<>();

        map.put("type",type);
        map.put("code",code);
        map.put("date",date);

        metadata.add(map);
    }

    
}
