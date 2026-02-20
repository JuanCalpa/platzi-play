package com.platzi.play.domain.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface PlatziPlayAiService {

    @UserMessage("Genera un saludo de bienvenida a la plataforma de gestion de peliculas {{plataform}}. Usa menos de 120 caracteres")
    String generateGreeting(@V("plataform") String plataform);

    @SystemMessage("""
            Eres un experto en cine que recomienda peliculas personalizadas segun los gustos del usuario.
            Debes recomendar maximo 3 peliculas.
            No incluyas peliculas que esten por fuera de la plataforma PlatziPlay
            """)
    String generateMovieSuggestion(@UserMessage String userMessage);
}
