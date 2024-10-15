package scratchgame_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.scratchgame.config.ScratchGameConfig;
import com.scratchgame.definition.User;

//Basic testing nothin really special here
public class ScratchGameConfigTest {

    private ScratchGameConfig gameConfig;
    private User mockUser;

    @Before
    public void setUp() {
        gameConfig = new ScratchGameConfig();
        mockUser = mock(User.class);
        when(mockUser.getName()).thenReturn("TestUser");
        when(mockUser.getBetAmount()).thenReturn(100.0);
        gameConfig.setUser(mockUser);
    }

    @Test
    public void testUserInitialization() {
        User user = gameConfig.getUser();
        assertNotNull(user);
        assertEquals("TestUser", user.getName());
    }


    @Test
    public void testBetAmountChange() {
        when(mockUser.getBetAmount()).thenReturn(200.0);
        User user = gameConfig.getUser();
        assertEquals(200.0, user.getBetAmount(), 0.001);
    }
}
