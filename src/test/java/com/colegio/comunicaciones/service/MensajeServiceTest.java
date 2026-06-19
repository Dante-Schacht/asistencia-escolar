package com.colegio.comunicaciones.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.colegio.comunicaciones.exception.ResourceNotFoundException;
import com.colegio.comunicaciones.model.Mensaje;
import com.colegio.comunicaciones.repository.MensajeRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MensajeServiceTest {

    @Mock
    private MensajeRepository mensajeRepository;

    @InjectMocks
    private MensajeService mensajeService;

    @Test
    void crearMensajeCorrectamente() {
        Mensaje mensaje = Mensaje.builder()
                .asunto("Reunion")
                .contenido("Contenido")
                .remitente("profesor@colegio.cl")
                .destinatario("maria.perez@gmail.com")
                .tipoDestinatario("APODERADO")
                .prioridad("MEDIA")
                .build();

        when(mensajeRepository.save(any(Mensaje.class))).thenAnswer(inv -> inv.getArgument(0));

        Mensaje resultado = mensajeService.crear(mensaje);

        assertNotNull(resultado.getFechaEnvio());
        assertFalse(resultado.getLeido());
        verify(mensajeRepository).save(mensaje);
    }

    @Test
    void buscarMensajePorId() {
        Mensaje mensaje = Mensaje.builder().id(1L).asunto("Aviso").build();
        when(mensajeRepository.findById(1L)).thenReturn(Optional.of(mensaje));

        Mensaje resultado = mensajeService.buscarPorId(1L);

        assertEquals(1L, resultado.getId());
    }

    @Test
    void listarMensajesPorDestinatario() {
        List<Mensaje> mensajes = List.of(Mensaje.builder().id(1L).build());
        when(mensajeRepository.findByDestinatario("maria.perez@gmail.com")).thenReturn(mensajes);

        List<Mensaje> resultado = mensajeService.listarPorDestinatario("maria.perez@gmail.com");

        assertEquals(1, resultado.size());
    }

    @Test
    void marcarMensajeComoLeido() {
        Mensaje mensaje = Mensaje.builder().id(1L).leido(false).fechaEnvio(LocalDateTime.now()).build();
        when(mensajeRepository.findById(1L)).thenReturn(Optional.of(mensaje));
        when(mensajeRepository.save(any(Mensaje.class))).thenAnswer(inv -> inv.getArgument(0));

        Mensaje resultado = mensajeService.marcarComoLeido(1L);

        assertTrue(resultado.getLeido());
    }

    @Test
    void errorCuandoNoExisteUnMensaje() {
        when(mensajeRepository.findById(77L)).thenReturn(Optional.empty());

        ResourceNotFoundException ex = assertThrows(
                ResourceNotFoundException.class,
                () -> mensajeService.buscarPorId(77L));

        assertEquals("Mensaje no encontrado con id: 77", ex.getMessage());
    }
}
