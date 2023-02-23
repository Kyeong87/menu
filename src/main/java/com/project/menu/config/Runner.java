package com.project.menu.config;

import com.project.menu.model.entity.Menu;
import com.project.menu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;

@Component
public class Runner implements org.springframework.boot.ApplicationRunner {

    @Autowired
    MenuRepository menuRepository;

    @Override
    public void run(ApplicationArguments args){

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        Menu menu1 = Menu.builder()
                .title("상위1")
                .parentsId(0)
                .createDate(now)
                .updateDate(now)
                .build();
        Menu menu2 = Menu.builder()
                .title("하위1-1")
                .parentsId(1)
                .createDate(now)
                .updateDate(now)
                .build();
        Menu menu3 = Menu.builder()
                .title("하위1-2")
                .parentsId(1)
                .createDate(now)
                .updateDate(now)
                .build();
        menuRepository.saveAll(Arrays.asList(menu1,menu2,menu3));

    }
}
