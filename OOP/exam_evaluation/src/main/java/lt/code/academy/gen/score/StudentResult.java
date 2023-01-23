
package lt.code.academy.gen.score;

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
    "vardas",
    "pavarde",
    "score"
})
public class StudentResult {

    @JsonProperty("id")
    private String id;
    @JsonProperty("vardas")
    private String vardas;
    @JsonProperty("pavarde")
    private String pavarde;
    @JsonProperty("score")
    private Integer score;
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

    @JsonProperty("vardas")
    public String getVardas() {
        return vardas;
    }

    @JsonProperty("vardas")
    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    @JsonProperty("pavarde")
    public String getPavarde() {
        return pavarde;
    }

    @JsonProperty("pavarde")
    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    @JsonProperty("score")
    public Integer getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(Integer score) {
        this.score = score;
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
