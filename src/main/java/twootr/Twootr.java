package main.java.twootr;

import java.util.Optional;

public class Twootr {

  private final UserRepository userRepository;
  private final TwootRepository twootRepository;

  public Twootr(final UserRepository userRepository, final TwootRepository twootRepository) {
    this.userRepository = userRepository;
    this.twootRepository = twootRepository;
  }

  public Optional<SenderEndPoint> onLogon(String userId, String password,
      ReceiverEndPoint receiver){

    return null;
  }

  public FollowStatus onFollow(final User user, final String userId){
    return null;
  }

  public Position onSendTwoot(final String id, final User user, final String content) {
    String userId = user.getId();
    Twoot twoot = twootRepository.add(id, userId, content);
    user.followers()
        .filter(User::isLoggedOn)
        .forEach(follower -> {
          follower.receiveTwoot(twoot);
          userRepository.update(follower);
        });

    return twoot.getPosition();
  }


}
