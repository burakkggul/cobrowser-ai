package tr.com.burakgul.cobrowserai.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/prompts")
@RequiredArgsConstructor
public class PromptStreamController {

    private final ChatClient chatClient;

    @GetMapping
    public SseEmitter getPrompts(@RequestParam("prompt") String prompt) {
        SseEmitter emitter = new SseEmitter(200_000L);
        chatClient.prompt(prompt)
                .stream().content().subscribe(s ->{
                    try {
                        if(s == null || s.isEmpty()) {
                            return;
                        }
                        String modifiedString = s.replace(" ", "\\u0020");
                        emitter.send(modifiedString);
                    } catch (IllegalStateException | IOException e) {
                        System.out.println(e.getMessage());
                    }
                });
        return emitter;
    }
}