package com.example.spring.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
@Service //husk service annotering
public class IsItFriday {
  //ikke @GetMapping på denne da det er kontrolleren her der tager input fra url ind og sender det hertil
  public String isItFriday(){
    if (LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.FRIDAY)){
      return "ja det er fredag";
    } else return "nej det er ikke fredag";
  }
}
