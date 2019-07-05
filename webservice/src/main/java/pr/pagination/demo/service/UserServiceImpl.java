package pr.pagination.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pr.pagination.demo.command.UserSearchCommand;
import pr.pagination.demo.model.UserModel;
import pr.pagination.demo.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public UserModel save(UserModel save) {
        return repository.save(save);
    }

    @Override
    public List<UserModel> findAll(UserSearchCommand searchCommand) {
        return repository.findAll(searchCommand);
    }

    @Override
    public Page<UserModel> findPageable(UserSearchCommand searchCommand, Pageable pageable) {
        return repository.findBy(searchCommand, pageable);
    }
}
