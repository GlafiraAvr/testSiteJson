package json;

import org.json.JSONObject;

/**
 * Created by Glafira on 09.10.2015.
 */
public interface JSonSerialize {
    public boolean formJSonObject(JSONObject object);
    public JSONObject toJSonObject();
}
