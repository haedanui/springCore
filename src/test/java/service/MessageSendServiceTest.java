package service;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.domain.User;
import com.nhnacademy.edu.springframework.sender.impl.DoorayMessageSender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.*;

public class MessageSendServiceTest {

    @Test
    void checkNameAndText(){
        DoorayHookSender doorayHookSender = mock(DoorayHookSender.class);

        DoorayMessageSender doorayMessageSender = new DoorayMessageSender(doorayHookSender);

        User user = new User("유승진", "아무튼 내용");

        doorayMessageSender.sendMessage(user, "TestMessage");

        ArgumentCaptor<DoorayHook> argumentCaptor = ArgumentCaptor.forClass(DoorayHook.class);
        verify(doorayHookSender).send(argumentCaptor.capture());

        DoorayHook doorayHook = argumentCaptor.getValue();

        Assertions.assertEquals("유승진", doorayHook.getBotName());
        Assertions.assertEquals("아무튼 내용", doorayHook.getText());
    }

    @Test
    void testDoorayMessageSenderTrue() {
        DoorayHookSender doorayHookSender = mock(DoorayHookSender.class);
        DoorayMessageSender doorayMessageSender = new DoorayMessageSender(doorayHookSender);
        User user = mock(User.class);

        boolean actual = doorayMessageSender.sendMessage(user, "TestMessage");
        Assertions.assertTrue(actual);
    }

    @Test
    void testDoorayMessageSenderFalse() {
        DoorayHookSender doorayHookSender = mock(DoorayHookSender.class);
        DoorayMessageSender doorayMessageSender = new DoorayMessageSender(doorayHookSender);
        User user = mock(User.class);

        doThrow(new RuntimeException("message send fail")).when(doorayHookSender).send(any());

        boolean actual = doorayMessageSender.sendMessage(user, "TestMessage");
        Assertions.assertFalse(actual);
    }

}
