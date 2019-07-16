package com.umfg.mitsubishi.controller.dto;

import com.umfg.mitsubishi.persistence.entity.Comment;
import lombok.Data;

import java.text.SimpleDateFormat;

@Data
public class CommentDTO {

    private Integer id;
    private String text;
    private Integer userId;
    private String authorName;
    private String creationDate;

    public static CommentDTO from(Comment comment){
        CommentDTO dto = new CommentDTO();
        dto.setId(comment.getId());
        dto.setText(comment.getText());
        dto.setAuthorName(comment.getAuthor().getName());
        dto.setUserId(comment.getAuthor().getId());

        SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        dto.setCreationDate(sdfDate.format(comment.getCreationDate()));
        return dto;
    }
}
