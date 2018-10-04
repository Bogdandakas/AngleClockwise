package tasks.employer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tasks.employer.entity.Log;
import tasks.employer.repository.LogRepository;

import java.util.List;

@Service
public class LogDBServiceImpl implements DBService<Log> {

    @Autowired
    private LogRepository repository;

    @Override
    public List<Log> getAll() {
        return repository.findAll();
    }

    @Override
    public Log save(Log log) {
        return repository.save(log);
    }

}
