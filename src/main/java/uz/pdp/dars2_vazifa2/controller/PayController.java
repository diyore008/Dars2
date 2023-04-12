package uz.pdp.dars2_vazifa2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.dars2_vazifa2.entity.Pay;
import uz.pdp.dars2_vazifa2.payload.ApiResponse;
import uz.pdp.dars2_vazifa2.payload.PayDto;
import uz.pdp.dars2_vazifa2.service.PayService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PayController {

    @Autowired
    PayService payService;

    @GetMapping("/getPays")
    public ResponseEntity<List<Pay>> getPays(){
        List<Pay> payList = payService.getPays();
        return ResponseEntity.ok(payList);
    }

    @GetMapping("/getPayById/{id}")
    public ResponseEntity<Pay> getPayById(@PathVariable Integer id){
        Pay payById = payService.getPayById(id);
        return ResponseEntity.ok(payById);
    }


    @PostMapping("/addPay")
    public ResponseEntity<ApiResponse> addPay(@RequestBody PayDto payDto){
        ApiResponse apiResponse = payService.addPay(payDto);
        return ResponseEntity.status(apiResponse.isSuccess()? HttpStatus.CREATED:HttpStatus.CONFLICT).body(apiResponse);
    }

    @PutMapping("/updatePay/{id}")
    public ResponseEntity<ApiResponse> updatePay(@PathVariable Integer id, @RequestBody PayDto payDto){
        ApiResponse apiResponse = payService.updatePay(id, payDto);
        return ResponseEntity.status(apiResponse.isSuccess()?HttpStatus.ACCEPTED:HttpStatus.CONFLICT).body(apiResponse);
    }

    @DeleteMapping("/deletePay/{id}")
    public ResponseEntity<ApiResponse> deletePay(@PathVariable Integer id){
        ApiResponse apiResponse = payService.deletePay(id);
        return ResponseEntity.status(apiResponse.isSuccess()?202:409).body(apiResponse);
    }
}
