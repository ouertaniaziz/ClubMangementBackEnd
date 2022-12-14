package com.ClubManagement.club.generic;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
public class ImplementationGeneric<T,ID> implements InterfaceGeneric<T,ID>{
    @Autowired
    public GenericRepository<T,ID> genericRepository;

    @Override
    public List<T> findAll() throws Exception {
        try {
            return (List<T>) genericRepository.findAll();
        } catch (Exception err) {
            System.out.println("Un erreur survenue : "+err);
        }
        return null;
    }
    @Override
    public T save(T entity) throws Exception {
        try {
            return genericRepository.save(entity);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void delete(ID id) throws Exception {
        try {
            genericRepository.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
    }


    @Override
    public T retrieve(ID id) throws Exception {
        T res=genericRepository.findById(id).orElse(null);
        try {
            return res;
        } catch (Exception err) {
            System.out.println("Un erreur survenue"+ err);
          }
        return null;
    }

    @Override
    public T update(T entity) throws Exception {
            try {
                return genericRepository.save(entity);
            } catch (Exception err1) {
                System.out.println("Une erreur survenue"+err1);
            }
       return entity;
    }
}
