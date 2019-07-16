package com.umfg.mitsubishi.controller;

import com.umfg.mitsubishi.persistence.repo.CommentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/statistics")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StatisticsController {

    private final CommentRepo commentRepo;

    @GetMapping("/comments")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Map<String, Long> getTotalComments() {
        return new HashMap<String, Long>() {{
            put("total_comments", commentRepo.getTotalComments());
        }};
    }
}
