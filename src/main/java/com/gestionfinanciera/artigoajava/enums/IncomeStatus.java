package com.gestionfinanciera.artigoajava.enums;

public enum IncomeStatus {//ingreso
    RECIBIDA(1),
    PENDIENTE(2),
    AGENDADO(3),
    ATRASADO(4);
    private int codigo;

    IncomeStatus(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static IncomeStatus valorDeCodigo(int codigo){
        for (IncomeStatus valor : IncomeStatus.values()){
            if (valor.getCodigo() == codigo){
                return valor;
            }
        }
        throw new IllegalArgumentException("Código inválido para o status de uma Receita");
    }

}
