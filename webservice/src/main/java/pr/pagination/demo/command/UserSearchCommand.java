package pr.pagination.demo.command;

import lombok.Data;

@Data
public class UserSearchCommand {

    private String name;
    private Integer age;
    private Boolean isFemale;

}
