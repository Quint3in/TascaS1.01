package repository;

import model.Writer;

import java.util.Collection;

public interface WriterRepository {
    void save(Writer writer);

    Writer findByDni(String dni);

    void deleteByDni(String dni);

    Collection<Writer> findAll();
}


