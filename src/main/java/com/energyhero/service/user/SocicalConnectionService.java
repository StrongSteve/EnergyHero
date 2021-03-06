package com.energyhero.service.user;

import com.energyhero.repository.SocialConnectionRepository;
import com.energyhero.transfer.UserConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by starke on 22.02.2016.
 */
@Service
public class SocicalConnectionService implements SocialConnectionService {

    private SocialConnectionRepository socialConnectionRepository;

    @Autowired
    public void setSocialConnectionRepository(SocialConnectionRepository socialConnectionRepository) {
        this.socialConnectionRepository = socialConnectionRepository;
    }

    @Override
    public UserConnection getSocialConnectionForUserWithName(String userName) {
        return socialConnectionRepository.getUserConnection(userName);
    }
}
