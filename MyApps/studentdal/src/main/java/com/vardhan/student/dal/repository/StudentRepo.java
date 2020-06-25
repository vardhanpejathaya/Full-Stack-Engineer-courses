package com.vardhan.student.dal.repository;

import com.vardhan.student.dal.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student,Long> {
}
