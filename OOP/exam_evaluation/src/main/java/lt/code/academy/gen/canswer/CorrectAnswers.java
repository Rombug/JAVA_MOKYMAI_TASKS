
package lt.code.academy.gen.canswer;

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
    "exam",
    "answers"
})

public class CorrectAnswers {

    @JsonProperty("exam")
    private Exam exam;
    @JsonProperty("answers")
    private List<CorrectAnswer> answers = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("exam")
    public Exam getExam() {
        return exam;
    }

    @JsonProperty("exam")
    public void setExam(Exam exam) {
        this.exam = exam;
    }

    @JsonProperty("answers")
    public List<CorrectAnswer> getAnswers() {
        return answers;
    }

    @JsonProperty("answers")
    public void setAnswers(List<CorrectAnswer> answers) {
        this.answers = answers;
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
