package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<Optional<User>, List<Optional<Account>>> users = new HashMap<>();

    public void addUser(Optional<User> user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Optional<Account> account) {
            var user = findByPassport(passport);
            if(user.isPresent() && !users.get(user).contains(account)){
                users.get(user).add(account);
            }
    }

    public Optional<User> findByPassport(String passport) {
        Optional<User> rsl = Optional.empty();
        for (Optional<User> user : users.keySet()) {
            if (user.isPresent() && user.get().getPassport().equals(passport)) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
       var user = findByPassport(passport);
       Optional<Account> rsl = Optional.empty();
        if(user.isPresent()) {
            for (Optional<Account> list : users.get(user)) {
                if (list.isPresent() && list.get().getRequisite().equals(requisite)) {
                    rsl = list;
                    break;
                }
            }
        }
       return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        var srcAccount = findByRequisite(srcPassport, srcRequisite);
        var destAccount = findByRequisite(destPassport, destRequisite);
        if(srcAccount.isEmpty() || destAccount.isEmpty() || srcAccount.get().getBalance() < amount){
            return false;
        }
        srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
        destAccount.get().setBalance(destAccount.get().getBalance() + amount);
        return true;
    }
}