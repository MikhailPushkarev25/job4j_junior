package ru.job4j.array;

public class IndexOfWithCount {

    public static int indexOf(char[] string, char c, int number) {
        String str = new String(string);
        for (int i = 0; i < string.length; i++) {
            if (str.charAt(i) == c && number == 1) {
               int one = str.indexOf(c);
               return one;
            } else if (str.charAt(i) == c && number != 1) {
               int two = str.indexOf(c, str.indexOf(c) + 1);
               return two;
            }
        }
        return -1;
    }
}
