package uz.pdp.dars2_vazifa2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.dars2_vazifa2.entity.Attachment;
import uz.pdp.dars2_vazifa2.entity.Info;
import uz.pdp.dars2_vazifa2.entity.Section;
import uz.pdp.dars2_vazifa2.payload.ApiResponse;
import uz.pdp.dars2_vazifa2.payload.SectionDto;
import uz.pdp.dars2_vazifa2.repository.AttachmentRepository;
import uz.pdp.dars2_vazifa2.repository.InfoRepository;
import uz.pdp.dars2_vazifa2.repository.SectionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SectionService {

    @Autowired
    SectionRepository sectionRepository;
    @Autowired
    InfoRepository infoRepository;
    @Autowired
    AttachmentRepository attachmentRepository;


    public List<Section> getSections(){
        List<Section> sectionList = sectionRepository.findAll();
        return sectionList;
    }

    public Section getSectionById(Integer id){
        Optional<Section> optionalSection = sectionRepository.findById(id);
        return optionalSection.get();
    }

    public ApiResponse addSection(SectionDto sectionDto){
        Optional<Info> optionalInfo = infoRepository.findById(sectionDto.getInfoId());
        if(!optionalInfo.isPresent())
            return new ApiResponse("Info not found", false);
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(sectionDto.getAttachmentId());
        if (!optionalAttachment.isPresent())
            return new ApiResponse("Attachment not found", false);

        Section section = new Section();
        section.setName(sectionDto.getName());
        section.setInfo(optionalInfo.get());
        section.setAttachment(optionalAttachment.get());
        sectionRepository.save(section);
        return new ApiResponse("Saved section", true);
    }


    public ApiResponse updateSection(Integer id, SectionDto sectionDto){
        Optional<Section> optionalSection = sectionRepository.findById(id);
        if(!optionalSection.isPresent())
            return new ApiResponse("Section not found", false);
        Optional<Info> optionalInfo = infoRepository.findById(sectionDto.getInfoId());
        if(!optionalInfo.isPresent())
            return new ApiResponse("Info not found", false);
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(sectionDto.getAttachmentId());
        if (!optionalAttachment.isPresent())
            return new ApiResponse("Attachment not found", false);

        Section section = optionalSection.get();
        section.setName(sectionDto.getName());
        section.setInfo(optionalInfo.get());
        section.setAttachment(optionalAttachment.get());
        sectionRepository.save(section);
        return new ApiResponse("Updated section", true);
    }

    public ApiResponse deleteSection(Integer id){
        try {
            sectionRepository.deleteById(id);
            return new ApiResponse("Deleted section", true);
        }catch (Error e){
            return new ApiResponse("Error", false);
        }
    }
}
