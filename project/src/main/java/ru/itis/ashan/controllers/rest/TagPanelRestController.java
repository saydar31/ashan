package ru.itis.ashan.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.ashan.entities.rest.request.TagRequestDto;
import ru.itis.ashan.entities.rest.response.AdminResponseDto;
import ru.itis.ashan.entities.rest.response.TagResponseDto;
import ru.itis.ashan.entities.tag.TagDto;
import ru.itis.ashan.services.TagService;

import java.util.Optional;

@RestController
public class TagPanelRestController {

    @Autowired
    private TagService tagService;

    @PostMapping("/api/admin/add_tag")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<TagResponseDto> addNewTag(@RequestBody TagRequestDto tagRequestDto) {
        Optional<TagDto> optionalTagDto = tagService.addNewTag(tagRequestDto.getTagName());

        return optionalTagDto.map(tagDto -> ResponseEntity.ok().body(
                new TagResponseDto("success", String.valueOf(tagDto.getId())))).orElseGet(() ->
                ResponseEntity.ok().body(
                        new TagResponseDto("fail", "Tag " + tagRequestDto.getTagName() + " already exist")));
    }

    @PostMapping("/api/admin/delete_tag")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<TagResponseDto> deleteTag(@RequestBody TagRequestDto tagRequestDto) {
        boolean resultState = tagService.deleteTag(tagRequestDto.getTagId());

        if (resultState) {
            return ResponseEntity.ok().body(new TagResponseDto("success", "Tag deleted"));
        }
        return ResponseEntity.ok().body(new TagResponseDto("fail", "Tag is not exist"));
    }
}
