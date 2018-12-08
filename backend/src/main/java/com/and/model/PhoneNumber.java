package com.and.model;

public class PhoneNumber {
  private String phoneNumber;
  private int customerId;

  public PhoneNumber(int customerId, String phoneNumber){
    this.customerId = customerId;
    this.phoneNumber = phoneNumber;
  }

  public int getCustomerId(){
    return this.customerId;
  }

  public String getPhoneNumber(){
    return this.phoneNumber;
  }
}
