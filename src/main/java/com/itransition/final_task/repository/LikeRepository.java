package com.itransition.final_task.repository;

import com.itransition.final_task.models.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {


    boolean existsByUserIdAndItemId(Long userId, Long itemId);

    void deleteLikeByUserIdAndItemId(Long userId, Long itemId);
}