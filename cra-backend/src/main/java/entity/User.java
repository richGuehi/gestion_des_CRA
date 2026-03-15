package entity;
import Utils.enums.ContratEnum;
import Utils.enums.RoleEnum;
import Utils.enums.SerioriteEnum;
import Utils.enums.UserStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @Enumerated(EnumType.STRING)
    private UserStatusEnum status;

    @Enumerated(EnumType.STRING)
    private ContratEnum  contrat;

    @Enumerated(EnumType.STRING)
    private SerioriteEnum seriorite;

    private BigDecimal salaire;
    @Column(nullable = false)
    private boolean active = false;

}
