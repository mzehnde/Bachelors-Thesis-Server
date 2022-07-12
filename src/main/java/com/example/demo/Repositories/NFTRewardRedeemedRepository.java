package com.example.demo.Repositories;

import com.example.demo.Entities.NFTRewardRedeemed;
import com.example.demo.Entities.NormalRewardGivenOut;
import org.springframework.data.repository.CrudRepository;

public interface NFTRewardRedeemedRepository extends CrudRepository<NFTRewardRedeemed, Integer> {

    NFTRewardRedeemed findById(int id);
}
