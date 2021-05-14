package net.lemniscate.snippy.user.model;

import net.lemniscate.snippy.common.model.EntityAuditInfo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class UserMaster extends EntityAuditInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;

    @Column(name = "user_name", nullable = false, length = 30, unique = true)
    private String userName;

    @Column(name = "password", length = 50)
    private String password;

    @Column(name = "email_id", length = 150)
    private String emailId;

    @Column(name = "contact_number", nullable = false, length = 15)
    private String contactNumber;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", insertable = false, updatable = false)
    private RoleMaster role;
    
    @Column(name = "role_id")
    private Integer roleId;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private State state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public enum State {
        ACTIVE,
        INACTIVE,
        ARCHIVED,
        UNVERIFIED,
        DISAPPROVED
    }

    public static class Fields {

        public static final String ID = "id";
        public static final String USER_NAME = "userName";
        public static final String PASSWORD = "password";
        public static final String EMAIL_ID = "emailId";
        public static final String CONTACT_NUMBER = "contactNumber";
        public static final String FIRST_NAME = "firstName";
        public static final String LAST_NAME = "lastName";
        public static final String STATE = "state";
    }

    public RoleMaster getRole() {
        return role;
    }

    public void setRole(RoleMaster role) {
        this.role = role;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
