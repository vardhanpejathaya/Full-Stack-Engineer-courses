package com.vardhan.student.dal;

import com.vardhan.student.dal.entity.Student;
import com.vardhan.student.dal.repository.StudentRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class StudentdalApplicationTests {

    @Autowired
    StudentRepo studentRepo;

    @Test
    void createEntity() {
        Student student = new Student();
        student.setName("vardhan");
        student.setCourse("java");
        student.setFee(1000);

        studentRepo.save(student);
    }

    @Test
    void selectEntity() {
        Student student = new Student();
        student.setId(1l);

        System.out.println(studentRepo.findById(student.getId()));
    }

    @Test
    void updateEntity() {
        Student student = new Student();

        Optional<Student> student1 = studentRepo.findById(2l);
        if (student1.isPresent()) {
            student1.get().setName("Rama");
            studentRepo.save(student1.get());
        }

    }

	@Test
	void deleteEntity() {
		Student student = new Student();

		Optional<Student> student1 = studentRepo.findById(2l);
		if (student1.isPresent()) {
			studentRepo.delete(student1.get());
		}

	}



}
