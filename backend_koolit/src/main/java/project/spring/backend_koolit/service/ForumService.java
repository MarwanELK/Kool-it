package project.spring.backend_koolit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.spring.backend_koolit.model.Discussion;
import project.spring.backend_koolit.repository.DiscussionRepository;

import java.util.List;

@Service
public class ForumService {

    @Autowired
    private DiscussionRepository discussionRepository;

    public List<Discussion> getAllDiscussions() {
        return discussionRepository.findAll();
    }

    public Discussion createDiscussion(Discussion discussion) {
        // Implement the logic to create a new discussion
        return discussionRepository.save(discussion);
    }

    // Add other service methods
}
