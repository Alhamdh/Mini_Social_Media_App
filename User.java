import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private ArrayList<Post> posts;
    private ArrayList<User> followers;
    private ArrayList<User> following;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        posts = new ArrayList<>();
        followers = new ArrayList<>();
        following = new ArrayList<>();
    }

    // Get username
    public String getUsername() {
        return username;
    }

    // Get password
    public String getPassword() {
        return password;
    }

    // Add post
    public void addPost(Post post) {
        posts.add(post);
    }

    // Get posts
    public ArrayList<Post> getPosts() {
        return posts;
    }

    // Add follower
    public void addFollower(User user) {
        followers.add(user);
    }

    // Get followers
    public ArrayList<User> getFollowers() {
        return followers;
    }

    // Add following
    public void addFollowing(User user) {
        following.add(user);
    }

    // Get following
    public ArrayList<User> getFollowing() {
        return following;
    }
}