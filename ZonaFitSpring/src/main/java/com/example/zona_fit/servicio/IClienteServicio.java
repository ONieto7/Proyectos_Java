package com.example.zona_fit.servicio;

import com.example.zona_fit.modelo.Cliente;
import java.util.List;

import java.util.List;

public interface IClienteServicio {
    public List<Cliente> listarCliente();

    public Cliente buscarClientePorId(Integer idCliente);

    public void guardarCliente(Cliente cliente);

    public void eliminarCliente(Cliente cliente);

 }
