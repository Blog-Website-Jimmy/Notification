package info.jemsit.Notification.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TelegramMessageRequest {
    private String fullName;
    private String email;
    private String subject;
    private String message;
}
