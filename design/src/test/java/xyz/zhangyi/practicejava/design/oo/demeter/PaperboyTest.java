package xyz.zhangyi.practicejava.design.oo.demeter;

import org.junit.*;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

public class PaperboyTest {

    private Customer customer;
    private Paperboy paperboy;

    @Before
    public void setUp() throws Exception {
        paperboy = new Paperboy();
    }

    @Test
    public void should_subtract_money_if_enough_balance() {
        // given
        createCustomer();

        // when
        paperboy.charge(customer, 900f);

        // then
        float actualMoney = customer.getWallet().getTotalMoney();
        float expectedMoney = 100f;

        assertThat(actualMoney).isEqualTo(expectedMoney);
    }

    @Test
    public void should_thrown_exception_if_not_enough_balance() {
        // given
        createCustomer();

        // when
        assertThatThrownBy(() -> paperboy.charge(customer, 1001f))
                .hasMessage("Money is not enough")
                .hasCauseExactlyInstanceOf(Exception.class);
    }

    private void createCustomer() {
        Wallet wallet = new Wallet();
        wallet.setTotalMoney(1000f);
        customer = new Customer(wallet);
    }
}