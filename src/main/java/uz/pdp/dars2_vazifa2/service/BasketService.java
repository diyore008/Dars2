package uz.pdp.dars2_vazifa2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import uz.pdp.dars2_vazifa2.entity.Basket;
import uz.pdp.dars2_vazifa2.entity.Product;
import uz.pdp.dars2_vazifa2.entity.User;
import uz.pdp.dars2_vazifa2.payload.ApiResponse;
import uz.pdp.dars2_vazifa2.payload.BasketDto;
import uz.pdp.dars2_vazifa2.repository.BasketRepository;
import uz.pdp.dars2_vazifa2.repository.ProductRepository;
import uz.pdp.dars2_vazifa2.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BasketService {

    @Autowired
    BasketRepository basketRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;


    public List<Basket> getBaskets(){
        List<Basket> basketList = basketRepository.findAll();
        return basketList;
    }

    public Basket getBasketById(Integer id){
        Optional<Basket> optionalBasket = basketRepository.findById(id);
        return optionalBasket.get();
    }


    public ApiResponse addBasket(BasketDto basketDto){
        Optional<User> optionalUser = userRepository.findById(basketDto.getUserId());
        if (!optionalUser.isPresent())
            return new ApiResponse("User not found", false);
        Optional<Product> optionalProduct = productRepository.findById(basketDto.getProductId());
        if (!optionalProduct.isPresent())
            return new ApiResponse("Product not found", false);

        Basket basket = new Basket();
        basket.setName(basketDto.getName());
        basket.setUser(optionalUser.get());
        basket.setProduct(optionalProduct.get());
        basketRepository.save(basket);
        return new ApiResponse("Saved basket", true);
    }


    public ApiResponse updateBasket(Integer id, BasketDto basketDto){
        Optional<Basket> optionalBasket = basketRepository.findById(id);
        if (!optionalBasket.isPresent())
            return new ApiResponse("Basket not found", false);
        Optional<User> optionalUser = userRepository.findById(basketDto.getUserId());
        if (!optionalUser.isPresent())
            return new ApiResponse("User not found", false);
        Optional<Product> optionalProduct = productRepository.findById(basketDto.getProductId());
        if (!optionalProduct.isPresent())
            return new ApiResponse("Product not found", false);

        Basket basket = optionalBasket.get();
        basket.setName(basketDto.getName());
        basket.setUser(optionalUser.get());
        basket.setProduct(optionalProduct.get());
        basketRepository.save(basket);
        return new ApiResponse("Update basket", true);
    }

    public ApiResponse deleteBasket(Integer id){
        try{
            basketRepository.deleteById(id);
            return new ApiResponse("Deleted basket", true);
        }catch (Error e){
            return new ApiResponse("Error", false);
        }
    }
}
