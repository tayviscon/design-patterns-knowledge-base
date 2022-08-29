package ru.tayviscon.strategy;

import java.math.BigDecimal;

public interface Discounter {
    BigDecimal applyDiscounter(BigDecimal amount);
}
