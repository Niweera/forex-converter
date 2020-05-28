package gq.niweera.currencyconversion.controller;

import gq.niweera.currencyconversion.model.CurrencyConversionBean;
import gq.niweera.currencyconversion.proxy.ForexServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {

    private final ForexServiceProxy forexServiceProxy;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public CurrencyConversionController(ForexServiceProxy forexServiceProxy) {
        this.forexServiceProxy = forexServiceProxy;
    }

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
                                                  @PathVariable double quantity) {

        CurrencyConversionBean response = forexServiceProxy.retrieveExchangeValue(from, to);

        assert response != null;
        return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
                quantity * (response.getConversionMultiple()), response.getPort());
    }
}
