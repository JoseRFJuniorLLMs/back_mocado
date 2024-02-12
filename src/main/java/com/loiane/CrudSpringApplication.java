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
	CommandLineRunner initData(CourseRepository courseRepository, StudentRepository studentRepository, PrimeTargetTextRepository primeTargetTextRepository) {
		return args -> {
			populateCourses(courseRepository);
			populateStudents(studentRepository);
			populatePrimeTargetText(primeTargetTextRepository);
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


	private void populatePrimeTargetText(PrimeTargetTextRepository primeTargetTextRepository) {
		primeTargetTextRepository.deleteAll();
		String[] primes = {"love", "happiness", "knowledge", "freedom", "success", "peace", "friendship", "health", "creativity", "passion"};
		String[] targets = {"heart", "mind", "soul", "life", "journey", "world", "adventure", "destiny", "dreams", "purpose"};
		String[] text = {
				"Embark on a journey of self-discovery and personal growth with our English courses.",
				"Unlock the door to a world of endless opportunities with our English language courses.",
				"Expand your horizons and broaden your mind by enrolling in our English language programs.",
				"Experience the joy and fulfillment of learning English with our comprehensive courses.",
				"Achieve academic and professional success with our tailor-made English language courses.",
				"Find inner peace and tranquility as you immerse yourself in the beauty of the English language.",
				"Forge lifelong friendships and connections while mastering the art of English communication.",
				"Prioritize your health and well-being by investing in your English language skills.",
				"Unleash your creativity and imagination through the power of English language education.",
				"Ignite your passion for learning and seize control of your destiny with our English courses."
		};

		for (int i = 0; i < 10; i++) {
			PrimeTargetText primeTargetText = new PrimeTargetText();
			primeTargetText.setPrime(primes[i]);
			primeTargetText.setTarget(targets[i]);
			primeTargetText.setText(text[i]);
			primeTargetText.setStatus(Status.ACTIVE); // Definindo o status como ACTIVE para todos os registros
			primeTargetTextRepository.save(primeTargetText);
		}
	}

}
