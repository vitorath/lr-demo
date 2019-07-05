package pr.pagination.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pr.pagination.demo.command.UserSearchCommand;
import pr.pagination.demo.model.UserModel;

import java.util.List;

public interface UserRepository {

    UserModel save(UserModel save);

    List<UserModel> findAll(UserSearchCommand searchCommand);

    Page<UserModel> findBy(UserSearchCommand searchCommand, Pageable pageable);

}
