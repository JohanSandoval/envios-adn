package com.ceiba.enumeraciones;

import java.math.BigDecimal;

public enum CostoPorPeso implements Costo{
    SIN_ASIGNAR_VALOR(0),
    MAYOR_O_MENOR_10(5000),
    MAYOR_IGUAL_10_MENOR_20(4750),
    MAYOR_IGUAL_20_MENOR_30(4500),
    MAYOR_IGUAL_30_MENOR_40(4250),
    MAYOR_IGUAL_40_MENOR_50(4000);

    private final double valorKl;

    CostoPorPeso(double valorKl) {
        this.valorKl = valorKl;
    }

    @Override
    public BigDecimal calcularCosto(double peso) {
        return new BigDecimal(peso * this.valorKl);
    }
}
