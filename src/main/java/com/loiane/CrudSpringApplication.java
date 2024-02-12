package com.loiane;

import com.loiane.course.*;
import com.loiane.course.course.Course;
import com.loiane.course.course.CourseRepository;
import com.loiane.course.phrase.PrimeTargetPhrase;
import com.loiane.course.phrase.PrimeTargetPhraseRepository;
import com.loiane.course.student.Student;
import com.loiane.course.student.StudentRepository;
import com.loiane.course.text.PrimeTargetText;
import com.loiane.course.text.PrimeTargetTextRepository;
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

	private void populatePrimeTargetPhrase(PrimeTargetPhraseRepository primeTargetPhraseRepository) {
		primeTargetPhraseRepository.deleteAll();

		String[] primes = {"CHEAT", "CHEAT", "CHEAT", "CHEAT", "CHEAT", "CHEAT", "CHEAT", "CHEAT", "CHEAT", "CHEAT"};
		String[] targets = {"FAIL", "FAIL", "FAIL", "FAIL", "FAIL", "FAIL", "FAIL", "FAIL", "FAIL", "FAIL"};
		String[] urls = {
				"https://storage.googleapis.com/priming_frase_wav/CHEAT_1.wav",
				"https://storage.googleapis.com/priming_frase_wav/CHEAT_2.wav",
				"https://storage.googleapis.com/priming_frase_wav/CHEAT_3.wav",
				"https://storage.googleapis.com/priming_frase_wav/CHEAT_4.wav",
				"https://storage.googleapis.com/priming_frase_wav/CHEAT_5.wav",
				"https://storage.googleapis.com/priming_frase_wav/CHEAT_6.wav",
				"https://storage.googleapis.com/priming_frase_wav/CHEAT_7.wav",
				"https://storage.googleapis.com/priming_frase_wav/CHEAT_8.wav",
				"https://storage.googleapis.com/priming_frase_wav/CHEAT_9.wav",
				"https://storage.googleapis.com/priming_frase_wav/CHEAT_10.wav"
		};
		String[] images = {
				"https://cdn.wizard.com.br/wp-content/uploads/2020/06/03192344/palavras…",
				"https://cdn.wizard.com.br/wp-content/uploads/2020/06/03192344/palavras…",
				"https://cdn.wizard.com.br/wp-content/uploads/2020/06/03192344/palavras…",
				"https://cdn.wizard.com.br/wp-content/uploads/2020/06/03192344/palavras…",
				"https://cdn.wizard.com.br/wp-content/uploads/2020/06/03192344/palavras…",
				"https://cdn.wizard.com.br/wp-content/uploads/2020/06/03192344/palavras…",
				"https://cdn.wizard.com.br/wp-content/uploads/2020/06/03192344/palavras…",
				"https://cdn.wizard.com.br/wp-content/uploads/2020/06/03192344/palavras…",
				"https://cdn.wizard.com.br/wp-content/uploads/2020/06/03192344/palavras…",
				"https://cdn.wizard.com.br/wp-content/uploads/2020/06/03192344/palavras…"
		};
		String[] phrases = {
				"1. My diet CHEATS are always FAILures.",
				"2. I CHEATed on my diet and ate a whole cake, what a FAIL.",
				"3. I tried CHEATing on a test but got caught and FAILed.",
				"4. I CHEATed on my taxes and FAILed to pay what I owed.",
				"5. I tried to CHEAT on my partner but got caught and it was a FAIL.",
				"6. I CHEATed at a game of cards but got caught and had to forfeit the …",
				"7. I CHEATed on my homework and got caught, what a FAIL.",
				"8. I CHEATed on my spouse and it was a huge FAIL.",
				"9. I CHEATed on my job application and got caught, FAIL.",
				"10. I CHEATed on my doctor and got caught, FAIL."
		};

		for (int i = 0; i < 10; i++) {
			PrimeTargetPhrase primeTargetPhrase = new PrimeTargetPhrase();
			primeTargetPhrase.setPrime(primes[i]);
			primeTargetPhrase.setTarget(targets[i]);
			primeTargetPhrase.getUrl().add(urls[i]);
			primeTargetPhrase.getImagem().add(images[i]);
			primeTargetPhrase.getPhrase().add(phrases[i]);
			primeTargetPhraseRepository.save(primeTargetPhrase);
		}
	}


}
