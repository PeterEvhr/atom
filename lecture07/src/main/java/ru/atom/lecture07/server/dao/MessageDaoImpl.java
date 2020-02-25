package ru.atom.lecture07.server.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.atom.lecture07.server.model.Message;
import ru.atom.lecture07.server.model.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class MessageDaoImpl implements MessageDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Message getByUser(User user) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Message> criteria = builder.createQuery(Message.class);
        Root<Message> from = criteria.from(Message.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("user_id"), user));
        TypedQuery<Message> typed = em.createQuery(criteria);
        Message message;
        try {
            message = typed.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return message;

    }

    @Override
    public void save(Message message) {

        em.persist(message);
    }

    @Override
    public List<Message> findAll()
    {
        return em.createQuery("Select t from " + Message.class.getSimpleName() + " t").getResultList();
    }

}
