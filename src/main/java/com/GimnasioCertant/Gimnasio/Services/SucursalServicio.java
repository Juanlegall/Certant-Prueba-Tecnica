package com.GimnasioCertant.Gimnasio.Services;

import com.GimnasioCertant.Gimnasio.Models.Sucursal;
import com.GimnasioCertant.Gimnasio.Repositorys.SucursalRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalServicio {

    @Autowired
    private SucursalRepositorio sucursalRepositorio;

    public List<Sucursal> ListarSucursales() {
        return sucursalRepositorio.findAll();
    }

    public Sucursal buscarxId(int id) {
        return sucursalRepositorio.findById(id).orElse(null);
    }

    public Sucursal altaSucursal(Sucursal sucursal) {
        return sucursalRepositorio.save(sucursal);
    }

    public void bajaSucursal(int id) {
        sucursalRepositorio.deleteById(id);
    }
}

