package com.cozentus.TrainingTrackingAPP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cozentus.TrainingTrackingAPP.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
    // You can define custom query methods if needed
}
