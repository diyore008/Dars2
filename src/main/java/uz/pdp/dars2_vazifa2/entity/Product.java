package uz.pdp.dars2_vazifa2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;

    private double price;
    @ManyToOne
    private Info info;
    @OneToOne
    private Attachment attachment;
    @ManyToOne
    private Category category;
}
