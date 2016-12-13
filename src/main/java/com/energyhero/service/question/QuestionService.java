package com.energyhero.service.question;

import com.energyhero.service.exception.NoMoreQuestionException;
import com.energyhero.transfer.CurrentUser;
import com.energyhero.domain.Question;

import java.util.List;

/**
 * Created by starke on 11.02.2016.
 */
public interface QuestionService {
    Iterable<Question> listAllQuestions(CurrentUser user);

    Question getQuestionById(Long id);

    Question saveQuestion(Question question);

    void deleteQuestion(Long id);

    Question getRandomQuestionExcludingUserAndQuestionIds(List<Long> userIdsToExclude, List<Long> questionIdsToExclude) throws NoMoreQuestionException;

    Question getRandomQuestionFromUserAndExcludingQuestionIds(Long userId, List<Long> questionIdsToExclude) throws NoMoreQuestionException;

    boolean canAccessQuestion(CurrentUser currentUser, Long questionId);

    long countQuestionsByUser(CurrentUser user);

    long countQuestions();
}
