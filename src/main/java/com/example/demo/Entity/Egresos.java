package com.example.demo.Entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Egresos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long idEgreso;

    private String descripcion;

    private float valor;

    @ManyToOne
    @JoinColumn(name = "presupuesto")
    private Presupuesto presupuesto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Egresos egresos = (Egresos) o;
        return idEgreso != null && Objects.equals(idEgreso, egresos.idEgreso);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
