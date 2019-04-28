package xyz.zhangyi.practicejava.design.bank;

import org.junit.Test;


import static org.assertj.core.api.Java6Assertions.assertThat;

public class TransferServiceTest {
    @Test
    public void should_transfer_money() {
        // given
        TransferService transferService = new TransferService();
        SourceAccount source = new SourceAccount();
        DestinationAccount destination = new DestinationAccount();
        Money amount = new Money(100_000L, Currency.RMB);

        //when
        TransferResult result = transferService.transfer(source, destination, amount);

        assertThat(result.isSuccessful()).isEqualTo(true);
    }
}
