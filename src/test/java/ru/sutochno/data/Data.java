package ru.sutochno.data;

import ru.sutochno.api.requests.Requests;
import ru.sutochno.config.Project;

import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;

public class Data {

    public final String AUTH_COOKIE =  new Requests().getAuth(Project.config.userPhone(), Project.config.userPassword());

    public String judgmentText = new String((Files.readAllBytes(Paths.get("src/test/resources/data/judgmentText.txt"))));

    public String photo1 = "src/test/resources/images/1.jpeg";
    public String photo2 = "src/test/resources/images/2.jpeg";
    public String photo3 = "src/test/resources/images/3.jpg";

    public Data() throws IOException {
    }
}
