package com.src.dao;

import com.src.domain.Human;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HumanDao{

    void addHuman(Human human);

    List<Human> findAllHuman();

    void deleteById (int id);
}
