package com.gestionfinanciera.artigoajava.entities;

import com.gestionfinanciera.artigoajava.enums.ExpenseStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_expense")
public class Expense implements Serializable { //Gastos
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private Double valor;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT-3")
    private Instant data;

    private Integer status;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_expense_id")
    private Category categoryExpense;

    public Expense() {
    }

    public Expense(String titulo, Double valor, Instant data, ExpenseStatus status, User user, Category category) {
        super();
        this.titulo = titulo;
        this.valor = valor;
        this.data = data;
        setStatus(status);
        this.user = user;
        this.categoryExpense = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public ExpenseStatus getStatus() {
        return ExpenseStatus.valorDeCodigo(status);
    }

    public void setStatus(ExpenseStatus status) {
        if(status != null){
            this.status = status.getCodigo();
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User usuario) {
        this.user = usuario;
    }

    public Category getCategoryExpense() {
        return categoryExpense;
    }

    public void setCategoryExpense(Category categoryExpense) {
        this.categoryExpense = categoryExpense;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense re = (Expense) o;
        return id.equals(re.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
