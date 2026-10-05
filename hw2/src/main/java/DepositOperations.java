import java.math.BigDecimal;

public interface DepositOperations {
    public BigDecimal deposit(Account account, BigDecimal depositSum);
}