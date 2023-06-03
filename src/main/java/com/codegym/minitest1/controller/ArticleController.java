package com.codegym.minitest1.controller;

import com.codegym.minitest1.model.Article;
import com.codegym.minitest1.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("articles", ArticleService.getAllArticles());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("article", new Article());
        return "create";
    }

    @PostMapping("/save")
    public String save(Article article, RedirectAttributes redirect) {
        article.setCreatedDate(new Date());
        ArticleService.addArticle(article);

        redirect.addFlashAttribute("notify", "Thêm mới thành công");
        return "redirect:/article/list";
    }

    @GetMapping("/edit/id={id}")
    public String edit(Model model, @PathVariable int id) {
        model.addAttribute("article", ArticleService.getArticleById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Article article, RedirectAttributes redirect) {
        article.setCreatedDate(new Date());
        ArticleService.updateArticle(article);
        redirect.addFlashAttribute("notify", "Cập nhật thành công");
        return "redirect:/article/list";
    }

    @GetMapping("/delete/id={id}")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        ArticleService.deleteArticle(id);
        redirect.addFlashAttribute("notify", "Xóa thành công");
        return "redirect:/article/list";
    }

    @GetMapping("/detail/id={id}")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("article", ArticleService.getArticleById(id));
        return "detail";
    }

    @PostMapping("/search")
    public String search(String search, Model model) {
        model.addAttribute("articles", ArticleService.search(search));
        model.addAttribute("search", search);
        return "list";
    }



}
