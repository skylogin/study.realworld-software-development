package test.java.twootr;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import main.java.twootr.ReceiverEndPoint;
import main.java.twootr.Twoot;

public class MockReceiverEndPoint implements ReceiverEndPoint {

  private final List<Twoot> receivedTwoots = new ArrayList<>();

  @Override
  public void onTwoot(Twoot twoot) {
    receivedTwoots.add(twoot);
  }

  public void verifyOnTwoot(final Twoot twoot){
    assertThat(receivedTwoots, contains(twoot));
  }
}
