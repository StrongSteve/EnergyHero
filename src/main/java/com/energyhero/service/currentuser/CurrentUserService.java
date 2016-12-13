package com.energyhero.service.currentuser;

import com.energyhero.transfer.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
