package com.epam.itweek.boosenger.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.Callable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.validation.support.BindingAwareModelMap;

import com.epam.itweek.boosenger.repository.MessageRepository;

@RunWith(MockitoJUnitRunner.class)
public class BoosengerControllerTest {

    @InjectMocks
    private BoosengerController testingInstance = new BoosengerController();

    @Mock
    private MessageRepository messageRepository;

    @Test
    public void shouldReturnPathToView() throws Exception {
        Callable<String> callableResult = testingInstance.createMessage("someUsername", new BindingAwareModelMap());
        assertThat(callableResult.call(), is(equalTo("messaging/messages")));
    }
}