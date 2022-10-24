package com.example.spring;

import com.example.spring.services.IsItFriday;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//typiske packages under com.example.spring:
//controllers - gør at klassen kan modtage requests og returnere respons til clienten
//models - klasser som er domain objects, fx Movie-klasse eller Book-klasse. normal klasse
//repositories - klasser som interagere med data, fx fra filer eller databaser eller API's
//services - processes data, laver datalogik. fx find længste film - kalder repository som fetcher
//og returnerer liste af alle film. serviceklassen finder så den længste film og returnerer den  til controller
//klasse: KlassenavnTemplateApplication

@RestController
//kan også være @Controller
public class HomeController {

  IsItFriday isItFriday; //laver attributter og konstruktør som normalt
  //service-klassen IsItFriday instantieres i konstruktør
  //hvor kaldes konstruktøren? Hvor kommer isItFriday ind som argument?
  public HomeController(IsItFriday isItFriday){
    this.isItFriday = isItFriday;
  }

  @GetMapping("/")// skråstreg er default, localhost:8080/
  public String index() {
    return "Hello World";
  }

  //The @GetMapping annotated methods in the @Controller annotated
  // classes handle the HTTP GET requests matched with given URI expression.
  //@GetMapping("message") //tager besked ind fra URL'en, localhost:8080/message
  //public String message() {
    //return "Hello"; //sender hello til browseren hvis "message" tages ind og kalder denne funktion
    //det sker i stedet for "hello world" da message blev givet frem for "/" ingenting
  //}
  //"message" er et endpoint her
  @GetMapping("message") //tager besked ind fra URL'en, localhost:8080/message
  public String message(@RequestParam String name) { //kan tage parametre som normale funktioner
    //@RequestParam fortæller browseren at den skal lede efter en parameter kaldet name
    //og give paramtren det navn den sættes til i urlen
    return "Hello" + name;
    //URL: http://localhost:8080/message?name=Claus
  }
  @GetMapping("friendlymessage")
  public String friendlyMessage(){
    return "<h1>Du er sød</h1>";
  }
  @GetMapping("echo")
  public String echoUserInput(@RequestParam String input){
    return input;
    //http://localhost:8080/echo?input=hvadendmanvilskrive
  }

  @GetMapping("erdetfredag")
  public String isItFriday(){
    return isItFriday.isItFriday();
  }

  //til eksamen: fejl i spring er godt hvis man kan forklare det. Bare kig ned på error'en i konsolen
  //og forklar hvad der sker. De kan godt lide når der kommer fejl og man kan forklare det
  //giver mange point

  //404 fejl - siden eksisterer ikke
  //400 brugeren har lavet en fejl, fx mangler parameter efter endpoint
}
