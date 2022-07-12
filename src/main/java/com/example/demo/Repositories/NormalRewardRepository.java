package com.example.demo.Repositories;

import com.example.demo.Entities.NormalReward;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NormalRewardRepository extends CrudRepository<NormalReward, Integer> {


    List<NormalReward> findAll();

    /*List<NormalReward> findByQrcodepartner(String partner_qr_code);

    NormalReward findByQrcodereward(String qrcodereward);*/
}

