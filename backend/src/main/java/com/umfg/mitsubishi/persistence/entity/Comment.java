package com.umfg.mitsubishi.persistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private @NonNull String text;

    @Column(updatable = false)
    @CreationTimestamp
    private Timestamp creationDate;

    @OneToOne
    private @NonNull Qualifier qualifier;

    @ManyToOne
    private @NonNull User author;
}
