package uz.pdp.dars2_vazifa2.service;

import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.dars2_vazifa2.entity.Basket;
import uz.pdp.dars2_vazifa2.entity.Currency;
import uz.pdp.dars2_vazifa2.entity.Pay;
import uz.pdp.dars2_vazifa2.entity.User;
import uz.pdp.dars2_vazifa2.payload.ApiResponse;
import uz.pdp.dars2_vazifa2.payload.PayDto;
import uz.pdp.dars2_vazifa2.repository.BasketRepository;
import uz.pdp.dars2_vazifa2.repository.CurrencyRepository;
import uz.pdp.dars2_vazifa2.repository.PayRepository;
import uz.pdp.dars2_vazifa2.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PayService {

    @Autowired
    PayRepository payRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    BasketRepository basketRepository;
    @Autowired
    UserRepository userRepository;

    public List<Pay> getPays(){
        List<Pay> payList = payRepository.findAll();
        return payList;
    }

    public Pay getPayById(Integer id){
        Optional<Pay> optionalPay = payRepository.findById(id);
        return optionalPay.get();
    }

    public ApiResponse addPay(PayDto payDto){
        Optional<Currency> optionalCurrency = currencyRepository.findById(payDto.getCurrencyId());
        if(!optionalCurrency.isPresent())
            return new ApiResponse("Currency not found", false);
        Optional<User> optionalUser = userRepository.findById(payDto.getUserId());
        if(!optionalUser.isPresent())
            return new ApiResponse("User not found", false);
        Optional<Basket> optionalBasket = basketRepository.findById(payDto.getBasketId());
        if(!optionalBasket.isPresent())
            return new ApiResponse("Basket not found", false);

        Pay pay = new Pay();
        pay.setSumma(payDto.getSumma());
        pay.setUser(optionalUser.get());
        pay.setCurrency(optionalCurrency.get());
        pay.setBasket(optionalBasket.get());
        payRepository.save(pay);
        return new ApiResponse("Update pay", true);
    }

    public ApiResponse updatePay(Integer id, PayDto payDto){
        Optional<Pay> optionalPay = payRepository.findById(id);
        if (!optionalPay.isPresent())
            return new ApiResponse("Pay not found", false);
        Optional<Currency> optionalCurrency = currencyRepository.findById(payDto.getCurrencyId());
        if(!optionalCurrency.isPresent())
            return new ApiResponse("Currency not found", false);
        Optional<User> optionalUser = userRepository.findById(payDto.getUserId());
        if(!optionalUser.isPresent())
            return new ApiResponse("User not found", false);
        Optional<Basket> optionalBasket = basketRepository.findById(payDto.getBasketId());
        if(!optionalBasket.isPresent())
            return new ApiResponse("Basket not found", false);

        Pay pay = optionalPay.get();
        pay.setSumma(payDto.getSumma());
        pay.setUser(optionalUser.get());
        pay.setCurrency(optionalCurrency.get());
        pay.setBasket(optionalBasket.get());
        payRepository.save(pay);
        return new ApiResponse("Update pay", true);
    }


    public ApiResponse deletePay(Integer id){
        try{
            payRepository.deleteById(id);
            return new ApiResponse("Deleted pay", true);
        }catch (Error e){
            return new ApiResponse("Error", false);
        }
    }
}
