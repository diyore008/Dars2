package uz.pdp.dars2_vazifa2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private double summa;
    @ManyToOne
    private User user;
    @ManyToOne
    private Currency currency;
    @ManyToOne
    private Basket basket;
}
