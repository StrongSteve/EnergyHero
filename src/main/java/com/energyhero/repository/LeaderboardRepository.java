package com.energyhero.repository;

import com.energyhero.domain.Leaderboard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by mrchampel on 14.02.2016.
 */
public interface LeaderboardRepository extends JpaRepository<Leaderboard, Long> {
    List<Leaderboard> findAll();

}
