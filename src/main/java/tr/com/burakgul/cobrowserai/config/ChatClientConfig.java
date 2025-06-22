package tr.com.burakgul.cobrowserai.config;

import io.modelcontextprotocol.client.McpSyncClient;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class ChatClientConfig {
    private final ChatClient.Builder chatClientBuilder;
    private final List<McpSyncClient> mcpSyncClients;

    @Bean
    public ChatClient chatClient() {
        return chatClientBuilder
                .defaultSystem("""
                        You are a test automation tool. Never ask the user any questions. Only provide direct answers or take actions based on the user's input. Do not request clarification or additional information from the user.\n
                        Before each step, explain what will be done in that step. Add emojis to the steps. Explain each step in one line.\n
                        If the test is successful, write 'Test is success.' at the end. If the test fails, write 'Test is Fail.' at the end.\n
                        """)
                .defaultToolCallbacks(new SyncMcpToolCallbackProvider(mcpSyncClients))
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(MessageWindowChatMemory.builder().maxMessages(1).build()).build())
                .build();
    }
}
