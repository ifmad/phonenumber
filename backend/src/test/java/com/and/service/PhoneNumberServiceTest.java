package com.and.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;

public class PhoneNumberServiceTest {

  PhoneNumberService service;

  @BeforeEach
  public void init(){
    service = new PhoneNumberService();
  }

  @Test
  public void testListAllNotNull(){
    List<String> numbers = service.list();
    assertNotNull(numbers);
  }

  @Test
  public void testListForCustomerNotNull(){
    List<String> numbers = service.list(0);
    assertNotNull(numbers);
  }

  public void testActivateFalseOnNull(){
    Boolean result = service.activate(null);
    assertFalse(result);
  }
}
