package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ConsoleChat {

    private final String path;
    private final String botAnswers;
    private final static String OUT = "Закончить";
    private final static String STOP = "Стоп";
    private final static String CONTINUE = "Продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() throws IOException {
       List<String> list = new ArrayList<>();
       List<String> log = readPhrases();
       boolean flag = false;
       boolean isWin = true;
       try (BufferedReader reader = new BufferedReader(
               new InputStreamReader(System.in, Charset.forName("UTF-8")))) {
           String line = reader.readLine();
           list.add(line);
           while (!flag) {
               if (line.equals(STOP)) {
                   isWin = false;
               } else if (line.equals(CONTINUE)) {
                   isWin = true;
               } else if (line.equals(OUT)) {
                   flag = true;
                   saveLog(list);
               } else if (isWin) {
                   String str = log.get((int) (Math.random() * log.size()));
                   list.add(str);
                   System.out.println(str);
               }
           }
       }
    }

    private List<String> readPhrases() {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(this.path))) {
            br.lines().forEach(list::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(
                new FileWriter(this.botAnswers, Charset.forName("UTF-8")))) {
            log.forEach(pw::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ConsoleChat chat = new ConsoleChat("./src/main/chat.txt", "answer.txt");
        chat.run();
    }
}
