package com.example.demo.Repositories;

import com.example.demo.Entities.NFTRewardGivenOut;
import com.example.demo.Entities.NormalReward;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NFTRewardGivenOutRepository extends CrudRepository<NFTRewardGivenOut, Integer> {



    NFTRewardGivenOut findById(int id);
}
