package iki.qom.entity;

import iki.qom.enumerator.AccountStatus;
import iki.qom.enumerator.GenderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @Email
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private GenderStatus genderStatus;
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
    @ManyToOne
    private Role role;

    public User(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public GenderStatus getGenderStatus() {
        return genderStatus;
    }

    public void setGenderStatus(GenderStatus genderStatus) {
        this.genderStatus = genderStatus;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User(Long id, String username, String email, String password, GenderStatus genderStatus,
                AccountStatus accountStatus, Role role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.genderStatus = genderStatus;
        this.accountStatus = accountStatus;
        this.role = role;
    }

    @PrePersist
    void gender(){
        if(genderStatus==null){
            genderStatus=GenderStatus.MALE;
        }
        if(accountStatus==null){
            accountStatus=AccountStatus.IN_ACTIVE;
        }
    }


}
