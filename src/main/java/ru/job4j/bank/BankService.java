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
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        var user = findByPassport(passport);
        return user.flatMap(value -> users.get(value)
                .stream()
                .filter(u -> u.getRequisite().equals(requisite))
                .findFirst());
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