package com.stackroute.controller;


import com.stackroute.domain.Blog;
import com.stackroute.service.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/* Add annotation to declare this class as REST Controller */
@RestController
public class BlogController {
    private BlogServiceImpl service;
    @Autowired
    public BlogController(BlogServiceImpl service) {
        this.service = service;
    }
    /* Provide implementation code for these methods */

    /*This method should save blog and return savedBlog Object */
    @PostMapping("/blog")
    public ResponseEntity<?> saveBlog(@RequestBody Blog blog) {
        return new ResponseEntity<Blog>(service.saveBlog(blog), HttpStatus.CREATED);
    }

    /*This method should fetch all blogs and return the list of all blogs */
    @GetMapping("/blog")
    public ResponseEntity<?> getAllBlogs() {
        return (ResponseEntity<?>) service.getAllBlogs();
    }

    /*This method should fetch the blog taking its id and return the respective blog */
    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable int id){
        return new ResponseEntity<Blog>( service.getBlogById(id),HttpStatus.OK);
    }

    /*This method should delete the blog taking its id and return the deleted blog */
    @DeleteMapping("/blog/{id}")
    public ResponseEntity<Blog> getBlogAfterDeleting(@PathVariable int id) {
        return new ResponseEntity<Blog>(service.deleteBlog(id),HttpStatus.OK);
    }

    /*This method should update blog and return the updatedBlog */
    @PutMapping("/blog/{id}")
    public ResponseEntity<Blog> updateBlog(@RequestBody Blog blog,@PathVariable int id) {
        return new ResponseEntity<Blog>(service.updateBlog(blog),HttpStatus.OK);
    }
}