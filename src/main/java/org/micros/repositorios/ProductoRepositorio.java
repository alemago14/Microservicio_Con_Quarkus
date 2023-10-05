package org.micros.repositorios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.micros.entidades.Producto;

@ApplicationScoped
public class ProductoRepositorio {
    
    @Inject
    EntityManager em;

    @Transactional
    public void createdProduct(Producto p){
        em.persist(p);

    }

    @Transactional
    public void deleteProduct(Producto p){
        em.remove(p);

    }

    @Transactional
    public List<Producto> listProduct(){
        List<Producto> products = em.createQuery("select p from Producto p").getResultList();
        return products;
    }
}
