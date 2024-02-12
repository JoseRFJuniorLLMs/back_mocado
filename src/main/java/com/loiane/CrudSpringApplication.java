package com.loiane;

import com.loiane.course.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.loiane.course.enums.Category;
import com.loiane.course.enums.Status;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	@Profile("test")
	CommandLineRunner initData(CourseRepository courseRepository, StudentRepository studentRepository) {
		return args -> {
			populateCourses(courseRepository);
			populateStudents(studentRepository);
		};
	}

	private void populateCourses(CourseRepository courseRepository) {
		courseRepository.deleteAll();
		for (int i = 1; i < 10; i++) {
			Course c = new Course();
			c.setName("English for Interviews " + i);
			c.setCategory(Category.FRONT_END);
			c.setStatus(Status.ACTIVE);

			for (int j = 1; j < 10; j++) {
				Lesson lesson = new Lesson();
				lesson.setName("Lesson B1 " + j);
				lesson.setYoutubeUrl("Fj3Zvf-N4bk");
				c.addLesson(lesson);
			}

			courseRepository.save(c);
		}
	}

	private void populateStudents(StudentRepository studentRepository) {
		studentRepository.deleteAll();
		for (int i = 1; i <= 10; i++) {
			Student student = new Student();
			student.setName("Fred " + i);
			student.setEmail("email@example.com");
			student.setTax_identification_number("123456789");
			student.setPersonal_identification_number("987654321");
			student.setLogin("fred" + i);
			student.setPassword("password123");
			studentRepository.save(student);
		}
	}

}
