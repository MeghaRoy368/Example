package com.stackroute.service;


import com.stackroute.domain.Blog;
import com.stackroute.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* Add annotation to declare this class as Service class.
 * Also it should implement BlogService Interface and override all the implemented methods.*/
@Service
public class BlogServiceImpl implements BlogService{
    private BlogRepository repository;
    @Autowired
    public BlogServiceImpl(BlogRepository repository) {
        this.repository = repository;
    }

    @Override
    public Blog saveBlog(Blog blog) {
        return repository.save(blog);
    }

    @Override
    public List<Blog> getAllBlogs() {
        return (List<Blog>) repository.findAll();
    }

    @Override
    public Blog getBlogById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Blog deleteBlog(int id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public Blog updateBlog(Blog blog) {
        return repository.save(blog);
    }
}