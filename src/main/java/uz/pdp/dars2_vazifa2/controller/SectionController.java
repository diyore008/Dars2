package uz.pdp.dars2_vazifa2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.dars2_vazifa2.entity.Section;
import uz.pdp.dars2_vazifa2.payload.ApiResponse;
import uz.pdp.dars2_vazifa2.payload.SectionDto;
import uz.pdp.dars2_vazifa2.service.SectionService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SectionController {

    @Autowired
    SectionService sectionService;

    @GetMapping("/getSection")
    public ResponseEntity<List<Section>> getSections(){
        List<Section> sections = sectionService.getSections();
        return ResponseEntity.ok(sections);
    }

    @GetMapping("/getSectionById/{id}")
    public ResponseEntity<Section> getSectionById(@PathVariable Integer id){
        Section sectionById = sectionService.getSectionById(id);
        return ResponseEntity.ok(sectionById);
    }

    @PostMapping("/addSection")
    public ResponseEntity<ApiResponse> addSection(@RequestBody SectionDto sectionDto){
        ApiResponse apiResponse = sectionService.addSection(sectionDto);
        return ResponseEntity.status(apiResponse.isSuccess()? HttpStatus.CREATED:HttpStatus.CONFLICT).body(apiResponse);
    }

    @PutMapping("/updateSection/{id}")
    public ResponseEntity<ApiResponse> updateSection(@PathVariable Integer id, @RequestBody SectionDto sectionDto){
        ApiResponse apiResponse = sectionService.updateSection(id, sectionDto);
        return ResponseEntity.status(apiResponse.isSuccess()?HttpStatus.ACCEPTED:HttpStatus.CONFLICT).body(apiResponse);
    }


    @DeleteMapping("/deleteSection/{id}")
    public ResponseEntity<ApiResponse> deleteSection(@PathVariable Integer id){
        ApiResponse apiResponse = sectionService.deleteSection(id);
        return ResponseEntity.status(apiResponse.isSuccess()?202:409).body(apiResponse);
    }
}
