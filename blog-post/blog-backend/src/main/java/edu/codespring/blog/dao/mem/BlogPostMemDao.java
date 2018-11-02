package edu.codespring.blog.dao.mem;

import edu.codespring.blog.dao.BlogPostDao;
import edu.codespring.blog.model.BlogPost;

import java.util.Collection;
import java.util.stream.Collectors;

public class BlogPostMemDao extends AbstractMemDao<BlogPost> implements BlogPostDao {
    @Override
    public Collection<BlogPost> findByTitle(String title) {
        return objs.values().stream()
                .filter(bp -> bp.getTitle().contains(title)).collect(Collectors.toList());
    }
}
