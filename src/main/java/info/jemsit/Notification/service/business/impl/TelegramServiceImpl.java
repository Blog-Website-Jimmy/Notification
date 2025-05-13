package info.jemsit.Notification.service.business.impl;

import info.jemsit.Notification.model.request.TelegramMessageRequest;
import info.jemsit.Notification.service.business.TelegramService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TelegramServiceImpl implements TelegramService {
    @Value("${telegram.token}")
    private String botToken;

    @Value("${telegram.chatId}")
    private String chatId;
    @Override
    public void sendMessageToTelegram(TelegramMessageRequest request) {
        String message = String.format("""
                Full Name: %s
                Email: %s
                Subject: %s
                Message: %s
                """, request.getFullName(), request.getEmail(), request.getSubject(), request.getMessage());
        String url = "https://api.telegram.org/bot" + botToken + "/sendMessage";
        RestTemplate restTemplate = new RestTemplate();
        String requestUrl = url + "?chat_id=" + chatId + "&text=" + message;
        ResponseEntity<String> response = restTemplate.getForEntity(requestUrl, String.class);
        if (response.getStatusCode().is2xxSuccessful()) System.out.println("Telegram message was send!");
        else  System.out.println("Error sending Telegram message!");
    }

    @Override
    public void sendVisitedCountToTelegram(int count) {
        String url = "https://api.telegram.org/bot" + botToken + "/sendMessage";
        RestTemplate restTemplate = new RestTemplate();
        String requestUrl = url + "?chat_id=" + chatId + "&text=" + "Count: " + count;
        ResponseEntity<String> response = restTemplate.getForEntity(requestUrl, String.class);
        if (response.getStatusCode().is2xxSuccessful()) System.out.println("Telegram message was send!");
        else  System.out.println("Error sending Telegram message!");
    }
}
