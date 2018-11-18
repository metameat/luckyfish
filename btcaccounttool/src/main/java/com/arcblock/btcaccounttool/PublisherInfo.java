package com.arcblock.btcaccounttool;

public class PublisherInfo {
    String address;
    String startedBlockHash;
    long playersNum;
    int totalAmountRecievedwhenStarting;

    public PublisherInfo() {}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStartedBlockHash() {
        return startedBlockHash;
    }

    public void setStartedBlockHash(String startedBlockHash) {
        this.startedBlockHash = startedBlockHash;
    }

    public long getPlayersNum() {
        return playersNum;
    }

    public void setPlayersNum(long playersNum) {
        this.playersNum = playersNum;
    }

    public int getTotalAmountRecievedwhenStarting() {
        return totalAmountRecievedwhenStarting;
    }

    public void setTotalAmountRecievedwhenStarting(int totalAmountRecievedwhenStarting) {
        this.totalAmountRecievedwhenStarting = totalAmountRecievedwhenStarting;
    }

    public PublisherInfo(String address, String startedBlockHash, long playersNum, int totalAmountRecievedwhenStarting) {
        this.address = address;
        this.startedBlockHash = startedBlockHash;
        this.playersNum = playersNum;
        this.totalAmountRecievedwhenStarting = totalAmountRecievedwhenStarting;
    }
}
