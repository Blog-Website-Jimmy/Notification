package info.jemsit.Notification.service.business;

import info.jemsit.Notification.model.request.TelegramMessageRequest;

public interface TelegramService {
    void sendMessageToTelegram(TelegramMessageRequest request);
    void sendVisitedCountToTelegram(int count);

}
