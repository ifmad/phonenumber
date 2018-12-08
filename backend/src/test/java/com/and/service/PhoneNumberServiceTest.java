package com.and.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

import com.and.model.PhoneNumber;
import com.and.dao.IPhoneNumberDAO;

public class PhoneNumberServiceTest {

  @Test
  public void testListAllNotNull(){
    IPhoneNumberDAO dao = new IPhoneNumberDAO(){
      public List<PhoneNumber> list() {
        return new LinkedList<PhoneNumber>();
      }
      public boolean activate(){
        return true;
      }
    };
    PhoneNumberService service = new PhoneNumberService(dao);
    List<String> numbers = service.list();
    assertNotNull(numbers);
  }

  @Test
  public void testListForCustomerNotNull(){
    IPhoneNumberDAO dao = new IPhoneNumberDAO(){
      public List<PhoneNumber> list() {
        return new LinkedList<PhoneNumber>();
      }
      public boolean activate(){
        return true;
      }
    };
    PhoneNumberService service = new PhoneNumberService(dao);
    List<String> numbers = service.list(0);
    assertNotNull(numbers);
  }

  @Test
  public void testListForCustomerMatching(){
    IPhoneNumberDAO dao = new IPhoneNumberDAO(){
      public List<PhoneNumber> list() {
        return Arrays.asList(
          new PhoneNumber(1, "1"),
          new PhoneNumber(2, "2")
        );
      }
      public boolean activate(){
        return true;
      }
    };
    PhoneNumberService service = new PhoneNumberService(dao);
    List<String> numbers = service.list(1);
    assertEquals(numbers.size(), 1);
    assertEquals(numbers.get(0), "1");
  }

  public void testActivateFalseOnNull(){
    IPhoneNumberDAO dao = new IPhoneNumberDAO(){
      public List<PhoneNumber> list() {
        return new LinkedList<PhoneNumber>();
      }
      public boolean activate(){
        return true;
      }
    };
    PhoneNumberService service = new PhoneNumberService(dao);
    Boolean result = service.activate(null);
    assertFalse(result);
  }
  public void testActivateTrueNonNull(){
    IPhoneNumberDAO dao = new IPhoneNumberDAO(){
      public List<PhoneNumber> list() {
        return new LinkedList<PhoneNumber>();
      }
      public boolean activate(){
        return true;
      }
    };
    PhoneNumberService service = new PhoneNumberService(dao);
    Boolean result = service.activate("+441234567890");
    assertTrue(result);
  }
}
