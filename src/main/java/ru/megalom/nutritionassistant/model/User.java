package ru.megalom.nutritionassistant.model;




import ru.megalom.nutritionassistant.validator.PasswordEqualConstraint;
import ru.megalom.nutritionassistant.validator.UserExistsConstraint;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;


@Entity
@Table(name="users")
@PasswordEqualConstraint(message = "{Diff.userForm.passwordConfirm}")
@UserExistsConstraint(message = "{User.userForm.userExists}")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotEmpty(message = "{NotEmpty}")
    @Size(min=4,max=32,message = "{Size.userForm.username}")
    @Column(name="username")
    private String username;

    @NotEmpty(message = "{NotEmpty}")
    @Size(min=8,max=68,message = "{Size.userForm.password}")
    @Column(name="password")
    private String password;

    @Column(name="enabled")
    private boolean enabled;

    @Transient
    @NotEmpty(message = "{NotEmpty}")
    @Size(min=8,max=68,message = "{Size.userForm.password}")
    private String passwordConfirm;

    @Transient
    @NotEmpty(message = "{NotEmpty}")
    @Email(message = "{Email.userForm.email}")
    private String email;

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name="users_roles",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id")
    )
    private Set<Role> roles;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {

        String user= "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", passwordConfirm='" + passwordConfirm + '\'' +
                ", email='" + email + '\'' +
                //", roles=" + roles.toString() +
                '}';
        user+="roles: ";
        Iterator<Role> iterator=roles.iterator();
        while(iterator.hasNext()){
            user+=iterator.next().getName();
        }

        return user;
    }
}
