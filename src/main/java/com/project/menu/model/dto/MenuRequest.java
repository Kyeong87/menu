package com.project.menu.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MenuRequest {

    public String title;

    public Integer parentsId;

}
