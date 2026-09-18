package gustus.roadmap.tasktracker;

import gustus.roadmap.tasktracker.Service.AppTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Scanner;


@SpringBootApplication
@EnableJpaAuditing
@RequiredArgsConstructor
public class TasktrackerApplication implements CommandLineRunner {
	private final AppTaskService service;

	public static void main(String[] args) {
		SpringApplication.run(TasktrackerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		boolean running = true;


		while(running) {
			String input = scanner.nextLine();
			String[] parts = input.split(" ", 2); // splits into at most 2 pieces
			String command = parts[0];
			switch(command) {

				case "add" -> {
					if (parts.length <= 1) {
						System.out.println("Added task must have a description, try again");
					} else {
						service.createTask(parts[1]);
					}
				}

				case "exit" -> running = false;
			}
		}
	}
}

