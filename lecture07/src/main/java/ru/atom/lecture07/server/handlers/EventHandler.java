package ru.atom.lecture07.server.handlers;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import ru.atom.lecture07.server.request.RequestProcessor;
import ru.atom.lecture07.server.service.ChatService;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/events")
public class EventHandler extends TextWebSocketHandler implements WebSocketHandler {

    @Autowired
    private RequestProcessor processor;
    @Autowired
    private ChatService service;

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(EventHandler.class);

    private WebSocketSession session;
    private List<WebSocketSession> sessionList = new LinkedList<WebSocketSession>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        this.session = session;
        this.sessionList.add(session);
        log.info("Connection established");
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        String rMessage = processor.process(message.toString());
        if (rMessage != "")
                this.sendMessageToAll(rMessage);
        log.info(message.toString());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        this.sessionList.remove(session);
        log.info("Connection closed");
    }
    private void sendMessageToAll(String message) {
        sessionList.forEach(s->{
            if (s == session)
                return;
            try {
                session.sendMessage(new TextMessage(message));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
