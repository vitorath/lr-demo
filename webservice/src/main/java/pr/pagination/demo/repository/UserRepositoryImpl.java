package pr.pagination.demo.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import pr.pagination.demo.command.UserSearchCommand;
import pr.pagination.demo.model.UserModel;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository{

    private final UserSpringData springData;

    @Override
    public UserModel save(UserModel save) {
        return springData.save(save);
    }

    @Override
    public List<UserModel> findAll(UserSearchCommand searchCommand) {
        return springData.findAll(UserSpecification.findByUserSaleSearchCommand(searchCommand));
    }

    @Override
    public Page<UserModel> findBy(UserSearchCommand searchCommand, Pageable pageable) {
        return springData.findAll(UserSpecification.findByUserSaleSearchCommand(searchCommand), pageable);
    }

}
