package com.example.rag.controller;

import com.example.rag.service.DocumentIngestionService;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

class DocumentIngestionControllerTest {

    private final DocumentIngestionService service = mock(DocumentIngestionService.class);
    private final DocumentIngestionController controller = new DocumentIngestionController(service);

    @Test
    void shouldUploadDocumentSuccessfully() throws Exception {
        MockMultipartFile file = new MockMultipartFile(
                "file",
                "test.pdf",
                "application/pdf",
                "fake pdf content".getBytes()
        );

        ResponseEntity<String> response = controller.uploadDocument(file);

        verify(service).ingestPdf(file);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
    }
}