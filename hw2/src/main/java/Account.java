import java.math.BigDecimal;

public class Account {
    public int cardId;
    public int pin;
    public BigDecimal balance;
    public BankType bankType;

    public Account(int cardId, int pin, BigDecimal balance, BankType bankType) {
        if((cardId<10000) || (pin<100) || (pin>999) || (balance.scale()>2)){
            System.out.println("Неверные данные для аккаунта");
            cardId = 12345;
            pin = 999;
            balance = new BigDecimal("0.00");
            bankType = BankType.NEO;
        }
        this.cardId = cardId;
        this.pin = pin;
        this.balance = (balance==null)? new BigDecimal("0") : balance;
        this.bankType = (bankType!=null)? bankType : BankType.NEO;
    }

    public int getCardId() {
        return cardId;
    }

    public int getPin() {
        return pin;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BankType getBankType() {
        return bankType;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getBankType());
        stringBuilder.append("Карта: ").append(cardId);
        stringBuilder.append(", Баланс: ").append(balance).append(" руб");
        return stringBuilder.toString();
    }
}