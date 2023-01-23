
package lt.code.academy.gen.sanswer;

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
    "student",
    "exam",
    "answers"
})
public class StudentAnswers {

    @JsonProperty("student")
    private Student student;
    @JsonProperty("exam")
    private Exam exam;
    @JsonProperty("answers")
    private List<StudentAnswer> answers = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("student")
    public Student getStudent() {
        return student;
    }

    @JsonProperty("student")
    public void setStudent(Student student) {
        this.student = student;
    }

    @JsonProperty("exam")
    public Exam getExam() {
        return exam;
    }

    @JsonProperty("exam")
    public void setExam(Exam exam) {
        this.exam = exam;
    }

    @JsonProperty("answers")
    public List<StudentAnswer> getAnswers() {
        return answers;
    }

    @JsonProperty("answers")
    public void setAnswers(List<StudentAnswer> answers) {
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
