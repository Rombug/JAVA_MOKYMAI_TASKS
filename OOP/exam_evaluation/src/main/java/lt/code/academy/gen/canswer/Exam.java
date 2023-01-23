
package lt.code.academy.gen.canswer;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "examTitle",
    "examType"
})
public class Exam {

    @JsonProperty("id")
    private String id;
    @JsonProperty("examTitle")
    private String examTitle;
    @JsonProperty("examType")
    private String examType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("examTitle")
    public String getExamTitle() {
        return examTitle;
    }

    @JsonProperty("examTitle")
    public void setExamTitle(String examTitle) {
        this.examTitle = examTitle;
    }

    @JsonProperty("examType")
    public String getExamType() {
        return examType;
    }

    @JsonProperty("examType")
    public void setExamType(String examType) {
        this.examType = examType;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
