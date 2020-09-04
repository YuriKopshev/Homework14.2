package ru.netology.manager;


import java.util.*;

public class FileOpenManager {

    private Map<String, String> app = new HashMap<>();

    public FileOpenManager(Map<String, String> app) {
        this.app = app;
    }

    public void add(String extension, String appName) {
        app.put(extension.toLowerCase(), appName);
    }

    public String getAppName(String extension) {
        return app.get(extension.toLowerCase());
    }

    public void deleteLink(String extension) {
        app.remove(extension);
    }

    public List<String> getAllExtension(Map<String, String> map) {
        List<String> list = new ArrayList<>(map.keySet());
        return list;
    }

    public Set<String> getAllAppName(Map<String, String> map) {
        List<String> list = new ArrayList<>(map.values());
        Set<String> set = new HashSet<>();
        set.addAll(list);
        return set;

    }


}
