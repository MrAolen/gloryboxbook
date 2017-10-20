package fr.gunther.glorybox.website.service;

public interface StaticDataService {
    String getValueByKey(String key);

    void updateByKey(String key, String value);
}
