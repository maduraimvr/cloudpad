/*
 * Copyright 2000-2016 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.portal.cloudpad.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Vaadin Ltd
 *
 */
@Entity
@Table(name="userdto")
public class User implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="user_name")
    @NotNull
    private String userName;
    
    @Column(name="role")
    @NotNull
    private String role;
    
    @Column(name="first_name")
    @NotNull
    private String firstName;
    
    @Column(name="last_name")
    private String lastName;
    
    @Column(name="password")
    @NotNull
    private String password;
    
    @Column(name="male")
    private boolean male;
    
    @Column(name="location")
    private String location;
    
    @Column(name="last_login_time")
    private Timestamp lastLoginTime;
    
    @Column(name="is_blocked")
    private boolean isBlocked;
    
    @Column(name="last_blocked_time")
    private Timestamp lastBlockedTime;
    
    @Column(name="attempts")
    private int attempts;

    /**
     * 
     */
    public User() {
	super();
    }

    /**
     * @param userName
     * @param role
     * @param firstName
     * @param lastName
     * @param password
     * @param male
     * @param location
     * @param lastLoginTime
     * @param attempts
     */
    public User(String userName, String role, String firstName, String lastName, String password, boolean male,
	    String location, Timestamp lastLoginTime, int attempts) {
	super();
	this.userName = userName;
	this.role = role;
	this.firstName = firstName;
	this.lastName = lastName;
	this.password = password;
	this.male = male;
	this.location = location;
	this.lastLoginTime = lastLoginTime;
	this.attempts = attempts;
    }

    /**
     * @return the attempts
     */
    public int getAttempts() {
        return attempts;
    }

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the male
     */
    public boolean isMale() {
        return male;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @return the lastLoginTime
     */
    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * @return the isBlocked
     */
    public boolean isBlocked() {
        return isBlocked;
    }

    /**
     * @return the lastBlockedTime
     */
    public Timestamp getLastBlockedTime() {
        return lastBlockedTime;
    }
    
    /**
     * @param attempts the attempts to set
     */
    public void setAttempts(int attempts) {
	this.attempts = attempts;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param male the male to set
     */
    public void setMale(boolean male) {
        this.male = male;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @param lastLoginTime the lastLoginTime to set
     */
    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * @param isBlocked the isBlocked to set
     */
    public void setBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    /**
     * @param lastBlockedTime the lastBlockedTime to set
     */
    public void setLastBlockedTime(Timestamp lastBlockedTime) {
        this.lastBlockedTime = lastBlockedTime;
    }    
}