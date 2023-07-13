/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package context;

/**
 *
 * @author Admin
 */
public class UserError {
    private String nameError;
    private String roleError;
    private String dateError;
    private String phoneError;
    private String passwordError;
    private String cfpasswordError;
    
    public UserError() {
        this.nameError = "";
        this.roleError = "";
        this.dateError = "";
        this.phoneError = "";
        this.passwordError = "";
        this.cfpasswordError = "";
    }

    public UserError(String nameError, String roleError, String dateError, String phoneError, String passwordError, String cfpasswordError) {
        this.nameError = nameError;
        this.roleError = roleError;
        this.dateError = dateError;
        this.phoneError = phoneError;
        this.passwordError = passwordError;
        this.cfpasswordError = cfpasswordError;
    }

    public String getPhoneError() {
        return phoneError;
    }

    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }

    
    
    public String getNameError() {
        return nameError;
    }

    public void setNameError(String nameError) {
        this.nameError = nameError;
    }

    public String getRoleError() {
        return roleError;
    }

    public void setRoleError(String roleError) {
        this.roleError = roleError;
    }

    public String getDateError() {
        return dateError;
    }

    public void setDateError(String dateError) {
        this.dateError = dateError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getCfpasswordError() {
        return cfpasswordError;
    }

    public void setCfpasswordError(String cfpasswordError) {
        this.cfpasswordError = cfpasswordError;
    }
    
    
}
