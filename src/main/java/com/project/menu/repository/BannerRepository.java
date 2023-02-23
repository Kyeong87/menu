package com.project.menu.repository;

import com.project.menu.model.entity.Banner;
import com.project.menu.model.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Integer> {
    Banner findBySeqNo(Integer Id);
}
