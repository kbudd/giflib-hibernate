package com.teamtreehouse.giflib.web.controller;

import com.teamtreehouse.giflib.model.Category;
import com.teamtreehouse.giflib.service.CategoryService;
import com.teamtreehouse.giflib.web.Color;
import com.teamtreehouse.giflib.web.FlashMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

import static com.teamtreehouse.giflib.web.FlashMessage.Status;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    // Index of all categories
    @SuppressWarnings("unchecked")
    @RequestMapping("/categories")
    public String listCategories(Model model) {
        // TODO: Get all categories
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        return "category/index";
    }

    // Single category page
    @RequestMapping("/categories/{categoryId}")
    public String category(@PathVariable Long categoryId, Model model) {
        // TODO: Get the category given by categoryId
        Category category = null;

        model.addAttribute("category", category);
        return "category/details";
    }

    // Form for adding a new category
    @RequestMapping("categories/add")
    public String formNewCategory(Model model) {
        // TODO: Add model attributes needed for new form
        if(!model.containsAttribute("category")) {
            model.addAttribute("category",  new Category());
        }
        model.addAttribute("colors", Color.values());

        return "category/form";
    }

    // Form for editing an existing category
    @RequestMapping("categories/{categoryId}/edit")
    public String formEditCategory(@PathVariable Long categoryId, Model model) {
        // TODO: Add model attributes needed for new form

        return "category/form";
    }

    // Update an existing category
    @RequestMapping(value = "/categories/{categoryId}", method = RequestMethod.POST)
    public String updateCategory() {
        //TODO: Update a category if valid data received

        //TODO: Redirect browser to /categories

        return null;
    }

    // Add a category
    @RequestMapping(value = "/categories", method = RequestMethod.POST)
    public String addCategory(@Valid Category category, BindingResult result, RedirectAttributes redirectAttributes) {
        //TODO: Add category if valid data received
        if(result.hasErrors()) {
            // Include validation errors upon redirect
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.category",result);

            // Add category if invalid data  was received
            redirectAttributes.addFlashAttribute("category", category);

            // Redirect back to form

            return "redirect:/categories/add";
        }
        categoryService.save(category);

        redirectAttributes.addFlashAttribute("flash",new FlashMessage("Category successfully added", Status.SUCCESS));

        //TODO: Redirect browser to /categories
        return "redirect:/categories";
    }


    // Delete an existing category
    @RequestMapping(value = "/categories/{categoryId}/delete", method = RequestMethod.POST)
    public String deleteCategory(@PathVariable Long categoryId) {

        // TODO: Delete category if it contains no GIFs

        // TODO: Redirect browser to /categories
        return null;
    }
}