package pr.pagination.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import pr.pagination.demo.model.UserModel;
import pr.pagination.demo.repository.UserRepository;

import java.util.stream.IntStream;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class StoreDatas implements CommandLineRunner {

    private final UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        log.info("SAVING....");
        repository.save(new UserModel(null, "João", 15, false));
        repository.save(new UserModel(null, "Ana", 18, true));
        repository.save(new UserModel(null, "Pedro", 18, false));
        repository.save(new UserModel(null, "Maria", 21, true));
        repository.save(new UserModel(null, "Carlos", 15, false));
        repository.save(new UserModel(null, "Ana", 30, true));
        repository.save(new UserModel(null, "João", 28, false));
        repository.save(new UserModel(null, "Vitor", 25, false));
        repository.save(new UserModel(null, "Caio", 25, true));
        repository.save(new UserModel(null, "Leonardo", 23, false));
        repository.save(new UserModel(null, "Rosana", 40, true));
        repository.save(new UserModel(null, "Durval", 30, false));
        repository.save(new UserModel(null, "Pedro", 15, false));
        repository.save(new UserModel(null, "Vitor", 15, false));
        repository.save(new UserModel(null, "Francilli", 25, true));
        repository.save(new UserModel(null, "Letícia", 28, true));
        repository.save(new UserModel(null, "Carla", 24, true));
        repository.save(new UserModel(null, "Caio", 25, false));
        for (int i=0; i < 100000; i++) {
            repository.save(new UserModel(null, "Caio", 25, false));
        }
        log.info("SAVED!!!");
    }

}
