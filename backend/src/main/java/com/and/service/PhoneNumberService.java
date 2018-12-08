package com.and.service;

import java.util.List;
import java.util.stream.Collectors;

import com.and.dao.IPhoneNumberDAO;
import com.and.model.PhoneNumber;

public class PhoneNumberService {
  private IPhoneNumberDAO dao;

  public PhoneNumberService(IPhoneNumberDAO dao){
    this.dao = dao;
  }

  /**
   * return all phone numbers
   */
  public List<String> list(){
    return dao.list().stream()
      .map(PhoneNumber::getPhoneNumber)
      .collect(Collectors.toList());
  }

  /**
   * return all phone numbers for a customer
   */
  public List<String> list(int customerId){
    return dao.list().stream()
      .filter(number -> number.getCustomerId() == customerId)
      .map(PhoneNumber::getPhoneNumber)
      .collect(Collectors.toList());
  }

  /**
   * activates a given phone number
   * return if the action is successful
   */
  public Boolean activate(String phoneNumber){
    if(phoneNumber == null) return false;
    return dao.activate();
  }
}
