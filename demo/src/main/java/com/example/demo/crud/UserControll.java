package com.example.demo.crud;
import org.jvnet.hk2.annotations.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.repository.CrudRepository;

@RestController
@RequestMapping("/user")
class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("")
    public ResponseEntity<?> getList() {
        return new ResponseEntity<Object>(userService.getUserList(), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody User user) {
        return new ResponseEntity<User>(userService.save(user), HttpStatus.CREATED);
    }
    @PatchMapping("")
    public ResponseEntity<?> update(@RequestBody User user) {
        return new ResponseEntity<User>(userService.save(user), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable("id") int id) {
        userService.remove(id);
        return new ResponseEntity<User>(HttpStatus.ACCEPTED);
    }
}

interface UserRepository extends CrudRepository<User, Integer> {
    void delete(int id);
}
@Service
class UserService {
    @Autowired
    private UserRepository userRepo;
    public Iterable<User> getUserList() {
        return userRepo.findAll();
    }
    public User save(User user) {
        return userRepo.save(user);
    }
    public void remove(int id) {
        userRepo.delete(id);
    }
}