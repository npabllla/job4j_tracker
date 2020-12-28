package ru.job4j.bank;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    @Test
    public void addUser() {
        var user = Optional.of(new User("3434", "Petr Arsentev"));
        var bank = new BankService();
        bank.addUser(user);
        assertThat(bank.findByPassport("3434"), is(user));
    }

    @Test
    public void whenEnterInvalidPassport() {
        var user =  Optional.of(new User("3434", "Petr Arsentev"));
        var bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.get().getPassport(),Optional.of( new Account("5546", 150D)));
        assertThat(bank.findByRequisite("34", "5546"), is(Optional.empty()));
    }

    @Test
    public void addAccount() {
        var user =  Optional.of(new User("3434", "Petr Arsentev"));
        var bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.get().getPassport(),Optional.of( new Account("5546", 150D)));
        assertThat(bank.findByRequisite("3434", "5546").get().getBalance(), is(150D));
    }

    @Test
    public void transferMoney() {
        var user =  Optional.of(new User("3434", "Petr Arsentev"));
        var bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.get().getPassport(),Optional.of( new Account("5546", 150D)));
        bank.addAccount(user.get().getPassport(),Optional.of( new Account("113", 50D)));
        bank.transferMoney(user.get().getPassport(), "5546", user.get().getPassport(), "113", 150D);
        assertThat(bank.findByRequisite(user.get().getPassport(), "113").get().getBalance(), is(200D));
    }

    @Test
    public void add2Accounts() {
        var user =  Optional.of(new User("3434", "Petr Arsentev"));
        var bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.get().getPassport(),Optional.of( new Account("1111", 150D)));
        bank.addAccount(user.get().getPassport(),Optional.of( new Account("1122", 300D)));
        assertThat(bank.findByRequisite("3434", "1122").get().getBalance(), is(300D));
    }
}