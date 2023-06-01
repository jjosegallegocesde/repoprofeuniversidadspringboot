package com.example.colegioelite.servicios;

import com.example.colegioelite.entidades.Acudiente;
import com.example.colegioelite.entidades.Estudiante;
import com.example.colegioelite.entidades.Materia;
import com.example.colegioelite.repositorios.EstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EstudianteServicio implements ServicioBase<Estudiante> {

    @Autowired
    private EstudianteRepositorio estudianteRepositorio;

    @Override
    public List<Estudiante> buscarTodos() throws Exception {
        try{
            List<Estudiante>estudiantes=estudianteRepositorio.findAll();
            return estudiantes;

        }catch(Exception error){
            throw new Exception(error.getMessage());

        }
    }

    @Override
    public Estudiante buscarPorId(Integer id) throws Exception {
        try{
            Optional<Estudiante> estudianteOpcional =estudianteRepositorio.findById(id);
            if(estudianteOpcional.isPresent()){
                return estudianteOpcional.get();
            }else{
                throw new Exception("Usuario no encontrado");
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Estudiante registrar(Estudiante datosARegistrar) throws Exception {
        try{
            Estudiante estudianteGuardado=estudianteRepositorio.save(datosARegistrar);
            return estudianteGuardado;
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Estudiante actualizar(Integer id, Estudiante datosNuevos) throws Exception {
        return null;
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        return false;
    }
}
