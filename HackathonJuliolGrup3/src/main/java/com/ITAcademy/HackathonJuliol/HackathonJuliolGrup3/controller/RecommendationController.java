package com.ITAcademy.HackathonJuliol.HackathonJuliolGrup3.controller;

import com.ITAcademy.HackathonJuliol.HackathonJuliolGrup3.dto.PetitionDTO;
import com.ITAcademy.HackathonJuliol.HackathonJuliolGrup3.entity.Petition;
import com.ITAcademy.HackathonJuliol.HackathonJuliolGrup3.entity.Recommendation;
import com.ITAcademy.HackathonJuliol.HackathonJuliolGrup3.entity.Tags;
import com.ITAcademy.HackathonJuliol.HackathonJuliolGrup3.service.PetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/petition")
public class RecommendationController {

    @Autowired
    PetitionService petitionService;

    @GetMapping("/{id}")
    public ResponseEntity<Petition> getPetitionByCreatorId(@PathVariable("id") String id) {
        return ResponseEntity.ok(petitionService.getPetitionByCreatorId(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<PetitionDTO>> getPetitionsTags(@RequestBody Tags tags) {
        return ResponseEntity.ok(petitionService.getPetitionsTags(tags));
    }

    @PostMapping("/")
    public ResponseEntity<PetitionDTO> createPetition(@Valid @RequestBody PetitionDTO petitionDTO) {
        return new ResponseEntity<>(petitionService.createPetition(petitionDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetitionDTO> updatePetition(@Valid @RequestBody PetitionDTO petitionDTO, String id) {
        return new ResponseEntity<>(petitionService.updatePetition(petitionDTO, id), HttpStatus.CREATED);
    }

    @PostMapping("/{id_petition}/")
    public ResponseEntity<Petition> createRecommendation(@Valid @RequestBody Recommendation recommendation, @PathVariable("id_petition") String id_petition) {
        return new ResponseEntity<>(petitionService.insertRecommendation(id_petition, recommendation), HttpStatus.CREATED);
    }

    @PutMapping("/{id_petition}/{id}")
    public ResponseEntity<Petition> updateRecommendation(@Valid @RequestBody Recommendation recommendation, @PathVariable("id_petition") String id_petition, @PathVariable("id") Long id) {
        return new ResponseEntity<>(petitionService.updateRecomendation(id_petition, id, recommendation), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePetition(@PathVariable("id") String id_petition) {
        petitionService.deletePetition(id_petition);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id_petition}/{id}")
    public ResponseEntity<Petition> deleteRecommendation(@PathVariable("id_petition") String id_petition, @PathVariable("id") Long id) {
        return new ResponseEntity<>(petitionService.removeRecomendation(id_petition, id), HttpStatus.CREATED);
    }

}
