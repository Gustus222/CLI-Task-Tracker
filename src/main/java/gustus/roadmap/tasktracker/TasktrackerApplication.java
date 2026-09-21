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
		System.out.println("List of cmds: add, update, mark-inprogress, mark-done, list(all, done, todo, inprogress), exit");

		while(running) {
			String input = scanner.nextLine();
			String[] twoParts = input.split(" ", 2);
			String[] threeParts = input.split(" ", 3);
			String command = twoParts[0];
			switch(command) {
				case "add" -> {
					if (twoParts.length <= 1) {
						System.out.println("Added task must have a description, try again");
					} else {
						service.createTask(twoParts[1]);
					}
				}

				case "update" -> {
					if (threeParts.length <= 1) {
						System.out.println("Updated task must have an ID, try again");
					} else {
						service.updateTask(Long.parseLong(threeParts[1]), threeParts[2]);
					}
				}

				case "mark-inprogress" -> {
					if (twoParts.length <= 1) {
						System.out.println("Added task must have a description, try again");
					} else {
						service.markInProgress(Long.parseLong(twoParts[1]));
					}
				}

				case "mark-done" -> {
					if (twoParts.length <= 1) {
						System.out.println("Added task must have a description, try again");
					} else {
						service.markDone(Long.parseLong(twoParts[1]));
					}
				}

				case "list" -> {
					if (twoParts.length <= 1) {
						System.out.println("You must add what to tasks to list, try again");
					} else if (twoParts[1].equalsIgnoreCase("done")){
						service.listDone();
					} else if (twoParts[1].equalsIgnoreCase("todo")){
						service.listTodo();
					} else if (twoParts[1].equalsIgnoreCase("inprogress")){
						service.listInProgress();
					} else if (twoParts[1].equalsIgnoreCase("all")){
						service.listAll();
					} else {
						System.out.println("Unrecognized Status, try again");
					}
				}

                case "exit" -> {
					System.out.println("exiting the application");
					running = false;
				}
                default -> {
                    System.out.println("Unrecognized Command, try again");
                }

            }
		}
	}
}

