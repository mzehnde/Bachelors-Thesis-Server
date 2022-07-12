package com.example.demo.Entities;public class MetadataPinata {
    private String ipfsHash;

    public MetadataPinata() {
    }

    public MetadataPinata(String ipfsHash) {
        this.ipfsHash = ipfsHash;
    }

    public String getIpfsHash() {
        return ipfsHash;
    }

    public void setIpfsHash(String ipfsHash) {
        this.ipfsHash = ipfsHash;
    }
}
