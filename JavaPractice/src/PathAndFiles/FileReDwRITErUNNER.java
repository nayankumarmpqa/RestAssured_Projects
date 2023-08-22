package PathAndFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReDwRITErUNNER {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("./resourcesDirectory/sample.txt");
        String fileContent = Files.readString(path);
        System.out.println(fileContent);

        String replacedText = fileContent.replace("Line", "My Line");
        Path newFilePath= Paths.get("./resourcesDirectory/sample2.txt");
        Files.writeString(newFilePath, replacedText);

    }
}
