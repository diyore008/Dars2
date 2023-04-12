package uz.pdp.dars2_vazifa2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.dars2_vazifa2.entity.Attachment;
import uz.pdp.dars2_vazifa2.payload.ApiResponse;
import uz.pdp.dars2_vazifa2.service.AttachmentService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AttachmentController {

    @Autowired
    AttachmentService attachmentService;

    @GetMapping("/getAttachment")
    public ResponseEntity<List<Attachment>> getAttachment(){
        List<Attachment> attachmentList = attachmentService.getAttachment();
        return ResponseEntity.ok(attachmentList);
    }

    @GetMapping("/getAttachmentById/{id}")
    public ResponseEntity<Attachment> getAttachmentById(@PathVariable Integer id){
        Attachment attachmentById = attachmentService.getAttachmentById(id);
        return ResponseEntity.ok(attachmentById);
    }

    @PostMapping("/addAttachment")
    public ResponseEntity<ApiResponse> addAttachment(@RequestBody MultipartHttpServletRequest request){
        ApiResponse apiResponse = attachmentService.addAttachment(request);
        return ResponseEntity.status(apiResponse.isSuccess()? HttpStatus.CREATED:HttpStatus.CONFLICT).body(apiResponse);
    }

    @PutMapping("/updateAttachment/{id}")
    public ResponseEntity<ApiResponse> updateAttachment(@PathVariable Integer id,@RequestBody MultipartHttpServletRequest request){
        ApiResponse apiResponse = attachmentService.updateAttachment(id, request);
        return ResponseEntity.status(apiResponse.isSuccess()?HttpStatus.ACCEPTED:HttpStatus.CONFLICT).body(apiResponse);
    }

    @DeleteMapping("/deleteAttachment/{id}")
    public ResponseEntity<ApiResponse> deleteAttachment(@PathVariable Integer id){
        ApiResponse apiResponse = attachmentService.deleteAttachment(id);
        return ResponseEntity.status(apiResponse.isSuccess()?HttpStatus.ACCEPTED:HttpStatus.CONFLICT).body(apiResponse);
    }
}
