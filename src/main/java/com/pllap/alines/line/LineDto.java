/*
 * Author : Hyeokwoo Kwon
 * Filename : LineDto.java
 * Desc :
 */

package com.pllap.alines.line;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@EqualsAndHashCode
public class LineDto {

    private String hash;
    private Long parentId;
    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;
    private String content;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

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
        this.hash = source.getHash();
        if (source.getParentLine() != null) {
            this.parentId = source.getParentLine().getId();
        } else {
            this.parentId = null;
        }
        this.createdDateTime = source.getCreatedDateTime();
        this.updatedDateTime = source.getUpdatedDateTime();
        this.content = source.getContent();
    }
}
