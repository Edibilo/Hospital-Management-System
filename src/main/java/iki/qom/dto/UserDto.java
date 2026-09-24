package iki.qom.dto;

import iki.qom.enumerator.AccountStatus;
import iki.qom.enumerator.GenderStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserDto {
    private Long id;
    @NotBlank(message = "Username Can't be empty")
    private String username;
    @Email
    @NotBlank(message = "Email Can't be empty")
    private String email;
    @NotBlank(message = "Password Can't be empty")
    private String password;
    @NotBlank(message = "Gender Can't be empty")
    private GenderStatus genderStatus;
    @NotBlank(message = "Account status  Can't be empty")
    private AccountStatus accountStatus;
    private Long roleId;
    private String roleName;

    public UserDto(Long id, String username, String email, String password, GenderStatus genderStatus,
                   AccountStatus accountStatus, Long roleId, String roleName) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.genderStatus = genderStatus;
        this.accountStatus = accountStatus;
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public UserDto(){

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

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
