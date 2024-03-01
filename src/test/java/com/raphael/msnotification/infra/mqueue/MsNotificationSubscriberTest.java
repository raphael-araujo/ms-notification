package com.raphael.msnotification.infra.mqueue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raphael.msnotification.entity.Notification;
import com.raphael.msnotification.repository.NotificationRepository;
import com.raphael.msnotification.resources.utils.JsonConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class MsNotificationSubscriberTest {

    @Autowired
    private ObjectMapper mapper;

    @Mock
    private NotificationRepository notificationRepository;

    private MsNotificationSubscriber msNotificationSubscriber;

    @BeforeEach
    public void setup() {
        this.msNotificationSubscriber = new MsNotificationSubscriber(notificationRepository);
    }

    @Test
    public void receiveNotificationSubscriberTest() throws Exception {
        String payload = JsonConverter.convertIntoJson("teste@email.com", "CREATE");
        Notification notificationPayload = mapper.readValue(payload, Notification.class);

        msNotificationSubscriber.receberSolicitacaoEmissao(payload);
        verify(notificationRepository, times(1)).save(notificationPayload);
    }

    @Test
    public void receiveNotificationSubscriberTestWithInvalidData() {
        assertThrows(Exception.class, () -> {
            msNotificationSubscriber.receberSolicitacaoEmissao(null);
        });
        verify(notificationRepository, times(0)).save(any(Notification.class));
    }
}
