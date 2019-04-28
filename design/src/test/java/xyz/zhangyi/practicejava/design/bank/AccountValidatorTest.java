package xyz.zhangyi.practicejava.design.bank;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import xyz.zhangyi.practicejava.design.bank.repository.AccountRepository;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AccountValidatorTest {

    private final String validNumber = "987211111";
    private final String invalidNumber = "9872111XXX";
    private final String notExistedNumber = "9872111XXX";
    private AccountRepository mockRepo;

    @Before
    public void setUp() throws Exception {
        mockRepo = mock(AccountRepository.class);
    }

    @Test
    public void should_return_true_given_valid_account_number() {
        // given
        Account account = new Account(validNumber);
        when(mockRepo.isExisted(validNumber)).thenReturn(true);
        AccountValidator validator = new AccountValidator(mockRepo);

        boolean result = validator.validate(account);

        assertThat(result).isEqualTo(true);
    }

    @Test
    @Ignore
    public void should_return_false_given_invalid_account_number() {
        // given
        Account account = new Account(invalidNumber);
        when(mockRepo.isExisted(invalidNumber)).thenReturn(false);
        AccountValidator validator = new AccountValidator(mockRepo);

        boolean result = validator.validate(account);

        assertThat(result).isEqualTo(false);
    }

    @Test
    public void should_return_false_given_not_existed_account_number() {
        // given
        Account account = new Account(notExistedNumber);

        when(mockRepo.isExisted(notExistedNumber)).thenReturn(false);

        AccountValidator validator = new AccountValidator(mockRepo);

        // when
        boolean result = validator.validate(account);

        // then
        verify(mockRepo).isExisted(notExistedNumber);
        assertThat(result).isEqualTo(false);

    }
}
