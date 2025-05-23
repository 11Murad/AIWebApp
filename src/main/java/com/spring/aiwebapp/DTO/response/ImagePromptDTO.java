package com.spring.aiwebapp.DTO.response;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImagePromptDTO {
    private Long id;
    
    @NotBlank(message = "Prompt is required")
    private String prompt;
    private int n;
    private int height;
    private int width;

    private List<ImageResponseDTO> response;
}
