package ru.edu;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Класс для вывода содержимого директории output с результатом в лог сборки на этапе verify.
 *
 * Не редактировать.
 */
public class AfterBuildConsoleWriter {

    public static void main(String[] args) {
        Stream.of(Objects.requireNonNull(new File("./output").listFiles()))
                .forEach(AfterBuildConsoleWriter::echoFileContents);
    }

    private static void echoFileContents(File file) {
        try(Stream<String> stream = Files.lines(file.toPath(), StandardCharsets.UTF_8)){
            System.out.println("Content of '"+file.getName()+"':");
            stream.forEach(System.out::println);
            System.out.println("End content of '"+file.getName()+"'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
