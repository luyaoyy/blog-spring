package com.blue.ws;

import com.alibaba.fastjson.JSONObject;
import com.blue.pojo.Word;
import com.blue.service.UserService;
import com.blue.service.WordService;
import com.blue.utils.WordBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/chat/{username}")
@Controller
public class GroupChatEndPoint {

    private static UserService userService;
    private static WordService wordService;

    @Autowired
    public void setUserService(UserService userService) {
        GroupChatEndPoint.userService = userService;
    }

    @Autowired
    public void setWordService(WordService wordService) {
        GroupChatEndPoint.wordService = wordService;
    }

    //用线程安全的map来保存当前用户
    public static Map<String, GroupChatEndPoint> onLineUsers = new ConcurrentHashMap<>();//这里必须是静态的
    private Session session;//一个用户对应一个session，通过该对象可以发送消息给指定用户，不能设置为静态，每个ChatEndPoint有一个session才能区分.(websocket的session)

    //建立连接时调用
    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) {
        this.session = session;
        onLineUsers.put(username, this);
        String message = JSONObject.toJSONString(WordBean.wordUtil(true, null, onLineUsers.keySet()));
        broadcastWord(message);//更新前端用户列表
    }

    //服务器接收到消息时调用
    @OnMessage
    public void onMessage(String strMessage) {
        WordBean wordBean = JSONObject.parseObject(strMessage, WordBean.class);
        Word word=new Word();
        Date date=new Date();
        word.setContent((String) wordBean.getMessage());
        word.setUserId(wordBean.getUserInfo().getUserId());
        wordService.addWord(word);
        word.setWordCreateTime(date);
        word.setUserInfo(wordBean.getUserInfo());
        String wordStr = JSONObject.toJSONString(WordBean.wordUtil(false, null, word));
        broadcastWord(wordStr);
    }

    //退出连接时调用，即用户session关闭，用户退出
    @OnClose
    public void onClose(@PathParam("username") String username) {
        onLineUsers.remove(username);
        String message = JSONObject.toJSONString(WordBean.wordUtil(true, null, onLineUsers.keySet()));//更新前端用户列表
        broadcastWord(message);
    }

    private void broadcastWord(String message) {//消息广播
        Set<String> names = onLineUsers.keySet();
        for (String name : names) {//每一个在线用户都发送系统message
            GroupChatEndPoint groupChatEndPoint = onLineUsers.get(name);
            try {
                groupChatEndPoint.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
