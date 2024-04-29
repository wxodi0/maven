package sh.love.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class SessionController {
  @GetMapping("/setSession/{value}")
  @ResponseBody
  public String setSession(
    @RequestBody String value,
    HttpServletResponse res,
    HttpServletRequest req
  ) {
    req.setAttribute("value", value);
    return "ok";
  }

  @GetMapping("/getSession")
  @ResponseBody
  public String getSession(
    HttpServletResponse res,
    HttpServletRequest req
  ) {
    System.out.println(req.getAttribute("value"));
    return "ok";
  }
}
