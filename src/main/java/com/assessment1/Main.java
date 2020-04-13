package com.assessment1;

import java.util.HashSet;
import java.util.Set;
import com.assessment1.model.User;
import com.assessment1.repo.UserRepository;

public class Main {

  public static void main(String[] args) {

    UserRepository ur = new UserRepository();
    // Set<User> set = new HashSet<User>();
    // set = ur.findAll();

    User u = new User();

    u = ur.findById(1);

    // u = ur.findUserByUsername("Blake");
    // u = ur.findUserByCredentials("Blake", "Kruppa");
    // u.setFirstName("Brian");
    // u.setLastName("Vogelsang");
    // u.setPassword("12345678");
    // u.setRole("4");
    // u.setUsername("bvogelsang");
    // ur.save(u);
    // ur.deleteById(7);
    System.out.println(u);
  }

  public static int iterateOver(int[] arr) {
    int total = 0;
    for (int i : arr) {
      total += i;
    }
    return total;
  }

}
