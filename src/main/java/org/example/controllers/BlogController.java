package org.example.controllers;


import org.example.data.BlogData;
import org.example.models.Blog;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

class BlogController {

    private BlogData blogData   = new BlogData();

    @GetMapping
    public String home(Model model){
        model.addAttribute("title", "Dragon Admin Blog");
        model.addAttribute("blogs", BlogData.getAll());
        return "home";
    }

    @GetMapping("/new-post")
    public String newPostForm(Model model){
        model.addAttribute("blog", new Blog());
        return "newPost";
    }

    @PostMapping("/new-post")
    public String handlePostForm(Model model,  @ModelAttribute Blog blog){
       model.addAttribute("blog", String.valueOf(blog));
        blogData.add(blog);
        return "displayPost";
    }
}
