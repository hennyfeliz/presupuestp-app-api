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
public class Ingresos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String descripcion;

    private float valor;

    @ManyToOne
    @JoinColumn(name = "presupuesto")
    private Presupuesto presupuesto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Ingresos ingresos = (Ingresos) o;
        return id != null && Objects.equals(id, ingresos.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
