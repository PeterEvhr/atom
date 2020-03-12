package ru.atom.lecture07.server.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import ru.atom.lecture07.server.model.Message;
import ru.atom.lecture07.server.model.User;
import ru.atom.lecture07.server.service.ChatService;
import ru.atom.lecture07.server.util.JsonHelper;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RequestProcessor {

    @Autowired
    private ChatService chatService;

    public String process(String jsonStr) {
        String rMessage = "Hi !";
        RequestMessage message = JsonHelper.fromJson(jsonStr, RequestMessage.class);
        switch (message.getTopic()) {
            case LOGIN:
                break;
            case LOGOUT:
                break;
            case MESSAGE:
                break;
            default:
                throw new Error("Unsupported operation");
        }
        return rMessage;
    }
    public void login(String name) {
        if (name.length() < 1) {
//            return ResponseEntity.badRequest()
 //                   .body("Too short name");
        }
        if (name.length() > 20) {
//            return ResponseEntity.badRequest()
//                    .body("Too long name");
        }

        User alreadyLoggedIn = chatService.getLoggedIn(name);
        if (alreadyLoggedIn != null) {
//            return ResponseEntity.badRequest()
//                    .body("Already logged in");
        }
        chatService.login(name);
//        return ResponseEntity.badRequest()
//                .body("Not logged in");
    }

    public void logout(String name) {

        User alreadyLoggedIn = chatService.getLoggedIn(name);
        if (alreadyLoggedIn != null) {
            chatService.logout(alreadyLoggedIn);
//            return ResponseEntity.ok().build();
        }
 //       return ResponseEntity.badRequest()
 //               .body("Not logged in");

    }
    public void online() {

        List<User> online = chatService.getOnlineUsers();
        String responseBody = online.stream()
                .map(User::getLogin)
                .collect(Collectors.joining("\n"));

 //       return ResponseEntity.ok().body(responseBody);
    }
    public void say(String name, String msg) {
        User user = chatService.getLoggedIn(name);
        if (user == null) {
//            return ResponseEntity.badRequest()
//                    .body("nOT logged in");
        }
        chatService.addMessage(user, msg);
        List<Message> messages = chatService.getAllMessage();
        String responseBody =  messages.stream()
                .map(Message::toString)
                .collect(Collectors.joining("\n"));

 //       return ResponseEntity.ok().body(responseBody);
    }
    public void chat() {
        List<Message> messages = chatService.getAllMessage();
        String responseBody = messages.stream()
                .map(Message::toString)
                .collect(Collectors.joining("\n"));

 //       return ResponseEntity.ok().body(responseBody);
    }
}
