package ru.job4j.question;

import java.util.*;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
     int added;
     int changed;
     int deleted;
     Set<User> addSet = new HashSet<>(previous);
     addSet.addAll(current);
     Map<Integer, User> mapUser = new HashMap<>();
     for (User us : addSet) {
         mapUser.put(us.getId(), us);
     }
     changed = addSet.size() - mapUser.size();
     added = addSet.size() - previous.size() - changed;
     deleted = addSet.size() - current.size() - changed;

     return new Info(added, changed, deleted);
    }
}
