package com.cozentus.TrainingTrackingAPP.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cozentus.TrainingTrackingAPP.Service.CourseService;
import com.cozentus.TrainingTrackingAPP.Service.TopicService;
import com.cozentus.TrainingTrackingAPP.dto.CourseTopicDTO;
import com.cozentus.TrainingTrackingAPP.model.Course;
import com.cozentus.TrainingTrackingAPP.model.Topic;

@RestController
@RequestMapping("/topics")
@CrossOrigin("*")
public class TopicController {
@Autowired
    private TopicService topicService;
@Autowired
private CourseService courseService;
    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("/{topicId}")
    public Topic getTopicById(@PathVariable int topicId) {
        return topicService.getTopicById(topicId);
    }
    @PostMapping
    public Topic createTopic(@RequestBody Topic topic) {
        return topicService.createTopic(topic);
    }

//    @PutMapping("/{topicId}")
//    public Topic updateTopic(@PathVariable int topicId, @RequestBody Topic topic) {
//        topic.setTopicId(topicId);
//        return topicService.updateTopic(topic);
//    }

//    @DeleteMapping("/{topicId}")
//    public void deleteTopic(@PathVariable int topicId) {
//        topicService.deleteTopic(topicId);
//    }

//add topic through courseid //here we can add multiple topic in course    
    @PostMapping("/add")
    public void addTopicsToCourse(@RequestBody CourseTopicDTO courseTopicDTO) {
        int courseid = courseTopicDTO.getCourseid();
//        List<Topic> topics = courseTopicDTO.getTopics();
         Topic topic = new Topic();
        Course course = new Course();
        course.setCourseid(courseid); // Set the course ID

//        for (Topic topic : topics) {
            topic.setCourse(course);
            topic.setOrderNum(courseTopicDTO.getOrderNum());
            topic.setTopicCode(courseTopicDTO.getTopicCode());
            topic.setTopicName(courseTopicDTO.getTopicName());
            topic.setTopicPercentageCompleted(courseTopicDTO.getTopicPercentageCompleted());
            topic.setTopicSummary(courseTopicDTO.getTopicSummary());
            topic.setTheoryTime(courseTopicDTO.getTheoryTime());
            topic.setPracticalTime(courseTopicDTO.getPracticalTime());
            topic.setContent(courseTopicDTO.getContent());
            topicService.addTopic(topic);
//        }
    }
    @PutMapping("/update")
    public ResponseEntity<String> updateTopicAndCourse(@RequestBody CourseTopicDTO courseTopicDTO) {
        boolean success = topicService.updateTopicAndCourse(courseTopicDTO);
        
        if (success) {
            return ResponseEntity.ok("Topic and Course updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Topic not found");
        }
       
    }
    
    @DeleteMapping("/delete/{topicId}")
    public ResponseEntity<String> deleteTopic(@PathVariable int topicId) {
        boolean success = topicService.deleteTopic(topicId);

        if (success) {
            return ResponseEntity.ok("Topic deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Topic not found");
        }
    }
}
