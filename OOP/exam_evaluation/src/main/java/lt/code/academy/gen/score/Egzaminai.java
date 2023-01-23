
package lt.code.academy.gen.score;

import java.util.HashMap;
import java.util.List;
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
    "studentResult"
})

public class Egzaminai {

    @JsonProperty("id")
    private String id;
    @JsonProperty("examTitle")
    private String examTitle;
    @JsonProperty("studentResult")
    private List<StudentResult> studentResult = null;
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

    @JsonProperty("studentResult")
    public List<StudentResult> getStudentResult() {
        return studentResult;
    }

    @JsonProperty("studentResult")
    public void setStudentResult(List<StudentResult> studentResult) {
        this.studentResult = studentResult;
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
