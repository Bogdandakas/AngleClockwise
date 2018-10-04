package tasks.employer.service;

import java.util.List;

public interface DBService<T> {

    List<T> getAll();

    T save(T obj);

}
