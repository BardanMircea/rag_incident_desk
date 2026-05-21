package com.example.rag;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Disabled("Full Spring context requires local Ollama and pgvector")
class RagApplicationTests {

	@Test
	void contextLoads() {
	}

}
