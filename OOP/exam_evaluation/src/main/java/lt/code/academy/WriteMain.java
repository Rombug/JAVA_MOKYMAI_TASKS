package lt.code.academy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class WriteMain {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        Student student = new Student("Romanas", "Bugakovas", 1001);
        Student secondStudent = new Student("Saule", "Patamse", 1002);

        File studentFile = new File("students.json");
        if (!studentFile.exists()){
            studentFile.createNewFile();
        }

        mapper.writeValue(studentFile, List.of(student, secondStudent));


        ExamTitle examTitle = new ExamTitle(101, "OOP pagrindai", "Testas");
        ExamTitle secondExamTitle = new ExamTitle(102, "OOP kodas", "Testas su keliais galimais atsakymais");

        File examTitleFile = new File("examTitles.json");
        if (!examTitleFile.exists()){
            examTitleFile.createNewFile();
        }

        mapper.writeValue(examTitleFile, List.of(examTitle, secondExamTitle));
    }
}
