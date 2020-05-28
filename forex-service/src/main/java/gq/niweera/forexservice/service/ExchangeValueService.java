package gq.niweera.forexservice.service;

import gq.niweera.forexservice.model.ExchangeValue;
import org.springframework.stereotype.Service;

@Service
public class ExchangeValueService {
    private final ExchangeValueRepository exchangeValueRepository;

    public ExchangeValueService(ExchangeValueRepository exchangeValueRepository){
        this.exchangeValueRepository = exchangeValueRepository;
    }

    public ExchangeValue getExchangeValue(String from, String to){
        return exchangeValueRepository.findByFromAndTo(from, to);
    }
}
