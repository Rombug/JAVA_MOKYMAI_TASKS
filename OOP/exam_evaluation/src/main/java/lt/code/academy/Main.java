package lt.code.academy;

import com.fasterxml.jackson.databind.ObjectMapper;
import lt.code.academy.gen.canswer.CorrectAnswer;
import lt.code.academy.gen.canswer.CorrectAnswers;
import lt.code.academy.gen.sanswer.StudentAnswer;
import lt.code.academy.gen.sanswer.StudentAnswers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert a JSON string to a Correct object
            CorrectAnswers correctAnswers = mapper.readValue(Paths.get("correct_answers.json").toFile(), CorrectAnswers.class);
          //  Map<String, String> count = checkStudent(correctAnswers, "student_answers.json");
          //  System.out.println("Corecct answers " + count);



           // ExamResult er = new ExamResult();
           // er.setDate(new Date());
            Set<String> files = listFilesUsingFilesList("answers");
            for(String f : files){
              //  er.getResults().add(
             //           checkStudent(correctAnswers, f);
                System.out.println(checkStudent(correctAnswers, f));
	//);
            }
      //      objectMapper.write("examResults.json",er);


            // write to new file
            System.out.println(correctAnswers.getAnswers().size());
            System.out.println(correctAnswers.getAnswers().toString());
            mapper.writeValue(Paths.get("correct_answers1.json").toFile(), correctAnswers);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Map<String, String> checkStudent (CorrectAnswers ca, String file) throws IOException {
        Map<String, String> result = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        StudentAnswers studentAnswers = mapper.readValue(Paths.get(file).toFile(), StudentAnswers.class);
        result.put("name", studentAnswers.getStudent().getName());
        int caCount = 0;
        for (CorrectAnswer a: ca.getAnswers()){
        //    System.out.println(a.getQuestion() + " " + a.getAnswer());
            Optional<StudentAnswer> ans = studentAnswers.getAnswers().stream()
                    .filter(sa -> sa.getQuestion().equals(a.getQuestion())) // eina per sarasa ir tikrina klausimo atsakymus
                    .findAny();
            //
            //ans.map(sa -> sa.getAnswer()).filter(sa -> a.getAnswer().equals(sa)).isPresent();

            StudentAnswer sa = ans.orElse(null);
            if(sa != null && sa.getAnswer().equals(a.getAnswer())){
                caCount++;
            }else{
          //      print(fail)
            }
        }
        result.put("count", String.valueOf(caCount));
        return result;
    }

    public static Set<String> listFilesUsingFilesList(String dir) throws IOException {
        try (Stream<Path> stream = Files.list(Paths.get(dir))) {
            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .map(Path::toAbsolutePath)
                    .map(Path::toString)
                    .collect(Collectors.toSet());
        }
    }
}
