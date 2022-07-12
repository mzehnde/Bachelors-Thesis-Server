package com.example.demo;

import com.example.demo.Entities.*;
import com.example.demo.REST.*;
import com.example.demo.Repositories.*;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.io.*;
import java.net.*;
import java.util.List;


@Controller
@RequestMapping(path="/test")
public class SendRewardController {

    @Autowired
    private NormalRewardRepository normalRewardRepository;

    @Autowired
    private NormalRewardGivenOutRepository normalRewardGivenOutRepository;

    @Autowired
    private NFTRewardGivenOutRepository nftRewardGivenOutRepository;

    @Autowired
    private NFTRewardRedeemedRepository nftRewardRedeemedRepository;

    @Autowired
    private NormalRewardRedeemedRepository normalRewardRedeemedRepository;

    private String BearerToken = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySW5mb3JtYXRpb24iOnsiaWQiOiJmMzU3YTBlNy1kM2NkLTRjY2MtOGUwZi1iYmJjYTlkZDZkNWUiLCJlbWFpbCI6Im1heC56ZWhuZGVyQGhvdG1haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsInBpbl9wb2xpY3kiOnsicmVnaW9ucyI6W3siaWQiOiJGUkExIiwiZGVzaXJlZFJlcGxpY2F0aW9uQ291bnQiOjF9XSwidmVyc2lvbiI6MX0sIm1mYV9lbmFibGVkIjpmYWxzZSwic3RhdHVzIjoiQUNUSVZFIn0sImF1dGhlbnRpY2F0aW9uVHlwZSI6InNjb3BlZEtleSIsInNjb3BlZEtleUtleSI6IjA2ZGY2NjQzMTE3MThiZDUxMjM4Iiwic2NvcGVkS2V5U2VjcmV0IjoiOTA3ZDNmOTQyMjc3ZWE4NjRjNjdhOWY4YTgzZDBmYjNkMTM3OWY0MGI4ZmZlZDJjNDI4YTJmOWZjYWM2YTY5OCIsImlhdCI6MTY1NzE5MzQ2NX0.uAgBlwk3aYq9-ifBUjXx4aZZC2YUWRT9J_2Mn7MC_0g";


    //Send Email with Normal reward
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path="/sendNormalEmail") // Map ONLY POST Requests
    public @ResponseBody String sendReward (@RequestBody UserPostDTO userPostDTO){
        User userToReceiveReward = DTOMapper.INSTANCE.convertUserPostDTOtoEntity(userPostDTO);
        List<NormalReward> allNormalRewards = normalRewardRepository.findAll();
        NormalReward normalRewardToSend = allNormalRewards.get(0);
        Mail email = new Mail(userToReceiveReward.getEmailAddress(), "claimyourawesomereward@gmail.com", normalRewardToSend.getImage(), normalRewardToSend.getLocation(), normalRewardToSend.getDescription());
        email.sendEmail();
        NormalRewardGivenOut normalRewardGivenOut = new NormalRewardGivenOut(normalRewardToSend.getId(), normalRewardToSend.getName(), normalRewardToSend.getImage(), normalRewardToSend.getLocation(), normalRewardToSend.getPartner());
        normalRewardGivenOutRepository.save(normalRewardGivenOut);
        normalRewardRepository.delete(normalRewardToSend);
        return normalRewardToSend.getDescription();
    }

    //Send Email with NFT Reward
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path="/sendNFTEmail") // Map ONLY POST Requests
    public @ResponseBody String sendNFTMail (@RequestBody NFTMailPutDTO nftMailPutDTO){
        NFTMail nftMail = DTOMapper.INSTANCE.convertNFTMailPutDTOtoEntity(nftMailPutDTO);
        int NFTId = nftMail.getId();
        String emailAddress = nftMail.getEmail();

        NFTRewardGivenOut nft = nftRewardGivenOutRepository.findById(NFTId);
        Mail mail = new Mail(emailAddress, "claimyourawesomereward@gmail.com", nft.getImage(), nft.getLocation(), nft.getDescription());
        mail.sendEmail();
        return "Email sent";

    }


    //Get metadata for minting & save it in db
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path="/metadata/{partnerWhereRewardReceived}") // Map ONLY POST Requests
    public @ResponseBody
    Object getMetadata (@PathVariable String partnerWhereRewardReceived) throws IOException, JSONException, URISyntaxException, ParseException {

        //create Url
        String baseURL = "https://api.pinata.cloud/data/pinList?";
        String pinnedParam = "&status=pinned";
        String metadataParam = "metadata[keyvalues]=";
        String metadataValues = "{\"Partner\":{\"value\":\""+partnerWhereRewardReceived+"\",\"op\":\"ne\"}}";
        String completeURL = baseURL + metadataParam + java.net.URLEncoder.encode(metadataValues, "UTF-8") + pinnedParam;

        //Process the request to receive hash for minting
        URL url = new URL(completeURL);
        SendRewardService sendRewardService = new SendRewardService(url, BearerToken);
        JSONObject jsonObject = sendRewardService.processRequest();

        //get the data
        JSONArray files = jsonObject.getJSONArray("rows");
        JSONObject metadataToMint = files.getJSONObject(0);
        String ipfsHash =  metadataToMint.getString("ipfs_pin_hash");
        JSONObject metadata = metadataToMint.getJSONObject("metadata");
        String name = metadata.getString("name");
        JSONObject keyvalues = metadata.getJSONObject("keyvalues");
        int id = keyvalues.getInt("Id");
        String image = keyvalues.getString("Image");
        String location = keyvalues.getString("Location");
        String description = keyvalues.getString("Description");

        //save as nft reward given out
        NFTRewardGivenOut nftRewardGivenOut = new NFTRewardGivenOut(id, name, image, ipfsHash, location, description);
        nftRewardGivenOutRepository.save(nftRewardGivenOut);

        //return the data
        NFTGetDTO nftGetDTO=DTOMapper.INSTANCE.convertEntityToNFTGetDTO(nftRewardGivenOut);
        return nftGetDTO;




    }

    //Delete the minted metadata
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(path="/metadata/delete") // Map ONLY POST Requests
    public @ResponseBody int deleteMetadata(@RequestBody MetadataPinataPutDTO metadataPinataPutDTO) throws IOException {
        MetadataPinata metadataPinata = DTOMapper.INSTANCE.convertMetadataPinataPutDTOtoEntity(metadataPinataPutDTO);
        String stringURL = "https://api.pinata.cloud/pinning/unpin/"+metadataPinata.getIpfsHash();
        URL url = new URL(stringURL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");
        con.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySW5mb3JtYXRpb24iOnsiaWQiOiJmMzU3YTBlNy1kM2NkLTRjY2MtOGUwZi1iYmJjYTlkZDZkNWUiLCJlbWFpbCI6Im1heC56ZWhuZGVyQGhvdG1haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsInBpbl9wb2xpY3kiOnsicmVnaW9ucyI6W3siaWQiOiJGUkExIiwiZGVzaXJlZFJlcGxpY2F0aW9uQ291bnQiOjF9XSwidmVyc2lvbiI6MX0sIm1mYV9lbmFibGVkIjpmYWxzZSwic3RhdHVzIjoiQUNUSVZFIn0sImF1dGhlbnRpY2F0aW9uVHlwZSI6InNjb3BlZEtleSIsInNjb3BlZEtleUtleSI6IjA2ZGY2NjQzMTE3MThiZDUxMjM4Iiwic2NvcGVkS2V5U2VjcmV0IjoiOTA3ZDNmOTQyMjc3ZWE4NjRjNjdhOWY4YTgzZDBmYjNkMTM3OWY0MGI4ZmZlZDJjNDI4YTJmOWZjYWM2YTY5OCIsImlhdCI6MTY1NzE5MzQ2NX0.uAgBlwk3aYq9-ifBUjXx4aZZC2YUWRT9J_2Mn7MC_0g") ;
        //CORRECT
        //CORRECT
        return con.getResponseCode();
    }

    //Check if the reward was already redeemed (NFT)
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(path="/isNFTRedeemed") // Map ONLY POST Requests
    public @ResponseBody
    boolean isNFTRedeemed(@RequestBody NFTisRedeemedPutDTO nfTisRedeemedPutDTO){
        NFTRewardGivenOut idToFind = DTOMapper.INSTANCE.convertNFTisRedeemedPutDTOtoEntity(nfTisRedeemedPutDTO);
        NFTRewardGivenOut rewardToCheck = nftRewardGivenOutRepository.findById(idToFind.getId());
        if (rewardToCheck==null){
            return true;
        }
        return false;
    }

    //Redeem the reward (NFT)
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(path="/redeemNFT") // Map ONLY POST Requests
    public @ResponseBody
    String redeemNFT(@RequestBody NFTRedeemPutDTO nftRedeemPutDTO){
    NFTRewardRedeemed nft = DTOMapper.INSTANCE.convertNFTRedeemPutDTOtoEntity(nftRedeemPutDTO);
    NFTRewardGivenOut nftToRedeem = nftRewardGivenOutRepository.findById(nft.getId());
    int id = nftToRedeem.getId();
    String name = nftToRedeem.getName();
    String image = nftToRedeem.getImage();
    String ipfsHash = nftToRedeem.getImage();
    String location = nftToRedeem.getLocation();
    NFTRewardRedeemed nftRewardRedeemed = new NFTRewardRedeemed(id, name, image, ipfsHash, location, nft.getSales());
    nftRewardRedeemedRepository.save(nftRewardRedeemed);
    nftRewardGivenOutRepository.delete(nftToRedeem);
    return "saved Sales";
    }

    //Check if the reward was already redeemed (Normal)
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(path="/isNormalRedeemed") // Map ONLY POST Requests
    public @ResponseBody
    boolean isNormalRedeemed(@RequestBody NFTisRedeemedPutDTO nfTisRedeemedPutDTO){
        NFTRewardGivenOut idToFind = DTOMapper.INSTANCE.convertNFTisRedeemedPutDTOtoEntity(nfTisRedeemedPutDTO);
        NormalRewardGivenOut rewardToCheck = normalRewardGivenOutRepository.findById(idToFind.getId());
        if (rewardToCheck==null){
            return true;
        }
        return false;
    }

    //Redeem the reward (Normal)
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(path="/redeemNormal") // Map ONLY POST Requests
    public @ResponseBody
    String redeemNormal(@RequestBody NFTRedeemPutDTO nftRedeemPutDTO){
        NFTRewardRedeemed nftRewardRedeemed = DTOMapper.INSTANCE.convertNFTRedeemPutDTOtoEntity(nftRedeemPutDTO);
        NormalRewardGivenOut rewardToRedeem = normalRewardGivenOutRepository.findById(nftRewardRedeemed.getId());
        int id= rewardToRedeem.getId();
        String name= rewardToRedeem.getName();
        String image = rewardToRedeem.getImage();
        String location = rewardToRedeem.getLocation();
        String partner = rewardToRedeem.getPartner();
        int sales = nftRewardRedeemed.getSales();

        NormalRewardRedeemed normalRewardRedeemed = new NormalRewardRedeemed(id, name, image, location, partner, sales);
        normalRewardRedeemedRepository.save(normalRewardRedeemed);
        normalRewardGivenOutRepository.delete(rewardToRedeem);
        return "added sales";
    }

}
