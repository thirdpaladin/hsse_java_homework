import java.math.BigDecimal;

public enum BankType {
    NEO("НеоКредит Банк", new BigDecimal("0.01")),
    AUM("Арум Финтех", new BigDecimal("0.02")),
    VTA("Вектор Альянс Банк", new BigDecimal("0.00"));

    private String name;
    private BigDecimal comission;

    BankType(String name, BigDecimal comission) {
        this.name = name;
        this.comission = comission;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getComission() {
        return comission;
    }
}