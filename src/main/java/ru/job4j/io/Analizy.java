package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Analizy {

    public void unavailable(String source, String target) {
        boolean flag = true;
      List<String> targets = new ArrayList<>();
      List<String> sources = new ArrayList<>();
      try (BufferedReader read = new BufferedReader(new FileReader(source))) {
          read.lines().forEach(sources::add);
          for (String str : sources) {
              if (str.startsWith("200") && !flag) {
                  String[] line = str.split(" ");
                  targets.add(line[1]);
                  flag = true;
              }

              if ((str.startsWith("400") || str.startsWith("500")) && flag) {
                  String[] line = str.split(" ");
                  targets.add(line[1]);
                  flag = false;
              }
          }
      } catch (Exception e) {
          e.printStackTrace();
      }
      int count = 0;
      try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
          for (String str : targets) {
              out.write(str);
              count++;
              if (count % 2 == 0) {
                  out.write(System.lineSeparator());
              } else {
                  out.write(" ");
              }
          }
      } catch (Exception e) {
          e.printStackTrace();
      }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
