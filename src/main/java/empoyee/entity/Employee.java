package empoyee.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "First name is required")
    @Size(max = 25, message = "First name must be less than or equal to 25 characters")
    @Column(name = "first_name", nullable = false, length = 25)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 25, message = "Last name must be less than or equal to 25 characters")
    @Column(name = "last_name", nullable = false, length = 25)
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Column(name = "email", nullable = false, unique = true)
    private String email;
}
