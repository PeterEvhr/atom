package ru.atom.lecture07.server.dao;

import ru.atom.lecture07.server.model.User;
import ru.atom.lecture07.server.model.Message;

import java.util.List;

public interface MessageDao {
    User getByUser(User user);

    void save(Message message);

    List<Message> findAll();
}
