package info.jemsit.Notification.controller;

import info.jemsit.Notification.model.request.TelegramMessageRequest;
import info.jemsit.Notification.service.business.TelegramService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("telegram")
public class TelegramController {
    private final TelegramService telegramService;

    public TelegramController(TelegramService telegramService) {
        this.telegramService = telegramService;
    }

    @PostMapping("send")
    public ResponseEntity<?> sendToTelegram(@RequestBody TelegramMessageRequest telegramMessageRequest) {
        telegramService.sendMessageToTelegram(telegramMessageRequest);
        return ResponseEntity.ok("Message has beed send");
    }

    @PostMapping("visited")
    public void sendVisitedCountToTelegram(@RequestParam int count) {
        telegramService.sendVisitedCountToTelegram(count);
    }


}
