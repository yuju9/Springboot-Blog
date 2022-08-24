package blog.example.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000, unique = true)
    private String username;

    @Column(nullable = false, length = 1000)
    private String password;

    @Column(nullable = false, length = 500)
    private String email;

    //@ColumnDefault("user")
    @Enumerated(EnumType.STRING)
    private RoleType role; //Admin(관리자)와 user, manager 등을 구분 //enum 사용 권장(Role Type)

    private String oauth;

    @CreationTimestamp
    private Timestamp createDate;
}
