package fr.formation.repository;

import fr.formation.model.Lecture;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class LectureRepository {
    private final Map<Long, Lecture> data = new HashMap<>();

    public Optional<Lecture> findById(Long id) {
        return Optional.ofNullable(data.get(id));
    }

    public List<Lecture> findAll() {
        return new ArrayList<>(data.values());
    }

    public void save(Lecture lecture) {
        data.put(lecture.getId(), lecture);
    }
}