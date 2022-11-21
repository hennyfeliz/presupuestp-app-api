package com.example.demo.Entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Presupuesto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long idPresupuesto;

    private float valor;

    @OneToMany
    @Column(name = "ingresos")
    private List<Ingresos> ingresos;

    @OneToMany
    @Column(name = "egresos")
    private List<Egresos> egresos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Presupuesto that = (Presupuesto) o;
        return idPresupuesto != null && Objects.equals(idPresupuesto, that.idPresupuesto);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
