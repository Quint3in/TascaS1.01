package repository;

import model.Writer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InMemoryWriterRepository implements WriterRepository {
    private final Map<String, Writer> writers = new HashMap<>();

    @Override
    public void save(Writer writer) {
        writers.put(writer.getDni(), writer);
    }

    @Override
    public Writer findByDni(String dni) {
        return writers.get(dni);
    }

    @Override
    public void deleteByDni(String dni) {
        writers.remove(dni);
    }

    @Override
    public Collection<Writer> findAll() {
        return writers.values();
    }
}


