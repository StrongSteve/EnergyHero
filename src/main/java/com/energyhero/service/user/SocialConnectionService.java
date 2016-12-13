package com.energyhero.service.user;

import com.energyhero.transfer.UserConnection;

/**
 * Created by starke on 22.02.2016.
 */
public interface SocialConnectionService {
    public UserConnection getSocialConnectionForUserWithName(String userName);
}
