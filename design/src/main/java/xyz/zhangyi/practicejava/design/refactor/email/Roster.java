package xyz.zhangyi.practicejava.design.refactor.email;

import javax.mail.Address;

public interface Roster {
    boolean containsOneOf(Address[] from);

    Address[] getAddresses();
}
