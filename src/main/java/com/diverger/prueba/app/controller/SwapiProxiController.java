package com.diverger.prueba.app.controller;

import com.diverger.prueba.app.model.PersonInfo;
import com.diverger.prueba.app.service.SwapiProxyService;
import io.lettuce.core.dynamic.annotation.Param;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/swapi-proxy")
@AllArgsConstructor
public class SwapiProxiController {

    private final SwapiProxyService swapiProxyService;

    @GetMapping("/person-info")
    @ResponseBody()
    public PersonInfo getPersonInfo(@Param("name") String name) {
        return swapiProxyService.getPersonInfo(name);
    }

}
