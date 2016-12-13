package com.energyhero.service.game;

import com.energyhero.transfer.CurrentUser;
import com.energyhero.domain.Game;

import java.util.List;

/**
 * Created by starke on 14.02.2016.
 */
public interface GameService {

    List<Game> getAllAvailableGames(CurrentUser user);

    Game getGameById(Long id);

    Game saveGame(Game game);

    void deleteGame(Long id);

    boolean canAccessGame(CurrentUser currentUser, Long questionId);
}
