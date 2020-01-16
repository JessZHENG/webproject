package com.example.webproject.controller;

import com.example.webproject.entity.Information;
import com.example.webproject.repository.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/info")
public class InformationController {//信息文件相关控制（检索、查询、浏览）
    @Autowired
    private InformationRepository informationRepository;

    @GetMapping
    public List<Information> list(
            @RequestParam(value = "title",required = false,defaultValue = "")String title,
            @RequestParam(value = "summary",required = false,defaultValue = "")String summary,
            @RequestParam(value = "content",required = false,defaultValue = "")String content,
            @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
            @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize
                                  ){
        Pageable pageable= PageRequest.of(pageIndex,pageSize);
        Page<Information> page=informationRepository.findByTitleContainingOrSummaryContainingOrContentContaining(title,summary,content,pageable);
        return page.getContent();

    }


}
