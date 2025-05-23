package com.spring.aiwebapp.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;

@Entity
@Builder
@Table(name = "recipes")
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ingredients;

    private String cuisine;

    @Column(name = "dietary_restrictions")
    private String dietaryRestrictions;

    private String language;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_id", nullable = false)
    private TextChat textChat;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "response_id")
    private TextResponse textResponse;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

}
