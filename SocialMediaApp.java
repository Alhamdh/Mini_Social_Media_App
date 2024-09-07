import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SocialMediaApp extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signUpButton;
    private JTextArea postField;
    private JButton postButton;
    private JList<String> timelineList;
    private DefaultListModel<String> timelineModel;
    private ArrayList<User> users;
    private User currentUser;

    public SocialMediaApp() {
        users = new ArrayList<>();
        currentUser = null;

        // Create GUI components
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        signUpButton = new JButton("Sign Up");
        postField = new JTextArea(10, 20);
        postButton = new JButton("Post");
        timelineList = new JList<>();
        timelineModel = new DefaultListModel<>();

        // Add event listeners
        loginButton.addActionListener(new LoginListener());
        signUpButton.addActionListener(new SignUpListener());
        postButton.addActionListener(new PostListener());

        // Create layout
        JPanel loginPanel = new JPanel();
        loginPanel.add(new JLabel("Username:"));
        loginPanel.add(usernameField);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        loginPanel.add(signUpButton);

        JPanel postPanel = new JPanel();
        postPanel.add(new JLabel("Post:"));
        postPanel.add(postField);
        postPanel.add(postButton);

        JPanel timelinePanel = new JPanel();
        timelinePanel.add(new JLabel("Timeline:"));
        timelinePanel.add(new JScrollPane(timelineList));

        // Add panels to frame
        add(loginPanel, BorderLayout.NORTH);
        add(postPanel, BorderLayout.CENTER);
        add(timelinePanel, BorderLayout.SOUTH);

        // Set up frame
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Event listeners
    private class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Check if user exists and password is correct
            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    currentUser = user;
                    updateTimeline();
                    return;
                }
            }

            JOptionPane.showMessageDialog(null, "Invalid username or password");
        }
    }

    private class SignUpListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Check if username is available
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    JOptionPane.showMessageDialog(null, "Username already taken");
                    return;
                }
            }

            // Create new user
            User newUser = new User(username, password);
            users.add(newUser);
            currentUser = newUser;
            updateTimeline();
        }
    }

    private class PostListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String postText = postField.getText();

            // Create new post
            Post newPost = new Post(postText, currentUser);
            currentUser.addPost(newPost);
            updateTimeline();
        }
    }

    // Update timeline
    private void updateTimeline() {
        timelineModel.clear();

        // Add posts from current user and their followers
        for (Post post : currentUser.getPosts()) {
            timelineModel.addElement(post.getText());
        }

        for (User user : currentUser.getFollowers()) {
            for (Post post : user.getPosts()) {
                timelineModel.addElement(post.getText());
            }
        }

        timelineList.setModel(timelineModel);
    }

    public static void main(String[] args) {
        new SocialMediaApp();
    }
}