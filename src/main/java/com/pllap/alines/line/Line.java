/*
 * Author : Hyeokwoo Kwon
 * Filename : Lines.java
 * Desc :
 */

package com.pllap.alines.line;

import com.pllap.alines.utils.Hash;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "line")
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private final Long id;

    @Column(name = "hash", unique = true)
    private String hash;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Line parentLine;

    @OneToMany(mappedBy = "parentLine", cascade = CascadeType.ALL)
    private List<Line> children;

    @Column(name = "created_datetime")
    private LocalDateTime createdDateTime;

    @Column(name = "updated_datetime")
    private LocalDateTime updatedDateTime;

    @Column(name = "content")
    private String content;

    public Line() {
        this.id = null;
    }

    public Line(Long id) {
        this.id = id;
    }

    public Line(Long id, String hash, Line parentLine, List<Line> children, LocalDateTime createdDateTime, LocalDateTime updatedDateTime, String content) {
        this.id = id;
        this.parentLine = parentLine;
        this.children = children;
        this.createdDateTime = createdDateTime;
        this.updatedDateTime = updatedDateTime;
        this.content = content;

        this.hash = Hash.sha256(this.createdDateTime.toString() + this.content);
    }
}
