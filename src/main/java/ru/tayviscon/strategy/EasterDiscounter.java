package ru.tayviscon.strategy;

import java.math.BigDecimal;

public class EasterDiscounter implements Discounter {
    @Override
    public BigDecimal applyDiscounter(BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(0.5));
    }
}
