package com.example.Beep.api.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@AllArgsConstructor
@Builder
public class Preset extends BaseEntity{

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(nullable = false)
    private Integer number;

    @Column(nullable = false)
    private Integer part;

    @Column(length = 11,nullable = false)
    private String content;

    public Preset update(Integer number, String content) {
        this.number = number;
        this.content = content;
        return this;
    }
}
