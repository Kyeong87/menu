package com.project.menu.controller;

import com.project.menu.model.dto.MenuRequest;
import com.project.menu.model.entity.Menu;
import com.project.menu.service.MenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class MenuController {

    @Autowired
    MenuService menuService;

    @RequestMapping(value = "/menu", method = RequestMethod.POST)
    @ApiOperation(value = "메뉴 등록", notes = "메뉴 등록")
    public void addMenu(@ModelAttribute MenuRequest menuRequest,
                        @RequestParam(value = "file",required = false) MultipartFile file,
                        HttpServletRequest request) {
        if(menuRequest.getParentsId() == null) {
            menuService.addTopMenu(menuRequest, file, request);
        }else {
            menuService.addMenu(menuRequest);
        }
    }

    @RequestMapping(value = "/menu/{menuId}", method = RequestMethod.PATCH)
    @ApiOperation(value = "메뉴 수정", notes = "메뉴 수정")
    public void updateMenu(@PathVariable(name = "menuId") Integer menuId,
                           @ModelAttribute MenuRequest menuRequest,
                           @RequestParam(value = "file",required = false) MultipartFile file,
                           HttpServletRequest request) {
        if(file != null) {
            menuService.updateTopMenu(menuId, menuRequest, file, request);
        }else {
            menuService.updateMenu(menuId, menuRequest);
        }
    }

    @RequestMapping(value = "/menu/{menuId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "메뉴 삭제", notes = "메뉴 삭제")
    public void deleteMenu(@PathVariable(name = "menuId") Integer menuId) {
        menuService.deleteMenu(menuId);
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    @ApiOperation(value = "전체 메뉴", notes = "전체 메뉴")
    public List<Menu> allMenu() {
        return menuService.allMenu();
    }

    @RequestMapping(value = "/menu/{menuId}", method = RequestMethod.GET)
    @ApiOperation(value = "메뉴 단일 조회", notes = "메뉴 단일 조회")
    public List<Menu> getMenu(@PathVariable(name = "menuId") Integer menuId) {
        return menuService.getMenu(menuId);
    }

}
