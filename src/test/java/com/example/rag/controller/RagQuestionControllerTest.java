package com.example.rag.controller;

import com.example.rag.dto.AskRequest;
import com.example.rag.dto.AskResponse;
import com.example.rag.service.RagQuestionService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class RagQuestionControllerTest {

    private final RagQuestionService service = mock(RagQuestionService.class);
    private final RagQuestionController controller = new RagQuestionController(service);

    @Test
    void shouldReturnAnswer() {
        when(service.ask("How to fix 504?"))
                .thenReturn("Check the load balancer timeout and backend health.");

        AskResponse response = controller.ask(new AskRequest("How to fix 504?"));

        assertThat(response.answer())
                .isEqualTo("Check the load balancer timeout and backend health.");

        verify(service).ask("How to fix 504?");
    }
}