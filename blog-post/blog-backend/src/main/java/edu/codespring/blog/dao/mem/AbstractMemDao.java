package edu.codespring.blog.dao.mem;

import edu.codespring.blog.dao.Dao;
import edu.codespring.blog.dao.RepositoryException;
import edu.codespring.blog.model.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public abstract class AbstractMemDao<T extends BaseEntity> implements Dao<T> {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractMemDao.class);

    protected final Map<Long, T> objs = new HashMap<>();
    protected final AtomicLong generatedIdCount = new AtomicLong(0);

    @Override
    public void create(T obj) throws RepositoryException {
        if (obj == null) {
            throw new RepositoryException("create failed");
        }
        Long id = generatedIdCount.incrementAndGet();
        obj.setId(id);
        objs.put(id, obj);
        LOG.info("Created {} with ID {}", obj.getClass().getSimpleName(), id);
    }

    @Override
    public List<T> findAll() throws RepositoryException {
       return null;
    }

    @Override
    public T findById(Long id) throws RepositoryException {
        return objs.get(id);
    }
}
