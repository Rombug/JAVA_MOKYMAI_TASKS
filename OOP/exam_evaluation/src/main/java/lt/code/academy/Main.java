package lt.code.academy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.code.academy.gen.canswer.CorrectAnswer;
import lt.code.academy.gen.canswer.CorrectAnswers;
import lt.code.academy.gen.sanswer.Exam;
import lt.code.academy.gen.sanswer.StudentAnswer;
import lt.code.academy.gen.sanswer.StudentAnswers;
import lt.code.academy.gen.score.Egzaminai;
import lt.code.academy.gen.score.Score;
import lt.code.academy.gen.score.StudentResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            // convert a JSON string to a Correct object
            // nuskaitom JSON ir uzkraunam i JAVA objekta
            CorrectAnswers correctAnswers = mapper.readValue(Paths.get("correct_answers.json").toFile(), CorrectAnswers.class);
          //  Map<String, String> count = checkStudent(correctAnswers, "student_answers.json");
          //  System.out.println("Corecct answers " + count);


            Score score = new Score();
            Egzaminai egzaminai = new Egzaminai();
            Exam exam = new Exam();

            //nusistatome titele is objekto
            egzaminai.setStudentResult(new ArrayList<>());
            egzaminai.setExamTitle(correctAnswers.getExam().getExamTitle());
            egzaminai.setId(correctAnswers.getExam().getId());
            exam.setExamType(correctAnswers.getExam().getExamTitle());




            score.setEgzaminai(new ArrayList<>());


            score.getEgzaminai().add(egzaminai);

           // er.setDate(new Date());
            Set<String> files = listFilesInDirectory("answers");
            for(String f : files){
                StudentAnswers studentAnswers=nuskaitytiIsFailo(f);
              //  er.getResults().add(
             //           checkStudent(correctAnswers, f);
                StudentResult studentResult = checkStudent(correctAnswers, studentAnswers);
                egzaminai.getStudentResult().add(studentResult);
	//);
            }
            mapper.writeValue(Paths.get("examResults.json").toFile(), score);
mapper.writeValue(System.out,score);
//
//            // write to new file
//            System.out.println(correctAnswers.getAnswers().size());
//            System.out.println(correctAnswers.getAnswers().toString());
//            mapper.writeValue(Paths.get("correct_answers1.json").toFile(), correctAnswers);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static StudentAnswers nuskaitytiIsFailo(String file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StudentAnswers studentAnswers = mapper.readValue(Paths.get(file).toFile(), StudentAnswers.class);
return studentAnswers;
    }
    public static StudentResult checkStudent (CorrectAnswers ca, StudentAnswers studentAnswers){
        StudentResult result = new StudentResult();

        result.setVardas(studentAnswers.getStudent().getName());
        result.setPavarde(studentAnswers.getStudent().getSurname());
        result.setScore(calculateScore(ca.getAnswers(),studentAnswers.getAnswers()));

        return result;
    }

    public static int calculateScore(List<CorrectAnswer> corrA, List<StudentAnswer> studA) {

        int caCount = 0;
        for (CorrectAnswer a: corrA){
            //    System.out.println(a.getQuestion() + " " + a.getAnswer());
            StudentAnswer sa = surastiStudentoAtsakyma(studA,a.getQuestion());
            if(sa != null && sa.getAnswer().equals(a.getAnswer())){
                caCount++;
            }else{
                //      print(fail)
            }
        }
        return caCount;
    }

    public static StudentAnswer surastiStudentoAtsakyma(List<StudentAnswer> list, Integer klausimoNumeis){
        Optional<StudentAnswer> ans = list.stream()
                .filter(sa -> sa.getQuestion().equals(klausimoNumeis)) // eina per sarasa ir tikrina klausimo atsakymus
                .findAny();
        //
        //ans.map(sa -> sa.getAnswer()).filter(sa -> a.getAnswer().equals(sa)).isPresent();

        StudentAnswer sa = ans.orElse(null);
        return sa;

    }
    // iesko dir "answers"
    public static Set<String> listFilesInDirectory(String dir) throws IOException {
      //  try (Stream<Path> stream = Files.list(Paths.get(dir))) {
        // pasiima answers dir ir pasiima visus failus
        Stream<Path> stream = Files.list(Paths.get(dir)); // pasiima answers dir ir pasiima visus failus
            return stream
                    .filter(file -> !Files.isDirectory(file)) // jei tai ne dir
                    .map(Path::toAbsolutePath)  // paverti i Absolute kelia
                    .map(Path::toString)
                    .collect(Collectors.toSet()); // fisus failus i string ir sudeda i Set

    }
}
