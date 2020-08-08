package test.java.twootr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static test.java.twootr.TestData.TWOOT;
import static test.java.twootr.TestData.twootAt;

import java.util.Optional;
import main.java.twootr.FollowStatus;
import main.java.twootr.Position;
import main.java.twootr.ReceiverEndPoint;
import main.java.twootr.SenderEndPoint;
import main.java.twootr.Twoot;
import main.java.twootr.TwootRepository;
import main.java.twootr.Twootr;
import org.junit.Test;

public class TwootrTest {

  private static final Position POSITION_1 = new Position(0);

  private final ReceiverEndPoint receiverEndPoint = mock(ReceiverEndPoint.class);

  private Twootr twootr;
  private SenderEndPoint endPoint;
  private TwootRepository twootRepository;


  @Test
  public void shouldBeAbleToAuthenticateUser(){
    logon();
  }

  @Test
  public void shouldNotAuthenticateUserWithWrongPassword(){
    final Optional<SenderEndPoint> endPoint = twootr.onLogon(TestData.USER_ID, "bad password", receiverEndPoint);

    assertFalse(endPoint.isPresent());
  }

  @Test
  public void shouldFollowValidUser(){
    logon();

    final FollowStatus followStatus = endPoint.onFollow(TestData.OTHER_USER_ID);

    assertEquals(FollowStatus.SUCCESS, followStatus);
  }

  @Test
  public void shouldNotDuplicateFollowValidUser(){
    logon();

    endPoint.onFollow(TestData.OTHER_USER_ID);

    final FollowStatus followStatus = endPoint.onFollow(TestData.OTHER_USER_ID);
    assertEquals(FollowStatus.ALREADY_FOLLOWING, followStatus);
  }

  @Test
  public void shouldReceiveTwootsFromFollowedUser(){
    final String id = "1";

    logon();

    endPoint.onFollow(TestData.OTHER_USER_ID);

    final SenderEndPoint otherEndPoint = otherLogon();
    otherEndPoint.onSendTwoot(id, TWOOT);

    verify(twootRepository).add(id, TestData.OTHER_USER_ID, TWOOT);
    verify(receiverEndPoint).onTwoot(new Twoot(id, TestData.OTHER_USER_ID, TWOOT, new Position(0)));

  }

  @Test
  public void shouldReceiveReplayOfTwootsAfterLogoff(){
    final String id = "1";

    userFollowsOtherUser();

    final SenderEndPoint otherEndPoint = otherLogon();
    otherEndPoint.onSendTwoot(id, TWOOT);

    logon();

    verify(receiverEndPoint).onTwoot(twootAt(id, POSITION_1));
  }






  private SenderEndPoint otherLogon(){
    return logon(TestData.OTHER_USER_ID, mock(ReceiverEndPoint.class));
  }

  private void userFollowsOtherUser() {
    logon();

    endPoint.onFollow(TestData.OTHER_USER_ID);

    endPoint.onLogoff();
  }

  private void logon(){
    this.endPoint = logon(TestData.USER_ID, receiverEndPoint);
  }

  private SenderEndPoint logon(final String userId, final ReceiverEndPoint receiverEndPoint){
    final Optional<SenderEndPoint> endPoint = twootr.onLogon(userId, TestData.PASSWORD, receiverEndPoint);
    assertTrue("Failed to logon", endPoint.isPresent());
    return endPoint.get();
  }

}
