package com.irctc.backend.helper;

import java.util.UUID;

public class Helper {
    public static String generateFileName(String folder, String fileName)
    {
        String fileNameWithPath=folder+ UUID.randomUUID()+"_"+fileName;
        return fileNameWithPath;
    }

}
