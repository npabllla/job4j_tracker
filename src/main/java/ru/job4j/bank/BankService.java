package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
            User user = findByPassport(passport);
            if(user != null && !users.get(user).contains(account)){
                users.get(user).add(account);
            }
    }

    public User findByPassport(String passport) {
        for (User  user : users.keySet()){
            if(user.getPassport().equals(passport)){
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
       User user = findByPassport(passport);
       if(user != null) {
           for (Account list : users.get(user)) {
               if (list.getRequisite().equals(requisite)) {
                   return list;
               }
           }
       }
       return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if(srcAccount == null || destAccount == null || srcAccount.getBalance() < amount){
            return false;
        }
        srcAccount.setBalance(srcAccount.getBalance() - amount);
        destAccount.setBalance(destAccount.getBalance() + amount);
        return true;
    }
}