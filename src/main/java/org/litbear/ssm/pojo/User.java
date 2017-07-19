package org.litbear.ssm.pojo;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * Created by litbear on 2017/7/10.
 */
public class User {

    private Long id;
    @NotNull(message = "用户名必须填写")
    @Size(min = 3, max = 16, message = "用户名必须在3到16字以内")
    private String username;
    @NotNull(message = "性别必须填写")
    private Gender gender;
    @Past(message = "出生日期必须早于今天")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;
    @Email(message = "电子邮箱地址不正确")
    private String email;
    @Size(max = 100, min = 5, message = "地址必须在5到100字以内")
    private String address;

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", gender=" + gender +
                ", birthdate=" + birthdate +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
