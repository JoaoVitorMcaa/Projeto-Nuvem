package com.projetojoaquim.imagem_app;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ImageController {

    @CrossOrigin(origins = "*")
    @GetMapping("/api/foto")
    public ResponseEntity<Resource> enviarFoto() throws IOException {
        // Agora apontamos para a pasta static
        Resource img = new ClassPathResource("static/jokamedanota.jpeg");

        if (!img.exists()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(img);
    }
}
