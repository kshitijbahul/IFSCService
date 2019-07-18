package com.kshitij.interview.fyle.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "branch")
public class Branch {

    @Id
    @NotNull
    private String ifsc;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="bank_id")
    private Bank bank;
    private String branch;
    private String address;
    private String city;
    private String district;
    private String state;
    public Branch(){

    }

    public Branch(String ifsc, String branch) {

        this.ifsc = ifsc;
        this.branch = branch;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
