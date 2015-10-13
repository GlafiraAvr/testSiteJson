package json.Bean;

import json.JSonBean;

/**
 * Created by Glafira on 09.10.2015.
 */
public class JsonBeanPerson extends JSonBean {
    private  String PersonName = "Homer";
    private  int Age =40;

    public void setPersonName(String personName) {
        PersonName = personName;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getPersonName() {

        return PersonName;
    }

    public int getAge() {
        return Age;
    }
}
