package com.umfg.mitsubishi.controller;

import com.umfg.mitsubishi.controller.dto.CommentDTO;
import com.umfg.mitsubishi.model.SecurityContext;
import com.umfg.mitsubishi.persistence.entity.Comment;
import com.umfg.mitsubishi.persistence.entity.Qualifier;
import com.umfg.mitsubishi.persistence.entity.User;
import com.umfg.mitsubishi.persistence.repo.CommentRepo;
import com.umfg.mitsubishi.persistence.repo.QualifierRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentRepo commentRepo;
    private final QualifierRepo qualifierRepo;
    private final SecurityContext securityContext;

    @GetMapping("{qualifier}")
    public List<CommentDTO> getCommentsByQualifier(@PathVariable("qualifier") String qualifierName) {
        Qualifier qualifier = qualifierRepo.getByQualifier(qualifierName).orElseThrow(EntityNotFoundException::new);
        return commentRepo.getAllByQualifierOrderByCreationDateDesc(qualifier)
                          .stream()
                          .map(CommentDTO::from)
                          .collect(Collectors.toList());
    }

    @PostMapping("{qualifier}")
    @PreAuthorize("hasAuthority('USER')")
    public void createComment(@PathVariable("qualifier") String qualifier, @RequestBody CommentDTO commentDTO) {
        User user = securityContext.getUser();
        Qualifier qualifierPojo = qualifierRepo.getByQualifier(qualifier)
                                               .orElseThrow(EntityNotFoundException::new);
        commentRepo.save(new Comment(commentDTO.getText(), qualifierPojo, user));
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void createComment(@PathVariable("id") Integer id) {
        commentRepo.deleteById(id);
    }
}
