package com.colegio.comunicaciones.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.colegio.comunicaciones.exception.ResourceNotFoundException;
import com.colegio.comunicaciones.model.Apoderado;
import com.colegio.comunicaciones.repository.ApoderadoRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ApoderadoServiceTest {

    @Mock
    private ApoderadoRepository apoderadoRepository;

    @InjectMocks
    private ApoderadoService apoderadoService;

    @Test
    void crearApoderadoCorrectamente() {
        Apoderado apoderado = Apoderado.builder()
                .id(1L)
                .rut("11222333-4")
                .nombre("Maria")
                .apellido("Perez")
                .correo("maria.perez@gmail.com")
                .telefono("+56912345678")
                .direccion("Los Carrera 123")
                .estudianteId(1L)
                .parentesco("Madre")
                .build();

        when(apoderadoRepository.save(apoderado)).thenReturn(apoderado);

        Apoderado resultado = apoderadoService.crear(apoderado);

        assertEquals("Maria", resultado.getNombre());
        verify(apoderadoRepository).save(apoderado);
    }

    @Test
    void buscarApoderadoPorId() {
        Apoderado apoderado = Apoderado.builder().id(1L).nombre("Maria").build();
        when(apoderadoRepository.findById(1L)).thenReturn(Optional.of(apoderado));

        Apoderado resultado = apoderadoService.buscarPorId(1L);

        assertEquals(1L, resultado.getId());
    }

    @Test
    void listarApoderadosPorEstudianteId() {
        List<Apoderado> lista = List.of(
                Apoderado.builder().id(1L).estudianteId(10L).build(),
                Apoderado.builder().id(2L).estudianteId(10L).build());

        when(apoderadoRepository.findByEstudianteId(10L)).thenReturn(lista);

        List<Apoderado> resultado = apoderadoService.listarPorEstudianteId(10L);

        assertEquals(2, resultado.size());
    }

    @Test
    void errorCuandoNoExisteUnApoderado() {
        when(apoderadoRepository.findById(99L)).thenReturn(Optional.empty());

        ResourceNotFoundException ex = assertThrows(
                ResourceNotFoundException.class,
                () -> apoderadoService.buscarPorId(99L));

        assertEquals("Apoderado no encontrado con id: 99", ex.getMessage());
    }
}
