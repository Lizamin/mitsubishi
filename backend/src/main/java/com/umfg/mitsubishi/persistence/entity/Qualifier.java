package com.umfg.mitsubishi.persistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Qualifier {

    @Id
    private @NonNull Integer id;

    @Column
    private @NonNull String qualifier;
}
