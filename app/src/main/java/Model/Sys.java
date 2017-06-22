package Model;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by epitos on 20/06/2017.
 */

public class Sys {

    @SerializedName("pod")
    private String pod;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @SerializedName("pod")
    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }


    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
