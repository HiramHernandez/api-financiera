package com.gestionfinanciera.artigoajava.entities;

import com.gestionfinanciera.artigoajava.enums.IncomeStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_income")
public class Income implements Serializable { //ingresos
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
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_income_id")
    private Category categoryIncome;

    public Income() {
    }

    public Income(String title, Double value, Instant data, IncomeStatus status, User user, Category category) {
        super();
        this.titulo = titulo;
        this.valor = this.valor;
        this.data = data;
        setStatus(status);
        this.user = user;
        this.categoryIncome = category;
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

    public IncomeStatus getStatus() {
        return IncomeStatus.valorDeCodigo(status);
    }

    public void setStatus(IncomeStatus status) {
        if(status != null){
            this.status = status.getCodigo();
        }
    }

    public User getUsuario() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategoryIncome() {
        return categoryIncome;
    }

    public void setCategoryIncome(Category categoryIncome) {
        this.categoryIncome = categoryIncome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Income income = (Income) o;
        return id.equals(income.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
