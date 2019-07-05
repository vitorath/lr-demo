package pr.pagination.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pr.pagination.demo.command.UserSearchCommand;
import pr.pagination.demo.model.UserModel;
import pr.pagination.demo.service.UserService;

import java.util.List;

@Controller
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @CrossOrigin
    @GetMapping()
    public ResponseEntity<Page<UserModel>> findPageable(UserSearchCommand searchCommand, @PageableDefault Pageable pageable) {
        return ResponseEntity.ok(userService.findPageable(searchCommand, pageable));
    }

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<UserModel>> findAll(UserSearchCommand searchCommand) {
        return ResponseEntity.ok(userService.findAll(searchCommand));
    }

}
