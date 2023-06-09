package com.proba.blog;

import com.proba.blog.repo.PostRepository;
import com.proba.blog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="Word") String name, Model model) {
        model.addAttribute("name", name);
        Iterable<Post> posts= postRepository.findAll();
        model.addAttribute("posts", posts);
        return "greeting";
    }

}






