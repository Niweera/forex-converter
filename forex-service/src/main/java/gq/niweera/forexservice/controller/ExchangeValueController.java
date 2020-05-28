package gq.niweera.forexservice.controller;


import gq.niweera.forexservice.model.ExchangeValue;
import gq.niweera.forexservice.service.ExchangeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class ExchangeValueController {


    private final ExchangeValueService exchangeValueService;
    private final Environment environment;

    @Autowired
    public ExchangeValueController(ExchangeValueService exchangeValueService, Environment environment) {
        this.exchangeValueService = exchangeValueService;
        this.environment = environment;
    }

    @RequestMapping(method = RequestMethod.GET ,value="/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue getExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to){
        ExchangeValue value = exchangeValueService.getExchangeValue(from,to);
        value.setPort(Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port"))));
        return value;
    }

}
