package xyz.zhangyi.practicejava.design.bank;

import xyz.zhangyi.practicejava.design.bank.repository.AccountRepository;

public class AccountValidator {
    private AccountRepository accountRepository;

    public AccountValidator(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean validate(Account account) {
        if (isValid(account)) {
            return accountRepository.isExisted(account.getNumber());
        }
        return true;
    }

    private boolean isValid(Account account) {
        return true;
    }
}
