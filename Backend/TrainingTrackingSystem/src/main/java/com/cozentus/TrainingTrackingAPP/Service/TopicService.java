package com.cozentus.TrainingTrackingAPP.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cozentus.TrainingTrackingAPP.dto.CourseTopicDTO;
import com.cozentus.TrainingTrackingAPP.model.Course;
import com.cozentus.TrainingTrackingAPP.model.Topic;
import com.cozentus.TrainingTrackingAPP.repository.CourseRepository;
import com.cozentus.TrainingTrackingAPP.repository.TopicRepository;

@Service
public class TopicService {

    private final TopicRepository topicRepository;
@Autowired
CourseRepository courseRepository;
    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public Topic getTopicById(int topicId) {
        return topicRepository.findById(topicId).orElse(null);
    }

    public Topic createTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public Topic updateTopic(Topic topic) {
        return topicRepository.save(topic);
    }

   
    public void addTopic(Topic topic) {
        // You can implement any validation or business logic here before saving the topic.
        topicRepository.save(topic);
    }
    public boolean updateTopicAndCourse(CourseTopicDTO courseTopicDTO) {
        Optional<Topic> existingTopic = topicRepository.findById(courseTopicDTO.getTopicId());
//        Optional<Course> existingCourse = courseRepository.findById(courseTopicDTO.getCourseId());

        if (existingTopic.isPresent()) {
            Topic topicToUpdate = existingTopic.get();
//            Course courseToUpdate = existingCourse.get();

            // Update the topic details
            topicToUpdate.setTopicCode(courseTopicDTO.getTopicCode());
            topicToUpdate.setTopicName(courseTopicDTO.getTopicName());
            topicToUpdate.setTopicPercentageCompleted(courseTopicDTO.getTopicPercentageCompleted());
            topicToUpdate.setTopicSummary(courseTopicDTO.getTopicSummary());
            topicToUpdate.setTheoryTime(courseTopicDTO.getTheoryTime());
            topicToUpdate.setPracticalTime(courseTopicDTO.getPracticalTime());
            topicToUpdate.setContent(courseTopicDTO.getContent());

            // Update the associated course ID
//            topicToUpdate.setCourse(courseToUpdate);

            

            topicRepository.save(topicToUpdate);
            
            return true;
        }

        return false;
    }
    public boolean deleteTopic(int topicId) {
        Optional<Topic> existingTopic = topicRepository.findById(topicId);

        if (existingTopic.isPresent()) {
            topicRepository.delete(existingTopic.get());
            return true;
        }

        return false;
    }
   
}