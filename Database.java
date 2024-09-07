import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    private HashMap<String, User> users;

    public Database() {
        users = new HashMap<>();
    }

    // Add user
    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    // Get user
    public User getUser(String username) {
        return users.get(username);
    }

    // Add post
    public void addPost(Post post) {
        // Implement adding post to database
    }

    // Get posts
    public ArrayList<Post> getPosts() {
        // Implement getting posts from database
        return new ArrayList<>();
    }
}