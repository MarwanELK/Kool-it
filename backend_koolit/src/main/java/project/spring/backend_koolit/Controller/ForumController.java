package project.spring.backend_koolit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.spring.backend_koolit.model.Discussion;
import project.spring.backend_koolit.service.ForumService;

import java.util.List;

@RestController
@RequestMapping("/forum")
public class ForumController {

    @Autowired
    private ForumService forumService;

    @GetMapping("/discussions")
    public ResponseEntity<List<Discussion>> getAllDiscussions() {
        List<Discussion> discussions = forumService.getAllDiscussions();
        return new ResponseEntity<>(discussions, HttpStatus.OK);
    }

    @PostMapping("/createDiscussion")
    public ResponseEntity<Discussion> createDiscussion(@RequestBody Discussion discussion) {
        Discussion createdDiscussion = forumService.createDiscussion(discussion);
        return new ResponseEntity<>(createdDiscussion, HttpStatus.CREATED);
    }

    // Add other endpoints for comments, user authentication, etc.
}
