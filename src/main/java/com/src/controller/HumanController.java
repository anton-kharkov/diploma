package com.src.controller;

import com.src.dto.HumanDto;
import com.src.service.HumanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/human")
public class HumanController {

    private final HumanService humanService;

    @GetMapping
    public List<HumanDto> findAllHuman(){return humanService.findAllHuman();}

    @PostMapping
    public void addHuman(@RequestBody HumanDto humanDto){
        humanService.addHuman(humanDto);
    }

    @DeleteMapping
    public void deleteById(@RequestBody int id){humanService.deleteById(id);}
}
