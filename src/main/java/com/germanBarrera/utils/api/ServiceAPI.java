package com.germanBarrera.utils.api;

public class ServiceAPI {

    public String getLastSegment(String url) {
        if (url == null || url.isEmpty()) {
            return "";
        }

        String[] parts = url.split("/");
        return parts[parts.length - 1];
    }
}
