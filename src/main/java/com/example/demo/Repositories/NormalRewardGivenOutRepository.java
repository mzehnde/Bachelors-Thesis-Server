package com.example.demo.Repositories;


import com.example.demo.Entities.NormalReward;
import com.example.demo.Entities.NormalRewardGivenOut;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NormalRewardGivenOutRepository extends CrudRepository<NormalRewardGivenOut, Integer> {


    List<NormalRewardGivenOut> findAll();
    NormalRewardGivenOut findById(int id);


}