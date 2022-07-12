package com.example.demo.REST;public class MetadataPinataPutDTO {
    private String ipfsHash;

    public MetadataPinataPutDTO() {
    }

    public MetadataPinataPutDTO(String ipfsHash) {
        this.ipfsHash = ipfsHash;
    }

    public String getIpfsHash() {
        return ipfsHash;
    }

    public void setIpfsHash(String ipfsHash) {
        this.ipfsHash = ipfsHash;
    }
}
