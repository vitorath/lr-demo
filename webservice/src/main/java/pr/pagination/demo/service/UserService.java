package pr.pagination.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pr.pagination.demo.command.UserSearchCommand;
import pr.pagination.demo.model.UserModel;

import java.util.List;

public interface UserService {

    UserModel save(UserModel save);

    List<UserModel> findAll(UserSearchCommand searchCommand);

    Page<UserModel> findPageable(UserSearchCommand searchCommand, Pageable pageable);
}
