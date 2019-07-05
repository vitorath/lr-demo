package pr.pagination.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pr.pagination.demo.model.UserModel;

public interface UserSpringData extends JpaRepository<UserModel, Long>, JpaSpecificationExecutor<UserModel> {
}
