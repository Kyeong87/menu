package com.project.menu.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class SpringFileWriter {

    public void writeFile(MultipartFile mf, String path, String fileName) {

        File file = new File(path,fileName);
        try {
            mf.transferTo(file);
        }catch (IllegalStateException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
