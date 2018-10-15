package com.meeting.m2.config;

import org.springframework.stereotype.Component;

@Component
public class FdfsConfig {

    private String resHost = "192.168.9.133";

    private String storagePort = "80";

    public String getResHost() {
        return resHost;
    }

    public void setResHost(String resHost) {
        this.resHost = resHost;
    }

    public String getStoragePort() {
        return storagePort;
    }

    public void setStoragePort(String storagePort) {
        this.storagePort = storagePort;
    }

}
