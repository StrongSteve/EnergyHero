package com.energyhero.service.leaderboard;

import com.energyhero.domain.Leaderboard;
import com.energyhero.repository.LeaderboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mrchampel on 20.02.2016.
 */
@Service
public class LeaderboardServiceImpl implements LeaderboardService {

    private LeaderboardRepository leaderboardRepository;

    @Autowired
    public void LeaderboardRepository(LeaderboardRepository leaderboardRepository) {
        this.leaderboardRepository = leaderboardRepository;
    }

    @Override
    public List<Leaderboard> getAll() {
        return leaderboardRepository.findAll();
    }
}
