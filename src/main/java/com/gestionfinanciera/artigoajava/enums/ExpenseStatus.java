package com.gestionfinanciera.artigoajava.enums;

public enum ExpenseStatus { //Gasto
    PAGADO(1),
    PENDIENTE(2),
    AGENDADA(3),
    ATRASADA(4);
    private int codigo;

    ExpenseStatus(int codigo){
        this.codigo = codigo;
    }
    public int getCodigo() {
        return codigo;
    }

    public static ExpenseStatus valorDeCodigo(int codigo){
        for (ExpenseStatus valor : ExpenseStatus.values()){
            if (valor.getCodigo() == codigo){
                return valor;
            }
        }
        throw new IllegalArgumentException("Código inválido para o status de uma Despesa");
    }
}
