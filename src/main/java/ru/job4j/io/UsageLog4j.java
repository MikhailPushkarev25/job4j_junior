package ru.job4j.io;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    
    private static final  Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {

       String name = "Mikhail Pushkarev";
       int age = 25;
       boolean flag = false;
       double weight = 69.9;
       float vision = 2.00001f;
       byte size = 39;
       char ch = 'K';
       long lg = 1000000000;
       LOG.debug(
               "User info name:  {}, age : {}, flag : {}, weight : {}, "
                       + " vision : {}, size : {}, ch : {}, lg : {} ",
               name, age, flag, weight, vision, size, ch, lg);
    }
}
