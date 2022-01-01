/*
 * Author : Hyeokwoo Kwon
 * Filename : LineDto.java
 * Desc :
 */

package com.pllap.alines.line;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Objects;

@ToString
@EqualsAndHashCode
public class LineDto {
    private Long parentId;
    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;
    private String content;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LineDto(Line source) {
        if (Objects.isNull(source.getParentLine())) {
            this.parentId = null;
        } else {
            this.parentId = source.getParentLine().getId();
        }
        this.createdDateTime = source.getCreatedDateTime();
        this.updatedDateTime = source.getUpdatedDateTime();
        this.content = source.getContent();
    }
}
