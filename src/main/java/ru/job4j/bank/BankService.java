package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу банковского сервиса который может
 * Добавлять пользователя в коллекцию
 * Давлять пользователю банковские аккаунты
 * Находить пользователя по его уникальному индификатору
 * Находить пользователя по реквизиту его банковского аккаунта
 * Переводить деньги между считами и пользователями
 * @author KIRILL BOBLAK
 * @version 1.0
 */

public class BankService {
    /**
     * Хранение задания осуществляется в коллекции типа HashMap
     */
    private Map<User, List<Account>>users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в HashMap
     * @param user пользователь который добавляется в HashMap
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет к пользователю новый банковский аккаунт
     * Метод принимает на вход уникальный индификатор пользователя (пасспорт)
     * и аккаунт который надо добавить к пользователю
     * @param passport уникальый индификатор пользователя
     * @param account банковский аккаунт который надо добавить пользователю
     */
    public void addAccount(String passport, Account account) {
            var user = findByPassport(passport);
            if(user.isPresent() && !users.get(user.get()).contains(account)){
                users.get(user.get()).add(account);
            }
    }

    /**
     * Метод принимате на вход паспорт пользователя и находит его
     * @param passport уникальный индификатор пользователя
     * @return User
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод находит аккаунт принадлежащий соотвествующему пользователю
     * Принимает на вход паспорт пользователя и реквизиты его банковского аккаунта
     * @param passport уникальный индификатор пользователя
     * @param requisite уникальный индификатор аккаунта
     * @return Account
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        var user = findByPassport(passport);
        return user.flatMap(value -> users.get(value)
                .stream()
                .filter(u -> u.getRequisite().equals(requisite))
                .findFirst());
    }

    /**
     * Метод переводит деньги со счета одного пользователя на счет другого
     * Принимает на вход иднификаторы двух пользователей и индификаторы двух аккаунтов
     * @param srcPassport индификатор пользователя со счета которого надо перевести деньги
     * @param srcRequisite реквизиты счета с которого необходимо списать деньги
     * @param destPassport индификтор пользователя на счет которого будет перевод
     * @param destRequisite реквизиты счета на который начислятся деньги
     * @param amount сумма перевода
     * @return результат перевод: успешный или нет
     */
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