package com.project.menu.service;

import com.project.menu.model.dto.MenuRequest;
import com.project.menu.model.entity.Menu;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MenuService {
    void addTopMenu(MenuRequest menuRequest, MultipartFile multipartHttpServletRequest, HttpServletRequest request);
    void addMenu(MenuRequest menuRequest);

    void updateTopMenu(Integer menuId, MenuRequest menuRequest, MultipartFile multipartHttpServletRequest, HttpServletRequest request);
    void updateMenu(Integer menuId, MenuRequest menuRequest);
    void deleteMenu(Integer menuId);
    List<Menu> allMenu();

    List<Menu> getMenu(Integer menuId);
}
