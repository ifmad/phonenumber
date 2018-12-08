package com.and.dao;

import java.util.List;

import com.and.model.PhoneNumber;

public interface IPhoneNumberDAO {
  public List<PhoneNumber> list();
  public boolean activate();
}
