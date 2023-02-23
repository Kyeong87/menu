package com.project.menu.repository;

import com.project.menu.model.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
    Menu findBySeqNo(Integer menuId);
    List<Menu> findByParentsId(Integer menuId);
}
