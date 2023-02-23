package com.project.menu.service.impl;

import com.project.menu.config.exception.ApiException;
import com.project.menu.model.dto.MenuRequest;
import com.project.menu.model.entity.Banner;
import com.project.menu.model.entity.Menu;
import com.project.menu.repository.BannerRepository;
import com.project.menu.repository.MenuRepository;
import com.project.menu.service.MenuService;
import com.project.menu.util.SpringFileWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private BannerRepository bannerRepository;

    @Override
    @Transactional
    public void addTopMenu(MenuRequest menuRequest, MultipartFile multiRequest, HttpServletRequest request) {

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));

        if(multiRequest == null) throw new ApiException(HttpStatus.BAD_REQUEST, "파일을 업로드 해주세요.");

        String path = request.getSession().getServletContext().getRealPath("/");
        String fileName = multiRequest.getOriginalFilename();

        SpringFileWriter springFileWriter = new SpringFileWriter();
        springFileWriter.writeFile(multiRequest, path, fileName);

        Banner banner = new Banner();
        banner.setFileDir(path);
        banner.setFileName(fileName);
        bannerRepository.save(banner);

        Menu menu = new Menu();
        menu.setTitle(menuRequest.getTitle());
        menu.setBannerId(banner.getSeqNo());
        menu.setParentsId(0);
        menu.setCreateDate(now);
        menuRepository.save(menu);
    }

    @Override
    @Transactional
    public void addMenu(MenuRequest menuRequest) {

        if(menuRequest.getParentsId() == null) throw new ApiException(HttpStatus.BAD_REQUEST, "부모 메뉴를 입력해주세요.");

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));

        Menu menu = new Menu();
        menu.setTitle(menuRequest.getTitle());
        menu.setParentsId(menuRequest.getParentsId());
        menu.setCreateDate(now);
        menuRepository.save(menu);
    }

    @Override
    @Transactional
    public void updateTopMenu(Integer menuId, MenuRequest menuRequest, MultipartFile multiRequest, HttpServletRequest request) {

        Menu findMenu = menuRepository.findBySeqNo(menuId);
        if(Objects.isNull(findMenu)) throw new ApiException(HttpStatus.BAD_REQUEST, "존재하지 않는 메뉴입니다.");

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));

        if(multiRequest != null) {
            String path = request.getSession().getServletContext().getRealPath("/");
            String fileName = multiRequest.getOriginalFilename();

            SpringFileWriter springFileWriter = new SpringFileWriter();
            springFileWriter.writeFile(multiRequest, path, fileName);

            Banner findBanner = bannerRepository.findBySeqNo(findMenu.getBannerId());
            if(Objects.isNull(findBanner)) {
                Banner banner = new Banner();
                banner.setFileName(fileName);
                banner.setFileDir(path);
                bannerRepository.save(banner);
            }else {
                findBanner.setFileDir(path);
                findBanner.setFileName(fileName);
                bannerRepository.save(findBanner);
            }
        }

        findMenu.setTitle(menuRequest.getTitle());
        findMenu.setUpdateDate(now);
        menuRepository.save(findMenu);
    }

    @Override
    @Transactional
    public void updateMenu(Integer menuId, MenuRequest menuRequest) {
        Menu findMenu = menuRepository.findBySeqNo(menuId);
        if(Objects.isNull(findMenu)) throw new ApiException(HttpStatus.BAD_REQUEST, "존재하지 않는 메뉴입니다.");

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));

        findMenu.setTitle(menuRequest.getTitle());
        findMenu.setParentsId(menuRequest.getParentsId());
        findMenu.setUpdateDate(now);
        menuRepository.save(findMenu);
    }

    @Override
    @Transactional
    public void deleteMenu(Integer menuId) {
        Menu findMenu = menuRepository.findBySeqNo(menuId);
        if(Objects.isNull(findMenu)) throw new ApiException(HttpStatus.BAD_REQUEST, "존재하지 않는 메뉴입니다.");

        Banner banner = bannerRepository.findBySeqNo(findMenu.getBannerId());
        if(!Objects.isNull(banner)) {
            bannerRepository.delete(banner);
        }

        menuRepository.delete(findMenu);
    }

    @Override
    public List<Menu> allMenu() {
        List<Menu> findMenu = menuRepository.findAll();
        return findMenu;
    }

    @Override
    public List<Menu> getMenu(Integer menuId) {
        Menu findMenu = menuRepository.findBySeqNo(menuId);
        if(Objects.isNull(findMenu)) throw new ApiException(HttpStatus.BAD_REQUEST, "존재하지 않는 메뉴입니다.");
        List<Menu> menuList = new ArrayList<>();
        menuList.add(findMenu);
        if(findMenu.getParentsId() == 0 || findMenu.getParentsId() == null) {
            List<Menu> findMenuList = menuRepository.findByParentsId(menuId);
            for(Menu find: findMenuList) {
                menuList.add(find);
            }
        }
        return menuList;
    }

}
