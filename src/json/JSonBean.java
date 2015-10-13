package json;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Glafira on 09.10.2015.
 */
public class JSonBean implements  JSonSerialize {

    @Override
    public boolean formJSonObject(JSONObject object) {
       Class BeanClass = this.getClass();
        Method[] methods = BeanClass.getMethods();
        for (int i = 0; i <methods.length ; i++) {
            try {
            Method method = methods[i];
            String name= method.getName();
            String key="";
            if (name.startsWith("set")){
                key = name.substring(3);

            }
            if (key.length()>0 && Character.isUpperCase(key.charAt(0)) &&
            method.getGenericParameterTypes().length==1) {
                if (key.length() == 1) {
                    key.toLowerCase();
                } else {
                    if (!Character.isUpperCase(key.charAt(1))) {
                        key = key.substring(0, 1).toLowerCase() + key.substring(1);
                    }

                }

                if (isAllowedKey(key))
                method.invoke(this,toJSonObject().get(key));

            }
                } catch (Exception e) {
                   return  false;
                }

            }

        return true;
    }

    private boolean isAllowedKey(String key) {
        return ((key!="class") && (key!="instance"));
    }

    @Override
    public JSONObject toJSonObject() {

        return new JSONObject(this){
            @Override
            public  Object get(String key) throws JSONException {
                return isAllowedKey(key) ? super.get(key) : null;

            }

        };
    }
}
