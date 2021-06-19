package com.src.service;

import com.src.dao.HumanDaoDb;
import com.src.domain.Human;
import com.src.dto.HumanDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class HumanService {

    private final HumanDaoDb humanDaoDb;

    @Transactional
    public void addHuman(HumanDto humanDto){
        Human human = fromHumanDto(humanDto);
        humanDaoDb.addHuman(human);
    }

    @Transactional
    public List<HumanDto> findAllHuman(){
        return humanDaoDb.findAllHuman()
                .stream()
                .map(this::getBuildHuman)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteById(int id){humanDaoDb.deleteById(id);}

    private HumanDto getBuildHuman(Human human) {
        return HumanDto.builder()
                .id(human.getId())
                .firstname(human.getFirstName())
                .lastname(human.getLastName())
                .patronymic(human.getPatronymic())
                .yearOfBirth(human.getYearOfBirth())
                .inn(human.getInn())
                .country(human.getCountry())
                .gender(human.getGender())
                .build();
    }


    private Human fromHumanDto(HumanDto humanDto){
        return Human.builder()
                .id(humanDto.getId())
                .firstName(humanDto.getFirstname())
                .lastName(humanDto.getLastname())
                .patronymic(humanDto.getPatronymic())
                .yearOfBirth(humanDto.getYearOfBirth())
                .inn(humanDto.getInn())
                .country(humanDto.getCountry())
                .gender(humanDto.getGender())
                .build();
    }
}
