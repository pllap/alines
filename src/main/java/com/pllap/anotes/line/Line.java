/*
 * Author : Hyeokwoo Kwon
 * Filename : Lines.java
 * Desc :
 */

package com.pllap.anotes.line;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "line")
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private final Long id;

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
}
