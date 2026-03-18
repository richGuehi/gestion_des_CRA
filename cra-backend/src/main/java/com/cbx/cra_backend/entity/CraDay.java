package com.cbx.cra_backend.entity;

import com.cbx.cra_backend.Utils.enums.ActivityType;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name= "cra_days")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CraDay {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cra_id", nullable = false)
    private Cra cra;

    @Column(nullable = false)
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ActivityType typeActivite;

}
