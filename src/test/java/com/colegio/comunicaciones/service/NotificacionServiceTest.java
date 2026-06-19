package com.colegio.comunicaciones.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.colegio.comunicaciones.exception.ResourceNotFoundException;
import com.colegio.comunicaciones.model.Notificacion;
import com.colegio.comunicaciones.repository.NotificacionRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NotificacionServiceTest {

    @Mock
    private NotificacionRepository notificacionRepository;

    @InjectMocks
    private NotificacionService notificacionService;

    @Test
    void crearNotificacionCorrectamente() {
        Notificacion notificacion = Notificacion.builder()
                .titulo("Nueva comunicacion")
                .descripcion("Tiene un nuevo mensaje")
                .destinatario("maria.perez@gmail.com")
                .tipo("INFORMATIVA")
                .build();

        when(notificacionRepository.save(any(Notificacion.class))).thenAnswer(inv -> inv.getArgument(0));

        Notificacion resultado = notificacionService.crear(notificacion);

        assertNotNull(resultado.getFechaCreacion());
        assertFalse(resultado.getLeida());
    }

    @Test
    void buscarNotificacionPorId() {
        Notificacion notificacion = Notificacion.builder().id(1L).titulo("Aviso").build();
        when(notificacionRepository.findById(1L)).thenReturn(Optional.of(notificacion));

        Notificacion resultado = notificacionService.buscarPorId(1L);

        assertEquals(1L, resultado.getId());
    }

    @Test
    void listarNotificacionesPorDestinatario() {
        List<Notificacion> lista = List.of(Notificacion.builder().id(1L).build());
        when(notificacionRepository.findByDestinatario("maria.perez@gmail.com")).thenReturn(lista);

        List<Notificacion> resultado = notificacionService.listarPorDestinatario("maria.perez@gmail.com");

        assertEquals(1, resultado.size());
    }

    @Test
    void marcarNotificacionComoLeida() {
        Notificacion notificacion = Notificacion.builder().id(1L).leida(false).build();
        when(notificacionRepository.findById(1L)).thenReturn(Optional.of(notificacion));
        when(notificacionRepository.save(any(Notificacion.class))).thenAnswer(inv -> inv.getArgument(0));

        Notificacion resultado = notificacionService.marcarComoLeida(1L);

        assertTrue(resultado.getLeida());
    }

    @Test
    void errorCuandoNoExisteUnaNotificacion() {
        when(notificacionRepository.findById(88L)).thenReturn(Optional.empty());

        ResourceNotFoundException ex = assertThrows(
                ResourceNotFoundException.class,
                () -> notificacionService.buscarPorId(88L));

        assertEquals("Notificacion no encontrada con id: 88", ex.getMessage());
    }
}
