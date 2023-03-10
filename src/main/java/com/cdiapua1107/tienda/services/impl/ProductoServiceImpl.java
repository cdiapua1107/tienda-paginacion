package com.cdiapua1107.tienda.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cdiapua1107.tienda.dao.ProductosDAO;
import com.cdiapua1107.tienda.model.Producto;
import com.cdiapua1107.tienda.services.ProductosService;

@Service
public class ProductoServiceImpl implements ProductosService {

    @Autowired
    ProductosDAO productosDAO;

    @Override
    public Page<Producto> findAll(Pageable page) {
        return productosDAO.findAll(page);
    }

    @Override
    public Producto findById(int codigo) {
        return productosDAO.findById(codigo);
    }

    @Override
    public void insert(Producto Producto) {
        productosDAO.insert(Producto);
    }

    @Override
    public void update(Producto producto) {
        productosDAO.update(producto);

        if (producto.getImagen() != null && producto.getImagen().length > 0) {
            productosDAO.updateImage(producto);
        }
    }

    @Override
    public void delete(int codigo) {
        productosDAO.delete(codigo);
    }

}
