package com.example.demo.REST;

import com.example.demo.Entities.MetadataPinata;
import com.example.demo.Entities.NFTMail;
import com.example.demo.Entities.NFTRewardGivenOut;
import com.example.demo.Entities.NFTRewardRedeemed;
import com.example.demo.Entities.Partner;
import com.example.demo.Entities.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-12T10:45:40+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 15 (Oracle Corporation)"
)
public class DTOMapperImpl implements DTOMapper {

    @Override
    public User convertUserPostDTOtoEntity(UserPostDTO userPostDTO) {
        if ( userPostDTO == null ) {
            return null;
        }

        String emailAddress = null;

        emailAddress = userPostDTO.getEmailAddress();

        String kindOfReward = null;

        User user = new User( emailAddress, kindOfReward );

        return user;
    }

    @Override
    public Partner convertPartnerGetDTOtoEntity(PartnerGetDTO partnerGetDTO) {
        if ( partnerGetDTO == null ) {
            return null;
        }

        String name = null;

        name = partnerGetDTO.getName();

        Partner partner = new Partner( name );

        return partner;
    }

    @Override
    public NFTGetDTO convertEntityToNFTGetDTO(NFTRewardGivenOut nftRewardGivenOut) {
        if ( nftRewardGivenOut == null ) {
            return null;
        }

        int id = 0;
        String ifpsHash = null;

        id = nftRewardGivenOut.getId();
        ifpsHash = nftRewardGivenOut.getIfpsHash();

        NFTGetDTO nFTGetDTO = new NFTGetDTO( id, ifpsHash );

        return nFTGetDTO;
    }

    @Override
    public MetadataPinata convertMetadataPinataPutDTOtoEntity(MetadataPinataPutDTO metadataPinataPutDTO) {
        if ( metadataPinataPutDTO == null ) {
            return null;
        }

        MetadataPinata metadataPinata = new MetadataPinata();

        metadataPinata.setIpfsHash( metadataPinataPutDTO.getIpfsHash() );

        return metadataPinata;
    }

    @Override
    public NFTMail convertNFTMailPutDTOtoEntity(NFTMailPutDTO nftMailPutDTO) {
        if ( nftMailPutDTO == null ) {
            return null;
        }

        NFTMail nFTMail = new NFTMail();

        nFTMail.setEmail( nftMailPutDTO.getEmail() );
        nFTMail.setId( nftMailPutDTO.getId() );

        return nFTMail;
    }

    @Override
    public NFTRewardGivenOut convertNFTisRedeemedPutDTOtoEntity(NFTisRedeemedPutDTO nfTisRedeemedPutDTO) {
        if ( nfTisRedeemedPutDTO == null ) {
            return null;
        }

        NFTRewardGivenOut nFTRewardGivenOut = new NFTRewardGivenOut();

        nFTRewardGivenOut.setId( nfTisRedeemedPutDTO.getId() );

        return nFTRewardGivenOut;
    }

    @Override
    public NFTRewardRedeemed convertNFTRedeemPutDTOtoEntity(NFTRedeemPutDTO nftRedeemPutDTO) {
        if ( nftRedeemPutDTO == null ) {
            return null;
        }

        NFTRewardRedeemed nFTRewardRedeemed = new NFTRewardRedeemed();

        nFTRewardRedeemed.setSales( nftRedeemPutDTO.getSales() );
        nFTRewardRedeemed.setId( nftRedeemPutDTO.getId() );

        return nFTRewardRedeemed;
    }
}
