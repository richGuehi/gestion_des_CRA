package entity;
import Utils.enums.CraStatusEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cras" )
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cra {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User collaborateur;

    @Column(nullable = false)
    private int mois;

    @Column(nullable = false)
    private int annee;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CraStatusEnum status;

    @Column(columnDefinition = "TEXT")
    private String motifRejet;

}
