import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UserServiceImplTest {

    public UserDAO userDao = mock(UserDAO.class);
    public SecurityService securityService = mock(SecurityService.class);
    public User user = mock(User.class);

    @Test
    public void AssignPasswordMustUpdateTheNewPassword() /*throws Exception*/ {
        UserServiceImpl usi = new UserServiceImpl(userDao, securityService);
        usi.assignPassword(user);
        verify(userDao).updateUser(user);

    }
}
