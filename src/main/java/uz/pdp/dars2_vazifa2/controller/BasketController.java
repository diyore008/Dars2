package uz.pdp.dars2_vazifa2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.dars2_vazifa2.entity.Basket;
import uz.pdp.dars2_vazifa2.payload.ApiResponse;
import uz.pdp.dars2_vazifa2.payload.BasketDto;
import uz.pdp.dars2_vazifa2.service.BasketService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BasketController {

    @Autowired
    BasketService basketService;

    @GetMapping("/getBaskets")
    public ResponseEntity<List<Basket>> getBaskets(){
        List<Basket> basketList = basketService.getBaskets();
        return ResponseEntity.ok(basketList);
    }

    @GetMapping("/getBasketById/{id}")
    public ResponseEntity<Basket> getBasketById(@PathVariable Integer id){
        Basket basketById = basketService.getBasketById(id);
        return ResponseEntity.ok(basketById);
    }

    @PostMapping("/addBasket")
    public ResponseEntity<ApiResponse> addBasket(@RequestBody BasketDto basketDto){
        ApiResponse apiResponse = basketService.addBasket(basketDto);
        return ResponseEntity.status(apiResponse.isSuccess()? HttpStatus.CREATED:HttpStatus.CONFLICT).body(apiResponse);
    }

    @PutMapping("/updateBasket/{id}")
    public ResponseEntity<ApiResponse> updateBasket(@PathVariable Integer id, @RequestBody BasketDto basketDto){
        ApiResponse apiResponse = basketService.updateBasket(id, basketDto);
        return ResponseEntity.status(apiResponse.isSuccess()?HttpStatus.ACCEPTED:HttpStatus.CONFLICT).body(apiResponse);
    }

    @DeleteMapping("/deleteBasket/{id}")
    public ResponseEntity<ApiResponse> deleteBasket(@PathVariable Integer id){
        ApiResponse apiResponse = basketService.deleteBasket(id);
        return ResponseEntity.status(apiResponse.isSuccess()?202:409).body(apiResponse);
    }
}
