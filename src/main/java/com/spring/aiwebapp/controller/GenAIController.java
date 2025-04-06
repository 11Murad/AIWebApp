package com.spring.aiwebapp.controller;

import com.spring.aiwebapp.service.ChatService;
import com.spring.aiwebapp.service.ImageService;
import com.spring.aiwebapp.service.RecipeService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ai.image.ImageResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1/app")
public class GenAIController {
    public final ChatService chatService;
    public final ImageService imageService;
    public final RecipeService recipeService;

    public GenAIController(ChatService chatService, ImageService imageService, RecipeService recipeService) {
        this.chatService = chatService;
        this.imageService = imageService;
        this.recipeService = recipeService;
    }

//    @GetMapping("/ask-ai")
//    public String getResponse (@RequestParam String prompt) {
//        return chatService.getResponse(prompt);
//    }

    @GetMapping("/ask-ai")
    public String getResponseByOptions(@RequestParam String prompt) {
        return chatService.getResponseByOptions(prompt);
    }

    @GetMapping("/generate-images")
    public List<String> generateImage (HttpServletResponse response,
                                       @RequestParam String prompt,
                                       @RequestParam(defaultValue = "hd") String quality,
                                       @RequestParam(defaultValue = "1") int n,
                                       @RequestParam(defaultValue = "1024") int height,
                                       @RequestParam(defaultValue = "1024") int width)    throws IOException {
        List<String> imageUrls = imageService.generateImageByOptions(prompt, quality, n, height, width);
        return imageUrls;
    }


    @GetMapping("/recipe-creator")
    public String createRecipe (@RequestParam String ingredients,
                                @RequestParam(defaultValue = "any" ) String cuisine,
                                @RequestParam(defaultValue = "") String dietaryRestrictions,
                                @RequestParam(defaultValue = "english") String language) {
        return recipeService.createRecipe(ingredients, cuisine, dietaryRestrictions, language);

    }



}
