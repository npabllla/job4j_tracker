package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>>users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
            var user = findByPassport(passport);
            if(user.isPresent() && !users.get(user.get()).contains(account)){
                users.get(user.get()).add(account);
            }
    }

    public Optional<User> findByPassport(String passport) {
        Optional<User> rsl = Optional.empty();
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = Optional.of(user);
                break;
            }
        }
        return rsl;
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
       var user = findByPassport(passport);
       Optional<Account> rsl = Optional.empty();
        if(user.isPresent()) {
            for (Account list : users.get(user.get())) {
                if (list.getRequisite().equals(requisite)) {
                    rsl = Optional.of(list);
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