package com.example.demo.REST;

import com.example.demo.Entities.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DTOMapper {
    DTOMapper INSTANCE = Mappers.getMapper(DTOMapper.class);

    /*@Mapping(source = "id", target = "id")
    Partner convertPartnerPostDTOtoEntity(PartnerPostDTO partnerPostDTO);*/

    @Mapping(source = "emailAddress", target = "emailAddress")
    User convertUserPostDTOtoEntity(UserPostDTO userPostDTO);

    @Mapping(source = "name", target = "name")
    Partner convertPartnerGetDTOtoEntity(PartnerGetDTO partnerGetDTO);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "ifpsHash", target = "ifpsHash")
    NFTGetDTO convertEntityToNFTGetDTO(NFTRewardGivenOut nftRewardGivenOut);

    @Mapping(source = "ipfsHash", target = "ipfsHash")
    MetadataPinata convertMetadataPinataPutDTOtoEntity(MetadataPinataPutDTO metadataPinataPutDTO);

    @Mapping(source = "email", target = "email")
    @Mapping(source = "id", target = "id")
    NFTMail convertNFTMailPutDTOtoEntity(NFTMailPutDTO nftMailPutDTO);

    @Mapping(source = "id", target ="id")
    NFTRewardGivenOut convertNFTisRedeemedPutDTOtoEntity(NFTisRedeemedPutDTO nfTisRedeemedPutDTO);

    @Mapping(source = "sales", target = "sales")
    @Mapping(source = "id", target = "id")
    NFTRewardRedeemed convertNFTRedeemPutDTOtoEntity(NFTRedeemPutDTO nftRedeemPutDTO);

    /*@Mapping(source = "sales", target = "sales")
    @Mapping(source = "qrcodereward", target = "qrcodereward")
    NormalReward convertRewardPutDTOtoEntity(RewardPutDTO rewardPutDTO);

    @Mapping(source = "qrcodereward", target = "qrcodereward")
    NormalReward convertIsRedeemedGetDTOtoEntity(IsRedeemedGetDTO isRedeemedGetDTO);*/
}
