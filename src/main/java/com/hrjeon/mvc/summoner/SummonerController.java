package com.hrjeon.mvc.summoner;

import com.hrjeon.lol.LolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * Created by dennis on 14. 2. 4.
 */
@Controller
@RequestMapping("/summoner")
public class SummonerController {
  @Autowired
  private SummonerService summonerService;

  @RequestMapping(value = "/{name}", method = RequestMethod.GET)
  public ModelAndView get(@PathVariable String name) throws IOException, LolException {
    return new ModelAndView("/summoner/index")
        .addObject("summoner", summonerService.findByName(name));
  }
}
