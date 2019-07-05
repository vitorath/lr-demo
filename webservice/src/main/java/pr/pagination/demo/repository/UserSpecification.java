package pr.pagination.demo.repository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import pr.pagination.demo.command.UserSearchCommand;
import pr.pagination.demo.model.UserModel;

import static java.util.Objects.isNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserSpecification {

    private static Specification<UserModel> findByName(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> !isNull(name) ? criteriaBuilder.equal(root.get("name"), name) : criteriaBuilder.conjunction();
    }

    private static Specification<UserModel> findByAge(Integer age) {
        return (root, criteriaQuery, criteriaBuilder) -> !isNull(age) ? criteriaBuilder.equal(root.get("age"), age) : criteriaBuilder.conjunction();
    }

    private static Specification<UserModel> findByIsFemale(Boolean isFemale) {
        return (root, criteriaQuery, criteriaBuilder) -> !isNull(isFemale) ? criteriaBuilder.equal(root.get("isFemale"), isFemale) : criteriaBuilder.conjunction();
    }

    public static Specification<UserModel> findByUserSaleSearchCommand(UserSearchCommand command) {
        return findByName(command.getName())
                .and(findByAge(command.getAge()))
                .and(findByIsFemale(command.getIsFemale()));
    }

}
